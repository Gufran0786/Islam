package com.example.data

import android.content.Context
import com.example.util.PreferencesManager
import kotlinx.coroutines.flow.StateFlow

class QuranRepository(
    private val preferencesManager: PreferencesManager,
    private val context: Context? = null
) {
    val quranSettings: StateFlow<QuranDisplaySettings> = preferencesManager.quranSettings
    val lastRead: StateFlow<LastReadPosition> = preferencesManager.lastRead
    val bookmarkedAyahs: StateFlow<Set<String>> = preferencesManager.bookmarkedAyahs

    fun getAllSurahs(): List<Surah> {
        return QuranSurahIndex.surahs
    }

    fun getSurah(number: Int): Surah? {
        return QuranSurahIndex.getSurah(number)
    }

    fun getAyahsForSurah(number: Int): List<Ayah> {
        if (context != null) {
            val assetAyahs = QuranAssetLoader.getAyahsForSurah(context, number)
            if (assetAyahs.isNotEmpty()) {
                return assetAyahs
            }
        }
        return QuranAyahData.getAyahsForSurah(number)
    }

    fun searchSurahs(query: String): List<Surah> {
        if (query.isBlank()) return QuranSurahIndex.surahs
        val q = query.trim().lowercase()
        return QuranSurahIndex.surahs.filter { surah ->
            surah.number.toString() == q ||
            surah.nameRoman.lowercase().contains(q) ||
            surah.nameArabic.contains(query) ||
            surah.meaningHindi.contains(query) ||
            surah.meaningUrdu.contains(query) ||
            surah.nameTranslation.lowercase().contains(q)
        }
    }

    fun searchAyahs(query: String): List<Ayah> {
        if (context != null) {
            val results = QuranAssetLoader.searchAcrossAyahs(context, query)
            if (results.isNotEmpty()) return results
        }
        return QuranAyahData.searchAyahs(query)
    }

    fun toggleBookmark(surahNumber: Int, ayahNumber: Int): Boolean {
        return preferencesManager.toggleBookmark(surahNumber, ayahNumber)
    }

    fun isAyahBookmarked(surahNumber: Int, ayahNumber: Int): Boolean {
        return preferencesManager.isAyahBookmarked(surahNumber, ayahNumber)
    }

    fun saveLastRead(surahNumber: Int, surahNameRoman: String, ayahNumber: Int) {
        preferencesManager.saveLastRead(surahNumber, surahNameRoman, ayahNumber)
    }

    fun updateQuranSettings(
        showArabic: Boolean,
        showHinglish: Boolean,
        showUrdu: Boolean,
        showHindi: Boolean,
        arabicFontSizeSp: Float,
        translationFontSizeSp: Float
    ) {
        preferencesManager.updateQuranSettings(
            showArabic = showArabic,
            showHinglish = showHinglish,
            showUrdu = showUrdu,
            showHindi = showHindi,
            arabicFontSizeSp = arabicFontSizeSp,
            translationFontSizeSp = translationFontSizeSp
        )
    }
}
