package com.example.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "prophets")
data class ProphetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val orderIndex: Int = 0,
    val nameArabic: String,
    val nameRoman: String,
    val title: String,
    val ageYears: String,
    val fatherName: String,
    val motherName: String,
    val siblings: String,
    val children: String = "",
    val eraLocation: String = "",
    val photoUrlOrRes: String = "", // Drawable name e.g. "img_app_icon" or custom content URI / URL
    val isBookmarked: Boolean = false,
    val summaryHighlights: String = "",
    val lastUpdated: Long = System.currentTimeMillis()
)

@Entity(
    tableName = "prophet_events",
    foreignKeys = [
        ForeignKey(
            entity = ProphetEntity::class,
            parentColumns = ["id"],
            childColumns = ["prophetId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["prophetId"])]
)
data class ProphetEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prophetId: Int,
    val title: String,
    val summary: String, // Quick highlight summary section requested by user
    val detailedNarrative: String, // Full book-like story of the event
    val eventPhotoUrlOrRes: String = "", // Changeable photo/image
    val quranicReference: String = "",
    val moralLesson: String = "",
    val orderIndex: Int = 0,
    val lastUpdated: Long = System.currentTimeMillis()
)

@Entity(tableName = "personal_diary_entries")
data class PersonalDiaryEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val dateMillis: Long = System.currentTimeMillis(),
    val title: String,
    val content: String,
    val voiceNoteFilePath: String? = null,
    val voiceDurationSeconds: Int = 0,
    val tags: String = "Reflection", // Comma-separated
    val isLocked: Boolean = false,
    val associatedProphetId: Int? = null,
    val lastUpdated: Long = System.currentTimeMillis()
)

enum class PaperStyle(val displayName: String, val description: String) {
    PARCHMENT("Qadim Kagaz (Parchment)", "Warm vintage sepia manuscript"),
    CREAM("Ivory Cream", "Classic soft book paper"),
    WHITE("Crisp White", "Modern high-contrast clean paper"),
    FOREST("Sage Green", "Calming earthy tone"),
    DARK("Midnight Charcoal", "Low-light reading canvas"),
    AMOLED("OLED Pure Black", "Zero battery pitch black")
}

enum class BookFont(val displayName: String) {
    SERIF("Classic Serif (Book)"),
    SANS("Clean Sans-Serif"),
    MONO("Journal Monospace")
}

data class ReaderSettings(
    val paperStyle: PaperStyle = PaperStyle.PARCHMENT,
    val bookFont: BookFont = BookFont.SERIF,
    val fontSizeSp: Float = 16f,
    val isDarkMode: Boolean = false,
    val useSystemTheme: Boolean = false,
    val isAppLockEnabled: Boolean = false,
    val lockPin: String = "",
    val dailyReminderEnabled: Boolean = false,
    val reminderHour: Int = 20,
    val reminderMinute: Int = 0,
    val appLanguage: AppLanguage = AppLanguage.HINDI
)
