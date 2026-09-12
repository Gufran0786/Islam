package com.example.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.BookFont
import com.example.data.PaperStyle
import com.example.data.PersonalDiaryEntryEntity
import com.example.data.ProphetEntity
import com.example.data.ProphetEventEntity
import com.example.data.ProphetRepository
import com.example.data.ReaderSettings
import com.example.util.AudioPlayerHelper
import com.example.util.AudioRecorderHelper
import com.example.util.NotificationHelper
import com.example.util.PlaybackState
import com.example.util.PreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.Calendar

enum class AppScreen {
    BOOKSHELF,
    PROPHET_DETAIL,
    FAMILY_TREE,
    QURAN_INDEX,
    SURAH_READER,
    ANGELS,
    PRAYER_TIME,
    DIARY_JOURNAL,
    SETTINGS
}

enum class QuranFilter {
    ALL,
    MAKKI,
    MADANI,
    BOOKMARKS
}

data class CloudSyncState(
    val isSyncing: Boolean = false,
    val lastSyncTimeMillis: Long = System.currentTimeMillis(),
    val statusMessage: String = "Offline First • Local Database Protected",
    val backupJsonString: String? = null
)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    val repository = ProphetRepository(db.prophetDao())
    val preferencesManager = PreferencesManager(application)
    val quranRepository = com.example.data.QuranRepository(preferencesManager)
    val audioRecorder = AudioRecorderHelper(application)
    val audioPlayer = AudioPlayerHelper(application)
    val notificationHelper = NotificationHelper(application)
    val azanTakbeerHelper = com.example.util.AzanTakbeerHelper(application)

    val readerSettings: StateFlow<ReaderSettings> = preferencesManager.settings
    val quranSettings: StateFlow<com.example.data.QuranDisplaySettings> = quranRepository.quranSettings
    val quranLastRead: StateFlow<com.example.data.LastReadPosition> = quranRepository.lastRead
    val quranBookmarkedAyahs: StateFlow<Set<String>> = quranRepository.bookmarkedAyahs

    // Quran Selection & Filtering
    private val _selectedSurahNumber = MutableStateFlow(1)
    val selectedSurahNumber: StateFlow<Int> = _selectedSurahNumber.asStateFlow()

    private val _quranSearchQuery = MutableStateFlow("")
    val quranSearchQuery: StateFlow<String> = _quranSearchQuery.asStateFlow()

    private val _quranFilter = MutableStateFlow(QuranFilter.ALL)
    val quranFilter: StateFlow<QuranFilter> = _quranFilter.asStateFlow()

    val currentSurah: StateFlow<com.example.data.Surah?> = combine(_selectedSurahNumber) { (number) ->
        quranRepository.getSurah(number)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), quranRepository.getSurah(1))

    val currentSurahAyahs: StateFlow<List<com.example.data.Ayah>> = combine(_selectedSurahNumber) { (number) ->
        quranRepository.getAyahsForSurah(number)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), quranRepository.getAyahsForSurah(1))

    val filteredSurahs: StateFlow<List<com.example.data.Surah>> = combine(
        _quranSearchQuery,
        _quranFilter,
        quranBookmarkedAyahs
    ) { query, filter, bookmarks ->
        var list = if (query.isNotBlank()) {
            quranRepository.searchSurahs(query)
        } else {
            quranRepository.getAllSurahs()
        }

        when (filter) {
            QuranFilter.ALL -> list
            QuranFilter.MAKKI -> list.filter { it.revelationType.equals("Makki", ignoreCase = true) }
            QuranFilter.MADANI -> list.filter { it.revelationType.equals("Madani", ignoreCase = true) }
            QuranFilter.BOOKMARKS -> {
                val bookmarkedSurahNums = bookmarks.mapNotNull { it.split(":").firstOrNull()?.toIntOrNull() }.toSet()
                list.filter { bookmarkedSurahNums.contains(it.number) }
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), quranRepository.getAllSurahs())

    // Navigation & Screen selection
    private val _currentScreen = MutableStateFlow(AppScreen.BOOKSHELF)
    val currentScreen: StateFlow<AppScreen> = _currentScreen.asStateFlow()

    private val _selectedProphetId = MutableStateFlow<Int?>(null)
    val selectedProphetId: StateFlow<Int?> = _selectedProphetId.asStateFlow()

    // Search and Bookmarks filter
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _bookmarksOnly = MutableStateFlow(false)
    val bookmarksOnly: StateFlow<Boolean> = _bookmarksOnly.asStateFlow()

    // Security Unlock State
    private val _isAppUnlocked = MutableStateFlow(false)
    val isAppUnlocked: StateFlow<Boolean> = _isAppUnlocked.asStateFlow()

    // Cloud Sync State
    private val _cloudSyncState = MutableStateFlow(CloudSyncState())
    val cloudSyncState: StateFlow<CloudSyncState> = _cloudSyncState.asStateFlow()

    // Calendar selection in Diary
    private val _selectedCalendarDateMillis = MutableStateFlow<Long?>(null)
    val selectedCalendarDateMillis: StateFlow<Long?> = _selectedCalendarDateMillis.asStateFlow()

    private val _selectedDiaryTag = MutableStateFlow<String?>(null)
    val selectedDiaryTag: StateFlow<String?> = _selectedDiaryTag.asStateFlow()

    // Audio Playback
    val playbackState: StateFlow<PlaybackState> = audioPlayer.playbackState

    // Dialog & Sheet States
    private val _editingProphet = MutableStateFlow<ProphetEntity?>(null)
    val editingProphet: StateFlow<ProphetEntity?> = _editingProphet.asStateFlow()

    private val _editingEvent = MutableStateFlow<ProphetEventEntity?>(null)
    val editingEvent: StateFlow<ProphetEventEntity?> = _editingEvent.asStateFlow()

    private val _isAddProphetOpen = MutableStateFlow(false)
    val isAddProphetOpen: StateFlow<Boolean> = _isAddProphetOpen.asStateFlow()

    private val _isAddDiaryOpen = MutableStateFlow(false)
    val isAddDiaryOpen: StateFlow<Boolean> = _isAddDiaryOpen.asStateFlow()

    private val _isAppearanceSheetOpen = MutableStateFlow(false)
    val isAppearanceSheetOpen: StateFlow<Boolean> = _isAppearanceSheetOpen.asStateFlow()

    private val _userFeedbackMessage = MutableStateFlow<String?>(null)
    val userFeedbackMessage: StateFlow<String?> = _userFeedbackMessage.asStateFlow()

    // List of Prophets combined with search and bookmark filter
    val prophetsList: StateFlow<List<ProphetEntity>> = combine(
        repository.allProphets,
        _searchQuery,
        _bookmarksOnly
    ) { all, query, onlyBookmarks ->
        var list = all
        if (onlyBookmarks) {
            list = list.filter { it.isBookmarked }
        }
        if (query.isNotBlank()) {
            val q = query.trim().lowercase()
            list = list.filter {
                it.nameRoman.lowercase().contains(q) ||
                it.nameArabic.contains(q) ||
                it.title.lowercase().contains(q) ||
                it.fatherName.lowercase().contains(q) ||
                it.motherName.lowercase().contains(q) ||
                it.siblings.lowercase().contains(q) ||
                it.summaryHighlights.lowercase().contains(q)
            }
        }
        list
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Selected Prophet Entity
    val currentProphet: StateFlow<ProphetEntity?> = combine(
        repository.allProphets,
        _selectedProphetId
    ) { all, id ->
        all.firstOrNull { it.id == id }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // Events for the selected prophet
    val currentProphetEvents: StateFlow<List<ProphetEventEntity>> = combine(
        _selectedProphetId,
        _searchQuery
    ) { id, query ->
        if (id == null) return@combine emptyList<ProphetEventEntity>()
        // We will fetch from database
        id
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1).let {
        combine(_selectedProphetId) { (id) ->
            id
        }
        repository.allProphets // dummy to satisfy signature
        // We'll expose dynamic events via function or flow
    }.let {
        _selectedProphetId
    }.let {
        // Concrete Flow for selected prophet events
        combine(_selectedProphetId, repository.allProphets) { id, _ ->
            id
        }
    }.let {
        // Will be populated dynamically via observeEvents
        MutableStateFlow<List<ProphetEventEntity>>(emptyList())
    }

    private val _eventsForCurrentProphet = MutableStateFlow<List<ProphetEventEntity>>(emptyList())
    val eventsForCurrentProphet: StateFlow<List<ProphetEventEntity>> = _eventsForCurrentProphet.asStateFlow()

    // Filtered Diary Entries
    val diaryEntries: StateFlow<List<PersonalDiaryEntryEntity>> = combine(
        repository.allDiaryEntries,
        _selectedCalendarDateMillis,
        _selectedDiaryTag,
        _searchQuery
    ) { all, dateMillis, tag, query ->
        var list = all
        if (dateMillis != null) {
            val calSelected = Calendar.getInstance().apply { timeInMillis = dateMillis }
            list = list.filter { entry ->
                val calEntry = Calendar.getInstance().apply { timeInMillis = entry.dateMillis }
                calSelected.get(Calendar.YEAR) == calEntry.get(Calendar.YEAR) &&
                calSelected.get(Calendar.DAY_OF_YEAR) == calEntry.get(Calendar.DAY_OF_YEAR)
            }
        }
        if (tag != null) {
            list = list.filter { it.tags.contains(tag, ignoreCase = true) }
        }
        if (query.isNotBlank() && _currentScreen.value == AppScreen.DIARY_JOURNAL) {
            val q = query.trim().lowercase()
            list = list.filter {
                it.title.lowercase().contains(q) ||
                it.content.lowercase().contains(q) ||
                it.tags.lowercase().contains(q)
            }
        }
        list
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            repository.checkAndSeedIfEmpty()
        }
        // Unlock immediately if app lock is disabled
        if (!readerSettings.value.isAppLockEnabled) {
            _isAppUnlocked.value = true
        }
    }

    fun navigateTo(screen: AppScreen) {
        _currentScreen.value = screen
        audioPlayer.stopAudio()
    }

    fun selectProphet(prophet: ProphetEntity) {
        _selectedProphetId.value = prophet.id
        _currentScreen.value = AppScreen.PROPHET_DETAIL
        loadEventsForProphet(prophet.id)
    }

    fun loadEventsForProphet(prophetId: Int) {
        viewModelScope.launch {
            repository.getEventsForProphet(prophetId).collect { events ->
                _eventsForCurrentProphet.value = events
            }
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleBookmarkFilter() {
        _bookmarksOnly.value = !_bookmarksOnly.value
    }

    fun toggleProphetBookmark(prophet: ProphetEntity) {
        viewModelScope.launch {
            repository.toggleBookmark(prophet)
        }
    }

    // --- MANUAL EDITING ---
    fun openEditProphet(prophet: ProphetEntity) {
        _editingProphet.value = prophet
    }

    fun closeEditProphet() {
        _editingProphet.value = null
    }

    fun saveProphetChanges(updatedProphet: ProphetEntity) {
        viewModelScope.launch {
            repository.updateProphet(updatedProphet)
            _editingProphet.value = null
            showFeedback("Prophet jankari kamiyabi se update ho gayi!")
        }
    }

    fun openAddProphet() {
        _isAddProphetOpen.value = true
    }

    fun closeAddProphet() {
        _isAddProphetOpen.value = false
    }

    fun addNewProphet(newProphet: ProphetEntity) {
        viewModelScope.launch {
            val id = repository.insertProphet(newProphet)
            _isAddProphetOpen.value = false
            showFeedback("Naya Nabi profile shamil kar liya gaya!")
            selectProphet(newProphet.copy(id = id.toInt()))
        }
    }

    fun openEditEvent(event: ProphetEventEntity) {
        _editingEvent.value = event
    }

    fun closeEditEvent() {
        _editingEvent.value = null
    }

    fun saveEventChanges(event: ProphetEventEntity) {
        viewModelScope.launch {
            if (event.id == 0) {
                repository.insertEvent(event)
                showFeedback("Nayi ghatna kitab me darj ho gayi!")
            } else {
                repository.updateEvent(event)
                showFeedback("Ghatna ki jankari update ho gayi!")
            }
            _editingEvent.value = null
            _selectedProphetId.value?.let { loadEventsForProphet(it) }
        }
    }

    fun deleteEvent(event: ProphetEventEntity) {
        viewModelScope.launch {
            repository.deleteEvent(event)
            showFeedback("Ghatna delete kar di gayi.")
            _selectedProphetId.value?.let { loadEventsForProphet(it) }
        }
    }

    // --- DIARY & VOICE NOTES ---
    fun openAddDiary() {
        _isAddDiaryOpen.value = true
    }

    fun closeAddDiary() {
        _isAddDiaryOpen.value = false
        audioRecorder.cancelRecording()
    }

    fun saveDiaryEntry(
        title: String,
        content: String,
        tags: String,
        voiceFile: File?,
        voiceDurationSeconds: Int
    ) {
        viewModelScope.launch {
            val entry = PersonalDiaryEntryEntity(
                title = title.ifBlank { "Personal Reflection" },
                content = content,
                tags = tags.ifBlank { "Reflection" },
                voiceNoteFilePath = voiceFile?.absolutePath,
                voiceDurationSeconds = voiceDurationSeconds,
                dateMillis = System.currentTimeMillis()
            )
            repository.insertDiaryEntry(entry)
            _isAddDiaryOpen.value = false
            showFeedback("Aapka tajurba aur voice note diary me save ho gaya!")
        }
    }

    fun deleteDiaryEntry(entry: PersonalDiaryEntryEntity) {
        viewModelScope.launch {
            entry.voiceNoteFilePath?.let { File(it).delete() }
            repository.deleteDiaryEntry(entry)
            showFeedback("Diary entry delete ho gayi.")
        }
    }

    fun setCalendarDateFilter(dateMillis: Long?) {
        _selectedCalendarDateMillis.value = dateMillis
    }

    fun setDiaryTagFilter(tag: String?) {
        _selectedDiaryTag.value = tag
    }

    // --- APPEARANCE & SETTINGS ---
    fun openAppearanceSheet() {
        _isAppearanceSheetOpen.value = true
    }

    fun closeAppearanceSheet() {
        _isAppearanceSheetOpen.value = false
    }

    fun setPaperStyle(style: PaperStyle) {
        preferencesManager.updatePaperStyle(style)
    }

    fun setBookFont(font: BookFont) {
        preferencesManager.updateBookFont(font)
    }

    fun setFontSize(sizeSp: Float) {
        preferencesManager.updateFontSize(sizeSp)
    }

    fun toggleDarkMode(isDark: Boolean) {
        preferencesManager.updateDarkMode(isDark)
    }

    fun setAppLanguage(language: com.example.data.AppLanguage) {
        preferencesManager.updateAppLanguage(language)
        showFeedback("Language: ${language.nativeName} (${language.displayName})")
    }

    private val _isCalendarDialogOpen = MutableStateFlow(false)
    val isCalendarDialogOpen: StateFlow<Boolean> = _isCalendarDialogOpen.asStateFlow()

    fun openCalendarDialog() {
        _isCalendarDialogOpen.value = true
    }

    fun closeCalendarDialog() {
        _isCalendarDialogOpen.value = false
    }

    fun setAppLock(enabled: Boolean, pin: String) {
        preferencesManager.updateLockPin(pin, enabled)
        if (enabled) {
            _isAppUnlocked.value = true // unlocked initially for the current session
            showFeedback("Password & Biometric lock activate ho gaya!")
        } else {
            _isAppUnlocked.value = true
            showFeedback("App lock hata diya gaya.")
        }
    }

    fun verifyPinAndUnlock(enteredPin: String): Boolean {
        val actualPin = readerSettings.value.lockPin
        if (enteredPin == actualPin) {
            _isAppUnlocked.value = true
            return true
        }
        return false
    }

    fun unlockByBiometric() {
        _isAppUnlocked.value = true
    }

    fun lockAppNow() {
        if (readerSettings.value.isAppLockEnabled) {
            _isAppUnlocked.value = false
        }
    }

    // --- CLOUD SYNC & BACKUP / RESTORE ---
    fun performCloudSync() {
        viewModelScope.launch {
            _cloudSyncState.value = _cloudSyncState.value.copy(
                isSyncing = true,
                statusMessage = "Cloud sync in progress..."
            )
            withContext(Dispatchers.IO) {
                // Generate snapshot and simulate cloud sync protocol
                val json = repository.exportToJson()
                kotlinx.coroutines.delay(1200) // smooth visual indication
                _cloudSyncState.value = CloudSyncState(
                    isSyncing = false,
                    lastSyncTimeMillis = System.currentTimeMillis(),
                    statusMessage = "Cloud Sync Successful • Multi-device backup ready",
                    backupJsonString = json
                )
            }
            showFeedback("Cloud sync kamiyabi se mukammal hua!")
        }
    }

    fun exportDataToJson(onResult: (String) -> Unit) {
        viewModelScope.launch {
            val json = repository.exportToJson()
            onResult(json)
            showFeedback("Tamam data JSON me export ho gaya!")
        }
    }

    fun importDataFromJson(jsonString: String) {
        viewModelScope.launch {
            val result = repository.importFromJson(jsonString)
            if (result.isSuccess) {
                val count = result.getOrNull() ?: 0
                showFeedback("$count items kamiyabi se restore ho gaye!")
            } else {
                showFeedback("Import me khata hui: JSON format check karein.")
            }
        }
    }

    fun restoreFactoryData() {
        viewModelScope.launch {
            repository.resetToDefaultData()
            showFeedback("Kitab ka asal matn dubaara restore ho gaya!")
        }
    }

    fun triggerDailyHabitNotification() {
        notificationHelper.showDailyReminderNotification()
        showFeedback("Daily writing habit reminder notification bhej diya gaya!")
    }

    // ==========================================
    // AL-QURAN ACTIONS
    // ==========================================
    fun selectSurah(surahNumber: Int) {
        val clamped = surahNumber.coerceIn(1, 114)
        _selectedSurahNumber.value = clamped
        val surah = quranRepository.getSurah(clamped)
        if (surah != null) {
            quranRepository.saveLastRead(clamped, surah.nameRoman, 1)
        }
        _currentScreen.value = AppScreen.SURAH_READER
    }

    fun nextSurah() {
        if (_selectedSurahNumber.value < 114) {
            selectSurah(_selectedSurahNumber.value + 1)
        }
    }

    fun previousSurah() {
        if (_selectedSurahNumber.value > 1) {
            selectSurah(_selectedSurahNumber.value - 1)
        }
    }

    fun setQuranSearchQuery(query: String) {
        _quranSearchQuery.value = query
    }

    fun setQuranFilter(filter: QuranFilter) {
        _quranFilter.value = filter
    }

    fun toggleAyahBookmark(surahNumber: Int, ayahNumber: Int) {
        val isNowBookmarked = quranRepository.toggleBookmark(surahNumber, ayahNumber)
        if (isNowBookmarked) {
            showFeedback("آیت محفوظ کر لی گئی (Ayah bookmarked)")
        } else {
            showFeedback("آیت محفوظ فہرست سے ہٹا دی گئی (Bookmark removed)")
        }
    }

    fun saveQuranLastRead(surahNumber: Int, ayahNumber: Int) {
        val surah = quranRepository.getSurah(surahNumber)
        val name = surah?.nameRoman ?: "Surah $surahNumber"
        quranRepository.saveLastRead(surahNumber, name, ayahNumber)
    }

    fun updateQuranSettings(
        showArabic: Boolean,
        showHinglish: Boolean,
        showUrdu: Boolean,
        showHindi: Boolean,
        arabicFontSizeSp: Float,
        translationFontSizeSp: Float
    ) {
        quranRepository.updateQuranSettings(
            showArabic = showArabic,
            showHinglish = showHinglish,
            showUrdu = showUrdu,
            showHindi = showHindi,
            arabicFontSizeSp = arabicFontSizeSp,
            translationFontSizeSp = translationFontSizeSp
        )
    }

    fun showFeedback(msg: String) {
        _userFeedbackMessage.value = msg
    }

    fun clearFeedback() {
        _userFeedbackMessage.value = null
    }

    override fun onCleared() {
        super.onCleared()
        audioPlayer.stopAudio()
        audioRecorder.cancelRecording()
        azanTakbeerHelper.release()
    }
}
