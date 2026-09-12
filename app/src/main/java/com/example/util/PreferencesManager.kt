package com.example.util

import android.content.Context
import android.content.SharedPreferences
import com.example.data.BookFont
import com.example.data.PaperStyle
import com.example.data.ReaderSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("qisas_anbiya_prefs", Context.MODE_PRIVATE)

    private val _settings = MutableStateFlow(loadSettings())
    val settings: StateFlow<ReaderSettings> = _settings.asStateFlow()

    private fun loadSettings(): ReaderSettings {
        val paperStr = prefs.getString("paper_style", PaperStyle.PARCHMENT.name) ?: PaperStyle.PARCHMENT.name
        val fontStr = prefs.getString("book_font", BookFont.SERIF.name) ?: BookFont.SERIF.name
        val fontSize = prefs.getFloat("font_size", 16f)
        val isDark = prefs.getBoolean("is_dark_mode", false)
        val useSystem = prefs.getBoolean("use_system_theme", false)
        val lockEnabled = prefs.getBoolean("is_app_lock_enabled", false)
        val pin = prefs.getString("lock_pin", "") ?: ""
        val dailyReminder = prefs.getBoolean("daily_reminder", true)
        val reminderHour = prefs.getInt("reminder_hour", 20)
        val reminderMinute = prefs.getInt("reminder_minute", 0)

        val paper = runCatching { PaperStyle.valueOf(paperStr) }.getOrDefault(PaperStyle.PARCHMENT)
        val font = runCatching { BookFont.valueOf(fontStr) }.getOrDefault(BookFont.SERIF)
        val langStr = prefs.getString("app_language", com.example.data.AppLanguage.HINDI.name) ?: com.example.data.AppLanguage.HINDI.name
        val language = runCatching { com.example.data.AppLanguage.valueOf(langStr) }.getOrDefault(com.example.data.AppLanguage.HINDI)

        return ReaderSettings(
            paperStyle = paper,
            bookFont = font,
            fontSizeSp = fontSize,
            isDarkMode = isDark,
            useSystemTheme = useSystem,
            isAppLockEnabled = lockEnabled,
            lockPin = pin,
            dailyReminderEnabled = dailyReminder,
            reminderHour = reminderHour,
            reminderMinute = reminderMinute,
            appLanguage = language
        )
    }

    fun updateAppLanguage(language: com.example.data.AppLanguage) {
        prefs.edit().putString("app_language", language.name).apply()
        _settings.value = _settings.value.copy(appLanguage = language)
    }

    fun updatePaperStyle(style: PaperStyle) {
        prefs.edit().putString("paper_style", style.name).apply()
        _settings.value = _settings.value.copy(paperStyle = style)
    }

    fun updateBookFont(font: BookFont) {
        prefs.edit().putString("book_font", font.name).apply()
        _settings.value = _settings.value.copy(bookFont = font)
    }

    fun updateFontSize(sizeSp: Float) {
        prefs.edit().putFloat("font_size", sizeSp).apply()
        _settings.value = _settings.value.copy(fontSizeSp = sizeSp)
    }

    fun updateDarkMode(isDark: Boolean) {
        prefs.edit().putBoolean("is_dark_mode", isDark).apply()
        _settings.value = _settings.value.copy(isDarkMode = isDark)
    }

    fun updateLockPin(pin: String, enabled: Boolean) {
        prefs.edit()
            .putString("lock_pin", pin)
            .putBoolean("is_app_lock_enabled", enabled)
            .apply()
        _settings.value = _settings.value.copy(lockPin = pin, isAppLockEnabled = enabled)
    }

    fun updateDailyReminder(enabled: Boolean, hour: Int, minute: Int) {
        prefs.edit()
            .putBoolean("daily_reminder", enabled)
            .putInt("reminder_hour", hour)
            .putInt("reminder_minute", minute)
            .apply()
        _settings.value = _settings.value.copy(
            dailyReminderEnabled = enabled,
            reminderHour = hour,
            reminderMinute = minute
        )
    }

    // ==========================================
    // AL-QURAN PREFERENCES & PERSISTENCE
    // ==========================================
    private val _quranSettings = MutableStateFlow(loadQuranSettings())
    val quranSettings: StateFlow<com.example.data.QuranDisplaySettings> = _quranSettings.asStateFlow()

    private fun loadQuranSettings(): com.example.data.QuranDisplaySettings {
        return com.example.data.QuranDisplaySettings(
            showArabic = prefs.getBoolean("quran_show_arabic", true),
            showHinglish = prefs.getBoolean("quran_show_hinglish", true),
            showUrdu = prefs.getBoolean("quran_show_urdu", true),
            showHindi = prefs.getBoolean("quran_show_hindi", true),
            arabicFontSizeSp = prefs.getFloat("quran_arabic_font_size", 26f),
            translationFontSizeSp = prefs.getFloat("quran_trans_font_size", 16f)
        )
    }

    fun updateQuranSettings(
        showArabic: Boolean = _quranSettings.value.showArabic,
        showHinglish: Boolean = _quranSettings.value.showHinglish,
        showUrdu: Boolean = _quranSettings.value.showUrdu,
        showHindi: Boolean = _quranSettings.value.showHindi,
        arabicFontSizeSp: Float = _quranSettings.value.arabicFontSizeSp,
        translationFontSizeSp: Float = _quranSettings.value.translationFontSizeSp
    ) {
        val updated = com.example.data.QuranDisplaySettings(
            showArabic = showArabic,
            showHinglish = showHinglish,
            showUrdu = showUrdu,
            showHindi = showHindi,
            arabicFontSizeSp = arabicFontSizeSp,
            translationFontSizeSp = translationFontSizeSp
        )
        prefs.edit()
            .putBoolean("quran_show_arabic", showArabic)
            .putBoolean("quran_show_hinglish", showHinglish)
            .putBoolean("quran_show_urdu", showUrdu)
            .putBoolean("quran_show_hindi", showHindi)
            .putFloat("quran_arabic_font_size", arabicFontSizeSp)
            .putFloat("quran_trans_font_size", translationFontSizeSp)
            .apply()
        _quranSettings.value = updated
    }

    // Last Read Surah & Ayah
    private val _lastRead = MutableStateFlow(loadLastRead())
    val lastRead: StateFlow<com.example.data.LastReadPosition> = _lastRead.asStateFlow()

    private fun loadLastRead(): com.example.data.LastReadPosition {
        val surahNum = prefs.getInt("quran_last_surah_num", 1)
        val surahName = prefs.getString("quran_last_surah_name", "Al-Fatihah") ?: "Al-Fatihah"
        val ayahNum = prefs.getInt("quran_last_ayah_num", 1)
        val timestamp = prefs.getLong("quran_last_timestamp", System.currentTimeMillis())
        return com.example.data.LastReadPosition(surahNum, surahName, ayahNum, timestamp)
    }

    fun saveLastRead(surahNumber: Int, surahNameRoman: String, ayahNumber: Int) {
        val now = System.currentTimeMillis()
        prefs.edit()
            .putInt("quran_last_surah_num", surahNumber)
            .putString("quran_last_surah_name", surahNameRoman)
            .putInt("quran_last_ayah_num", ayahNumber)
            .putLong("quran_last_timestamp", now)
            .apply()
        _lastRead.value = com.example.data.LastReadPosition(surahNumber, surahNameRoman, ayahNumber, now)
    }

    // Bookmarked Ayahs: Set of "surah:ayah" strings, e.g. "1:1", "2:255"
    private val _bookmarkedAyahs = MutableStateFlow<Set<String>>(loadBookmarks())
    val bookmarkedAyahs: StateFlow<Set<String>> = _bookmarkedAyahs.asStateFlow()

    private fun loadBookmarks(): Set<String> {
        return prefs.getStringSet("quran_bookmarked_ayahs", emptySet()) ?: emptySet()
    }

    fun toggleBookmark(surahNumber: Int, ayahNumber: Int): Boolean {
        val key = "$surahNumber:$ayahNumber"
        val current = _bookmarkedAyahs.value.toMutableSet()
        val isNowBookmarked = if (current.contains(key)) {
            current.remove(key)
            false
        } else {
            current.add(key)
            true
        }
        prefs.edit().putStringSet("quran_bookmarked_ayahs", current).apply()
        _bookmarkedAyahs.value = current
        return isNowBookmarked
    }

    fun isAyahBookmarked(surahNumber: Int, ayahNumber: Int): Boolean {
        return _bookmarkedAyahs.value.contains("$surahNumber:$ayahNumber")
    }
}
