package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProphetDao {

    // --- PROPHETS ---
    @Query("SELECT * FROM prophets ORDER BY orderIndex ASC")
    fun getAllProphets(): Flow<List<ProphetEntity>>

    @Query("SELECT * FROM prophets WHERE isBookmarked = 1 ORDER BY orderIndex ASC")
    fun getBookmarkedProphets(): Flow<List<ProphetEntity>>

    @Query("SELECT * FROM prophets WHERE id = :id LIMIT 1")
    fun getProphetById(id: Int): Flow<ProphetEntity?>

    @Query("SELECT * FROM prophets WHERE id = :id LIMIT 1")
    suspend fun getProphetByIdSync(id: Int): ProphetEntity?

    @Query("""
        SELECT * FROM prophets 
        WHERE nameRoman LIKE '%' || :query || '%' 
           OR nameArabic LIKE '%' || :query || '%'
           OR title LIKE '%' || :query || '%'
           OR fatherName LIKE '%' || :query || '%'
           OR motherName LIKE '%' || :query || '%'
           OR siblings LIKE '%' || :query || '%'
           OR summaryHighlights LIKE '%' || :query || '%'
        ORDER BY orderIndex ASC
    """)
    fun searchProphets(query: String): Flow<List<ProphetEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProphet(prophet: ProphetEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProphets(prophets: List<ProphetEntity>): List<Long>

    @Update
    suspend fun updateProphet(prophet: ProphetEntity)

    @Delete
    suspend fun deleteProphet(prophet: ProphetEntity)

    @Query("SELECT COUNT(*) FROM prophets")
    suspend fun getProphetsCount(): Int

    // --- EVENTS ---
    @Query("SELECT * FROM prophet_events WHERE prophetId = :prophetId ORDER BY orderIndex ASC, id ASC")
    fun getEventsForProphet(prophetId: Int): Flow<List<ProphetEventEntity>>

    @Query("SELECT * FROM prophet_events WHERE id = :id LIMIT 1")
    suspend fun getEventById(id: Int): ProphetEventEntity?

    @Query("""
        SELECT * FROM prophet_events 
        WHERE title LIKE '%' || :query || '%' 
           OR summary LIKE '%' || :query || '%'
           OR detailedNarrative LIKE '%' || :query || '%'
           OR moralLesson LIKE '%' || :query || '%'
        ORDER BY id ASC
    """)
    fun searchEvents(query: String): Flow<List<ProphetEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: ProphetEventEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvents(events: List<ProphetEventEntity>): List<Long>

    @Update
    suspend fun updateEvent(event: ProphetEventEntity)

    @Delete
    suspend fun deleteEvent(event: ProphetEventEntity)

    // --- DIARY & VOICE REFLECTIONS ---
    @Query("SELECT * FROM personal_diary_entries ORDER BY dateMillis DESC")
    fun getAllDiaryEntries(): Flow<List<PersonalDiaryEntryEntity>>

    @Query("SELECT * FROM personal_diary_entries WHERE dateMillis BETWEEN :startMillis AND :endMillis ORDER BY dateMillis ASC")
    fun getDiaryEntriesInRange(startMillis: Long, endMillis: Long): Flow<List<PersonalDiaryEntryEntity>>

    @Query("""
        SELECT * FROM personal_diary_entries 
        WHERE title LIKE '%' || :query || '%' 
           OR content LIKE '%' || :query || '%'
           OR tags LIKE '%' || :query || '%'
        ORDER BY dateMillis DESC
    """)
    fun searchDiaryEntries(query: String): Flow<List<PersonalDiaryEntryEntity>>

    @Query("SELECT * FROM personal_diary_entries WHERE tags LIKE '%' || :tag || '%' ORDER BY dateMillis DESC")
    fun getDiaryEntriesByTag(tag: String): Flow<List<PersonalDiaryEntryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiaryEntry(entry: PersonalDiaryEntryEntity): Long

    @Update
    suspend fun updateDiaryEntry(entry: PersonalDiaryEntryEntity)

    @Delete
    suspend fun deleteDiaryEntry(entry: PersonalDiaryEntryEntity)

    // --- BACKUP & EXPORT ---
    @Query("SELECT * FROM prophets ORDER BY orderIndex ASC")
    suspend fun getAllProphetsSync(): List<ProphetEntity>

    @Query("SELECT * FROM prophet_events ORDER BY id ASC")
    suspend fun getAllEventsSync(): List<ProphetEventEntity>

    @Query("SELECT * FROM personal_diary_entries ORDER BY id ASC")
    suspend fun getAllDiaryEntriesSync(): List<PersonalDiaryEntryEntity>

    @Query("DELETE FROM prophets")
    suspend fun clearProphets()

    @Query("DELETE FROM prophet_events")
    suspend fun clearEvents()

    @Query("DELETE FROM personal_diary_entries")
    suspend fun clearDiary()
}
