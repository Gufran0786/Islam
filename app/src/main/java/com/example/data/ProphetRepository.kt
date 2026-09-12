package com.example.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class ProphetRepository(private val dao: ProphetDao) {

    val allProphets: Flow<List<ProphetEntity>> = dao.getAllProphets()
    val bookmarkedProphets: Flow<List<ProphetEntity>> = dao.getBookmarkedProphets()
    val allDiaryEntries: Flow<List<PersonalDiaryEntryEntity>> = dao.getAllDiaryEntries()

    suspend fun checkAndSeedIfEmpty() = withContext(Dispatchers.IO) {
        if (dao.getProphetsCount() < 42) {
            AppDatabase.populateInitialData(dao)
        }
    }

    fun getProphetById(id: Int): Flow<ProphetEntity?> = dao.getProphetById(id)
    suspend fun getProphetByIdSync(id: Int): ProphetEntity? = dao.getProphetByIdSync(id)

    fun searchProphets(query: String): Flow<List<ProphetEntity>> = dao.searchProphets(query)

    fun getEventsForProphet(prophetId: Int): Flow<List<ProphetEventEntity>> =
        dao.getEventsForProphet(prophetId)

    fun searchEvents(query: String): Flow<List<ProphetEventEntity>> = dao.searchEvents(query)

    suspend fun insertProphet(prophet: ProphetEntity): Long = dao.insertProphet(prophet)

    suspend fun updateProphet(prophet: ProphetEntity) = dao.updateProphet(prophet)

    suspend fun deleteProphet(prophet: ProphetEntity) = dao.deleteProphet(prophet)

    suspend fun toggleBookmark(prophet: ProphetEntity) {
        dao.updateProphet(prophet.copy(isBookmarked = !prophet.isBookmarked))
    }

    suspend fun insertEvent(event: ProphetEventEntity): Long = dao.insertEvent(event)

    suspend fun updateEvent(event: ProphetEventEntity) = dao.updateEvent(event)

    suspend fun deleteEvent(event: ProphetEventEntity) = dao.deleteEvent(event)

    fun getDiaryEntriesInRange(start: Long, end: Long): Flow<List<PersonalDiaryEntryEntity>> =
        dao.getDiaryEntriesInRange(start, end)

    fun searchDiaryEntries(query: String): Flow<List<PersonalDiaryEntryEntity>> =
        dao.searchDiaryEntries(query)

    fun getDiaryEntriesByTag(tag: String): Flow<List<PersonalDiaryEntryEntity>> =
        dao.getDiaryEntriesByTag(tag)

    suspend fun insertDiaryEntry(entry: PersonalDiaryEntryEntity): Long =
        dao.insertDiaryEntry(entry)

    suspend fun updateDiaryEntry(entry: PersonalDiaryEntryEntity) =
        dao.updateDiaryEntry(entry)

    suspend fun deleteDiaryEntry(entry: PersonalDiaryEntryEntity) =
        dao.deleteDiaryEntry(entry)

    // --- BACKUP & JSON EXPORT/IMPORT ---
    suspend fun exportToJson(): String = withContext(Dispatchers.IO) {
        val prophets = dao.getAllProphetsSync()
        val events = dao.getAllEventsSync()
        val diaries = dao.getAllDiaryEntriesSync()

        val root = JSONObject()
        root.put("version", 1)
        root.put("exportedAt", System.currentTimeMillis())

        val prophetsArr = JSONArray()
        for (p in prophets) {
            val obj = JSONObject()
            obj.put("id", p.id)
            obj.put("orderIndex", p.orderIndex)
            obj.put("nameArabic", p.nameArabic)
            obj.put("nameRoman", p.nameRoman)
            obj.put("title", p.title)
            obj.put("ageYears", p.ageYears)
            obj.put("fatherName", p.fatherName)
            obj.put("motherName", p.motherName)
            obj.put("siblings", p.siblings)
            obj.put("children", p.children)
            obj.put("eraLocation", p.eraLocation)
            obj.put("photoUrlOrRes", p.photoUrlOrRes)
            obj.put("isBookmarked", p.isBookmarked)
            obj.put("summaryHighlights", p.summaryHighlights)
            prophetsArr.put(obj)
        }
        root.put("prophets", prophetsArr)

        val eventsArr = JSONArray()
        for (e in events) {
            val obj = JSONObject()
            obj.put("id", e.id)
            obj.put("prophetId", e.prophetId)
            obj.put("title", e.title)
            obj.put("summary", e.summary)
            obj.put("detailedNarrative", e.detailedNarrative)
            obj.put("eventPhotoUrlOrRes", e.eventPhotoUrlOrRes)
            obj.put("quranicReference", e.quranicReference)
            obj.put("moralLesson", e.moralLesson)
            obj.put("orderIndex", e.orderIndex)
            eventsArr.put(obj)
        }
        root.put("events", eventsArr)

        val diariesArr = JSONArray()
        for (d in diaries) {
            val obj = JSONObject()
            obj.put("id", d.id)
            obj.put("dateMillis", d.dateMillis)
            obj.put("title", d.title)
            obj.put("content", d.content)
            obj.put("voiceNoteFilePath", d.voiceNoteFilePath ?: "")
            obj.put("voiceDurationSeconds", d.voiceDurationSeconds)
            obj.put("tags", d.tags)
            obj.put("isLocked", d.isLocked)
            diariesArr.put(obj)
        }
        root.put("diaries", diariesArr)

        root.toString(2)
    }

    suspend fun importFromJson(jsonString: String): Result<Int> = withContext(Dispatchers.IO) {
        runCatching {
            val root = JSONObject(jsonString)
            val prophetsArr = root.optJSONArray("prophets") ?: JSONArray()
            val eventsArr = root.optJSONArray("events") ?: JSONArray()
            val diariesArr = root.optJSONArray("diaries") ?: JSONArray()

            val prophetsList = mutableListOf<ProphetEntity>()
            for (i in 0 until prophetsArr.length()) {
                val obj = prophetsArr.getJSONObject(i)
                prophetsList.add(
                    ProphetEntity(
                        id = obj.optInt("id", 0),
                        orderIndex = obj.optInt("orderIndex", i + 1),
                        nameArabic = obj.optString("nameArabic", ""),
                        nameRoman = obj.optString("nameRoman", ""),
                        title = obj.optString("title", ""),
                        ageYears = obj.optString("ageYears", ""),
                        fatherName = obj.optString("fatherName", ""),
                        motherName = obj.optString("motherName", ""),
                        siblings = obj.optString("siblings", ""),
                        children = obj.optString("children", ""),
                        eraLocation = obj.optString("eraLocation", ""),
                        photoUrlOrRes = obj.optString("photoUrlOrRes", ""),
                        isBookmarked = obj.optBoolean("isBookmarked", false),
                        summaryHighlights = obj.optString("summaryHighlights", "")
                    )
                )
            }

            val eventsList = mutableListOf<ProphetEventEntity>()
            for (i in 0 until eventsArr.length()) {
                val obj = eventsArr.getJSONObject(i)
                eventsList.add(
                    ProphetEventEntity(
                        id = obj.optInt("id", 0),
                        prophetId = obj.optInt("prophetId", 1),
                        title = obj.optString("title", ""),
                        summary = obj.optString("summary", ""),
                        detailedNarrative = obj.optString("detailedNarrative", ""),
                        eventPhotoUrlOrRes = obj.optString("eventPhotoUrlOrRes", ""),
                        quranicReference = obj.optString("quranicReference", ""),
                        moralLesson = obj.optString("moralLesson", ""),
                        orderIndex = obj.optInt("orderIndex", i + 1)
                    )
                )
            }

            val diaryList = mutableListOf<PersonalDiaryEntryEntity>()
            for (i in 0 until diariesArr.length()) {
                val obj = diariesArr.getJSONObject(i)
                diaryList.add(
                    PersonalDiaryEntryEntity(
                        id = obj.optInt("id", 0),
                        dateMillis = obj.optLong("dateMillis", System.currentTimeMillis()),
                        title = obj.optString("title", ""),
                        content = obj.optString("content", ""),
                        voiceNoteFilePath = obj.optString("voiceNoteFilePath").takeIf { it.isNotBlank() },
                        voiceDurationSeconds = obj.optInt("voiceDurationSeconds", 0),
                        tags = obj.optString("tags", "Reflection"),
                        isLocked = obj.optBoolean("isLocked", false)
                    )
                )
            }

            if (prophetsList.isNotEmpty()) {
                dao.clearProphets()
                dao.insertProphets(prophetsList)
            }
            if (eventsList.isNotEmpty()) {
                dao.clearEvents()
                dao.insertEvents(eventsList)
            }
            if (diaryList.isNotEmpty()) {
                dao.clearDiary()
                for (d in diaryList) {
                    dao.insertDiaryEntry(d)
                }
            }

            prophetsList.size + eventsList.size + diaryList.size
        }
    }

    suspend fun resetToDefaultData() = withContext(Dispatchers.IO) {
        dao.clearProphets()
        dao.clearEvents()
        AppDatabase.populateInitialData(dao)
    }
}
