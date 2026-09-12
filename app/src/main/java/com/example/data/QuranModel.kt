package com.example.data

/**
 * Metadata representing a Surah (Chapter) of the Holy Quran.
 */
data class Surah(
    val number: Int,
    val nameArabic: String,
    val nameRoman: String,
    val nameTranslation: String,
    val revelationType: String, // "Makki" or "Madani"
    val totalVerses: Int,
    val revelationOrder: Int,
    val juzNumber: Int,
    val meaningHindi: String,
    val meaningUrdu: String,
    val summary: String = ""
)

/**
 * An Ayah (Verse) of the Holy Quran containing:
 * - Arabic (Uthmani script with complete Harakat/diacritics)
 * - Hinglish (Roman transliteration for accurate phonetics)
 * - Urdu Translation (مستند اردو ترجمہ)
 * - Hindi Translation (शुद्ध व स्पष्ट हिन्दी अनुवाद)
 */
data class Ayah(
    val surahNumber: Int,
    val ayahNumber: Int,
    val arabicText: String,
    val hinglishText: String,
    val urduTranslation: String,
    val hindiTranslation: String,
    val isSajdah: Boolean = false,
    val note: String = ""
)

/**
 * Reader settings for Al-Quran
 */
data class QuranDisplaySettings(
    val showArabic: Boolean = true,
    val showHinglish: Boolean = true,
    val showUrdu: Boolean = true,
    val showHindi: Boolean = true,
    val arabicFontSizeSp: Float = 26f,
    val translationFontSizeSp: Float = 16f
)

/**
 * User bookmark or favorite marker for an Ayah
 */
data class QuranBookmark(
    val id: String, // e.g. "surah_1_ayah_1"
    val surahNumber: Int,
    val surahNameRoman: String,
    val ayahNumber: Int,
    val snippetArabic: String,
    val snippetTranslation: String,
    val timestampMillis: Long = System.currentTimeMillis()
)

/**
 * Last read position in the Quran
 */
data class LastReadPosition(
    val surahNumber: Int = 1,
    val surahNameRoman: String = "Al-Fatihah",
    val ayahNumber: Int = 1,
    val timestampMillis: Long = System.currentTimeMillis()
)
