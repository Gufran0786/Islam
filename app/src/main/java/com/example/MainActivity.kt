package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.AppScreen
import com.example.ui.MainViewModel
import com.example.ui.components.AddDiaryDialog
import com.example.ui.components.BookAppearanceSheet
import com.example.ui.components.EditEventDialog
import com.example.ui.components.EditProphetDialog
import com.example.ui.components.SecurityLockScreen
import com.example.ui.screens.AngelsScreen
import com.example.ui.screens.BookshelfScreen
import com.example.ui.screens.DiaryJournalScreen
import com.example.ui.screens.PrayerTimeScreen
import com.example.ui.screens.ProphetDetailScreen
import com.example.ui.screens.ProphetFamilyTreeScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.theme.LocalBookPalette
import com.example.ui.theme.QisasAnbiyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = viewModel()
            val readerSettings by viewModel.readerSettings.collectAsStateWithLifecycle()

            QisasAnbiyaTheme(
                paperStyle = readerSettings.paperStyle,
                bookFont = readerSettings.bookFont,
                isDarkMode = readerSettings.isDarkMode
            ) {
                MainAppContent(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainAppContent(viewModel: MainViewModel) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val isAppUnlocked by viewModel.isAppUnlocked.collectAsStateWithLifecycle()
    val readerSettings by viewModel.readerSettings.collectAsStateWithLifecycle()
    val prophetsList by viewModel.prophetsList.collectAsStateWithLifecycle()
    val currentProphet by viewModel.currentProphet.collectAsStateWithLifecycle()
    val currentProphetEvents by viewModel.eventsForCurrentProphet.collectAsStateWithLifecycle()
    val diaryEntries by viewModel.diaryEntries.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val bookmarksOnly by viewModel.bookmarksOnly.collectAsStateWithLifecycle()
    val cloudSyncState by viewModel.cloudSyncState.collectAsStateWithLifecycle()
    val selectedCalendarDateMillis by viewModel.selectedCalendarDateMillis.collectAsStateWithLifecycle()
    val selectedDiaryTag by viewModel.selectedDiaryTag.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()

    val editingProphet by viewModel.editingProphet.collectAsStateWithLifecycle()
    val editingEvent by viewModel.editingEvent.collectAsStateWithLifecycle()
    val isAddProphetOpen by viewModel.isAddProphetOpen.collectAsStateWithLifecycle()
    val isAddDiaryOpen by viewModel.isAddDiaryOpen.collectAsStateWithLifecycle()
    val isAppearanceSheetOpen by viewModel.isAppearanceSheetOpen.collectAsStateWithLifecycle()
    val isCalendarDialogOpen by viewModel.isCalendarDialogOpen.collectAsStateWithLifecycle()
    val userFeedbackMessage by viewModel.userFeedbackMessage.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val palette = LocalBookPalette.current

    LaunchedEffect(userFeedbackMessage) {
        userFeedbackMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearFeedback()
        }
    }

    // Security Gate: If app lock is enabled and locked, display Security Keypad
    if (readerSettings.isAppLockEnabled && !isAppUnlocked) {
        SecurityLockScreen(
            actualPin = readerSettings.lockPin,
            onSuccessUnlock = { viewModel.unlockByBiometric() },
            onBiometricClick = { viewModel.unlockByBiometric() }
        )
        return
    }

    // Handle System Back button
    BackHandler(enabled = currentScreen != AppScreen.BOOKSHELF) {
        when (currentScreen) {
            AppScreen.PROPHET_DETAIL -> viewModel.navigateTo(AppScreen.BOOKSHELF)
            AppScreen.SURAH_READER -> viewModel.navigateTo(AppScreen.QURAN_INDEX)
            AppScreen.QURAN_INDEX -> viewModel.navigateTo(AppScreen.BOOKSHELF)
            else -> viewModel.navigateTo(AppScreen.BOOKSHELF)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            if (currentScreen != AppScreen.PROPHET_DETAIL && currentScreen != AppScreen.SURAH_READER) {
                NavigationBar(
                    containerColor = palette.surface,
                    contentColor = palette.textPrimary
                ) {
                    NavigationBarItem(
                        selected = currentScreen == AppScreen.BOOKSHELF,
                        onClick = { viewModel.navigateTo(AppScreen.BOOKSHELF) },
                        icon = { Icon(Icons.Default.AutoStories, contentDescription = "Kitab Anbiya") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_anbiya", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_bookshelf")
                    )

                    NavigationBarItem(
                        selected = currentScreen == AppScreen.FAMILY_TREE,
                        onClick = { viewModel.navigateTo(AppScreen.FAMILY_TREE) },
                        icon = { Icon(Icons.Default.AccountTree, contentDescription = "Family Tree") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_family_tree", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_family_tree")
                    )

                    NavigationBarItem(
                        selected = currentScreen == AppScreen.QURAN_INDEX,
                        onClick = { viewModel.navigateTo(AppScreen.QURAN_INDEX) },
                        icon = { Icon(Icons.Default.MenuBook, contentDescription = "Al-Quran") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_quran", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_quran")
                    )

                    NavigationBarItem(
                        selected = currentScreen == AppScreen.PRAYER_TIME,
                        onClick = { viewModel.navigateTo(AppScreen.PRAYER_TIME) },
                        icon = { Icon(Icons.Default.AccessTime, contentDescription = "Prayer Time") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_time", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_prayer_time")
                    )

                    NavigationBarItem(
                        selected = currentScreen == AppScreen.ANGELS,
                        onClick = { viewModel.navigateTo(AppScreen.ANGELS) },
                        icon = { Icon(Icons.Default.AutoAwesome, contentDescription = "Angels") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_angels", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_angels")
                    )

                    NavigationBarItem(
                        selected = currentScreen == AppScreen.DIARY_JOURNAL,
                        onClick = { viewModel.navigateTo(AppScreen.DIARY_JOURNAL) },
                        icon = { Icon(Icons.Default.EditNote, contentDescription = "Diary") },
                        label = { Text(com.example.util.AppLocaleManager.getUiString("tab_diary", readerSettings.appLanguage), maxLines = 1) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = palette.accent,
                            selectedTextColor = palette.accent,
                            indicatorColor = palette.accent.copy(alpha = 0.2f),
                            unselectedIconColor = palette.textSecondary,
                            unselectedTextColor = palette.textSecondary
                        ),
                        modifier = Modifier.testTag("nav_diary")
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                AppScreen.BOOKSHELF -> {
                    BookshelfScreen(
                        prophets = prophetsList,
                        searchQuery = searchQuery,
                        bookmarksOnly = bookmarksOnly,
                        language = readerSettings.appLanguage,
                        onOpenCalendarDialog = { viewModel.openCalendarDialog() },
                        onSearchChange = { viewModel.setSearchQuery(it) },
                        onToggleBookmarkFilter = { viewModel.toggleBookmarkFilter() },
                        onProphetClick = { viewModel.selectProphet(it) },
                        onToggleBookmark = { viewModel.toggleProphetBookmark(it) },
                        onEditProphet = { viewModel.openEditProphet(it) },
                        onAddProphet = { viewModel.openAddProphet() },
                        onOpenAppearanceSheet = { viewModel.openAppearanceSheet() },
                        onOpenSettings = { viewModel.navigateTo(AppScreen.SETTINGS) }
                    )
                }
                AppScreen.FAMILY_TREE -> {
                    ProphetFamilyTreeScreen(
                        prophets = prophetsList,
                        onSelectProphet = { viewModel.selectProphet(it) }
                    )
                }
                AppScreen.QURAN_INDEX -> {
                    com.example.ui.quran.QuranIndexScreen(
                        viewModel = viewModel
                    )
                }
                AppScreen.SURAH_READER -> {
                    com.example.ui.quran.SurahReaderScreen(
                        viewModel = viewModel
                    )
                }
                AppScreen.PRAYER_TIME -> {
                    PrayerTimeScreen(
                        azanHelper = viewModel.azanTakbeerHelper
                    )
                }
                AppScreen.ANGELS -> {
                    AngelsScreen()
                }
                AppScreen.PROPHET_DETAIL -> {
                    currentProphet?.let { prophet ->
                        ProphetDetailScreen(
                            prophet = prophet,
                            events = currentProphetEvents,
                            onBack = { viewModel.navigateTo(AppScreen.BOOKSHELF) },
                            onToggleBookmark = { viewModel.toggleProphetBookmark(prophet) },
                            onEditProphet = { viewModel.openEditProphet(prophet) },
                            onAddEvent = {
                                viewModel.openEditEvent(
                                    com.example.data.ProphetEventEntity(
                                        prophetId = prophet.id,
                                        title = "",
                                        summary = "",
                                        detailedNarrative = "",
                                        eventPhotoUrlOrRes = "img_book_banner",
                                        quranicReference = "",
                                        moralLesson = ""
                                    )
                                )
                            },
                            onEditEvent = { viewModel.openEditEvent(it) },
                            onDeleteEvent = { viewModel.deleteEvent(it) },
                            onOpenAppearanceSheet = { viewModel.openAppearanceSheet() },
                            onUpdatePhoto = { newPhoto ->
                                viewModel.saveProphetChanges(prophet.copy(photoUrlOrRes = newPhoto))
                            },
                            language = readerSettings.appLanguage
                        )
                    }
                }
                AppScreen.DIARY_JOURNAL -> {
                    DiaryJournalScreen(
                        entries = diaryEntries,
                        selectedCalendarDateMillis = selectedCalendarDateMillis,
                        selectedTag = selectedDiaryTag,
                        searchQuery = searchQuery,
                        playbackState = playbackState,
                        audioPlayer = viewModel.audioPlayer,
                        onDateSelect = { viewModel.setCalendarDateFilter(it) },
                        onTagSelect = { viewModel.setDiaryTagFilter(it) },
                        onSearchChange = { viewModel.setSearchQuery(it) },
                        onAddDiaryClick = { viewModel.openAddDiary() },
                        onDeleteEntry = { viewModel.deleteDiaryEntry(it) },
                        onLockAppClick = { viewModel.lockAppNow() }
                    )
                }
                AppScreen.SETTINGS -> {
                    SettingsScreen(
                        settings = readerSettings,
                        cloudSyncState = cloudSyncState,
                        onSelectLanguage = { viewModel.setAppLanguage(it) },
                        onOpenCalendar = { viewModel.openCalendarDialog() },
                        onSelectPaperStyle = { viewModel.setPaperStyle(it) },
                        onSelectBookFont = { viewModel.setBookFont(it) },
                        onFontSizeChange = { viewModel.setFontSize(it) },
                        onToggleDarkMode = { viewModel.toggleDarkMode(it) },
                        onSetAppLock = { enabled, pin -> viewModel.setAppLock(enabled, pin) },
                        onTriggerCloudSync = { viewModel.performCloudSync() },
                        onExportJson = { callback -> viewModel.exportDataToJson(callback) },
                        onImportJson = { json -> viewModel.importDataFromJson(json) },
                        onRestoreFactoryData = { viewModel.restoreFactoryData() },
                        onTestDailyReminder = { viewModel.triggerDailyHabitNotification() }
                    )
                }
            }
        }
    }

    // Modal Dialogs
    if (isCalendarDialogOpen) {
        com.example.ui.calendar.TriCalendarDialog(
            onDismiss = { viewModel.closeCalendarDialog() }
        )
    }

    if (editingProphet != null) {
        EditProphetDialog(
            prophet = editingProphet,
            isNew = false,
            onDismiss = { viewModel.closeEditProphet() },
            onSave = { viewModel.saveProphetChanges(it) }
        )
    }

    if (isAddProphetOpen) {
        EditProphetDialog(
            prophet = null,
            isNew = true,
            onDismiss = { viewModel.closeAddProphet() },
            onSave = { viewModel.addNewProphet(it) }
        )
    }

    if (editingEvent != null) {
        val prophetId = currentProphet?.id ?: 1
        EditEventDialog(
            event = editingEvent,
            prophetId = prophetId,
            onDismiss = { viewModel.closeEditEvent() },
            onSave = { viewModel.saveEventChanges(it) }
        )
    }

    if (isAddDiaryOpen) {
        AddDiaryDialog(
            audioRecorder = viewModel.audioRecorder,
            audioPlayer = viewModel.audioPlayer,
            onDismiss = { viewModel.closeAddDiary() },
            onSave = { title, content, tags, voiceFile, duration ->
                viewModel.saveDiaryEntry(title, content, tags, voiceFile, duration)
            }
        )
    }

    if (isAppearanceSheetOpen) {
        BookAppearanceSheet(
            settings = readerSettings,
            onSelectPaperStyle = { viewModel.setPaperStyle(it) },
            onSelectBookFont = { viewModel.setBookFont(it) },
            onFontSizeChange = { viewModel.setFontSize(it) },
            onToggleDarkMode = { viewModel.toggleDarkMode(it) },
            onDismiss = { viewModel.closeAppearanceSheet() }
        )
    }
}
