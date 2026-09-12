package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        ProphetEntity::class,
        ProphetEventEntity::class,
        PersonalDiaryEntryEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun prophetDao(): ProphetDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "qisas_anbiya_database.db"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Populate in background coroutine on first create
                            CoroutineScope(Dispatchers.IO).launch {
                                populateInitialData(getInstance(context).prophetDao())
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        suspend fun populateInitialData(dao: ProphetDao) {
            val initial = InitialData.getInitialData()
            val prophets = initial.map { it.prophet }
            val events = initial.flatMap { it.events }
            dao.insertProphets(prophets)
            dao.insertEvents(events)

            // Also seed a welcome personal reflection note
            dao.insertDiaryEntry(
                PersonalDiaryEntryEntity(
                    id = 1,
                    title = "Bismillah - Meri Ruhani Diary",
                    content = "Aaj se maine Anbiya-e-Kiram ke jivan aur unke azeem sabr se seekh kar apne rooz-marrah ke tajurbaat aur dilli jazbaat ko kalam-band karna shuru kiya hai. Allah se dua hai ki hamein unke naqsh-e-qadam par chalne ki taufeeq ata farmaye.",
                    tags = "Reflection, Dua, Bismillah",
                    isLocked = false
                )
            )
        }
    }
}
