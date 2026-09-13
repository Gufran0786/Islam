package com.example.data

import android.content.Context
import android.util.Log
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Loads authentic complete Quran Ayahs from bundled JSON assets.
 * Caches loaded Surahs in memory for instant, zero-latency subsequent access.
 * Fallback to compiled Kotlin data objects if assets cannot be accessed.
 */
object QuranAssetLoader {
    private const val TAG = "QuranAssetLoader"
    private val cache = mutableMapOf<Int, List<Ayah>>()

    fun getAyahsForSurah(context: Context, surahNumber: Int): List<Ayah> {
        // Return from in-memory cache if already loaded
        cache[surahNumber]?.let { return it }

        try {
            val assetPath = "quran/$surahNumber.json"
            context.assets.open(assetPath).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8)).use { reader ->
                    val jsonString = reader.readText()
                    val jsonArray = JSONArray(jsonString)
                    val list = ArrayList<Ayah>(jsonArray.length())
                    for (i in 0 until jsonArray.length()) {
                        val obj = jsonArray.getJSONObject(i)
                        list.add(
                            Ayah(
                                surahNumber = obj.optInt("surahNumber", surahNumber),
                                ayahNumber = obj.optInt("ayahNumber", i + 1),
                                arabicText = obj.optString("arabicText", ""),
                                hinglishText = obj.optString("hinglishText", ""),
                                urduTranslation = obj.optString("urduTranslation", ""),
                                hindiTranslation = obj.optString("hindiTranslation", "")
                            )
                        )
                    }
                    if (list.isNotEmpty()) {
                        cache[surahNumber] = list
                        return list
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Surah $surahNumber from assets: ${e.message}", e)
        }

        // Fallback to in-memory Kotlin data
        val fallback = QuranAyahData.getAyahsForSurah(surahNumber)
        if (fallback.isNotEmpty()) {
            cache[surahNumber] = fallback
        }
        return fallback
    }

    /**
     * Search across loaded / asset Ayahs for keywords in Arabic, Roman/Hinglish, Urdu, or Hindi.
     */
    fun searchAcrossAyahs(context: Context, query: String, maxResults: Int = 10): List<Ayah> {
        val clean = query.trim().lowercase()
        if (clean.isEmpty()) return emptyList()

        val tokens = clean.split(Regex("\\s+")).filter { it.length > 2 }
        if (tokens.isEmpty()) return emptyList()

        val matchedAyahs = mutableListOf<Pair<Ayah, Int>>()

        // Search in popular and loaded surahs first
        val prioritySurahs = listOf(1, 2, 3, 18, 36, 55, 56, 67, 78, 112, 113, 114) + (1..114).toList()
        val visitedSurahs = mutableSetOf<Int>()

        for (sNum in prioritySurahs) {
            if (!visitedSurahs.add(sNum)) continue

            val ayahs = getAyahsForSurah(context, sNum)
            for (ayah in ayahs) {
                var score = 0
                val urdu = ayah.urduTranslation
                val hindi = ayah.hindiTranslation
                val hinglish = ayah.hinglishText.lowercase()
                val arabic = ayah.arabicText

                if (urdu.contains(query)) score += 40
                if (hindi.contains(query)) score += 40
                if (hinglish.contains(clean)) score += 40
                if (arabic.contains(query)) score += 50

                for (token in tokens) {
                    if (urdu.contains(token)) score += 15
                    if (hindi.contains(token)) score += 15
                    if (hinglish.contains(token)) score += 15
                    if (arabic.contains(token)) score += 20
                }

                if (score > 0) {
                    matchedAyahs.add(ayah to score)
                    if (matchedAyahs.size >= maxResults * 3) break
                }
            }

            if (matchedAyahs.size >= maxResults * 2) break
        }

        return matchedAyahs.sortedByDescending { it.second }.take(maxResults).map { it.first }
    }
}
