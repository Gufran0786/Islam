package com.example.ui.quran

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Ayah
import com.example.data.QuranDisplaySettings
import com.example.data.Surah
import com.example.ui.AppScreen
import com.example.ui.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurahReaderScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val currentSurah by viewModel.currentSurah.collectAsState()
    val ayahs by viewModel.currentSurahAyahs.collectAsState()
    val quranSettings by viewModel.quranSettings.collectAsState()
    val bookmarkedAyahs by viewModel.quranBookmarkedAyahs.collectAsState()

    var showSettingsDialog by remember { mutableStateOf(false) }
    var showSurahInfoDialog by remember { mutableStateOf(false) }

    if (showSettingsDialog) {
        QuranSettingsDialog(
            settings = quranSettings,
            onDismiss = { showSettingsDialog = false },
            onSave = { updated ->
                viewModel.updateQuranSettings(
                    showArabic = updated.showArabic,
                    showHinglish = updated.showHinglish,
                    showUrdu = updated.showUrdu,
                    showHindi = updated.showHindi,
                    arabicFontSizeSp = updated.arabicFontSizeSp,
                    translationFontSizeSp = updated.translationFontSizeSp
                )
            }
        )
    }

    if (showSurahInfoDialog && currentSurah != null) {
        SurahInfoDialog(
            surah = currentSurah!!,
            onDismiss = { showSurahInfoDialog = false }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = currentSurah?.let { "سورة ${it.nameArabic} • ${it.nameRoman}" } ?: "Al-Quran",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = currentSurah?.let {
                                "${if (it.revelationType == "Makki") "مکی" else "مدنی"} • ${it.totalVerses} آیات • پارہ ${it.juzNumber}"
                            } ?: "",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.navigateTo(AppScreen.QURAN_INDEX) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Quran Index"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { showSurahInfoDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Surah Information",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = { showSettingsDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = "Quran Display Settings",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            SurahBottomNavigationBar(
                currentSurahNumber = currentSurah?.number ?: 1,
                onPrevious = { viewModel.previousSurah() },
                onNext = { viewModel.nextSurah() },
                onBackToIndex = { viewModel.navigateTo(AppScreen.QURAN_INDEX) }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding() + 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Surah Title Banner
            currentSurah?.let { surah ->
                item {
                    SurahTitleCard(surah = surah)
                }

                // Bismillah Banner (All Surahs except Surah 9: At-Tawbah)
                if (surah.number != 9) {
                    item {
                        BismillahCard(settings = quranSettings)
                    }
                }
            }

            // List of Ayahs
            itemsIndexed(ayahs, key = { _, ayah -> "${ayah.surahNumber}:${ayah.ayahNumber}" }) { _, ayah ->
                val isBookmarked = bookmarkedAyahs.contains("${ayah.surahNumber}:${ayah.ayahNumber}")

                AyahCard(
                    ayah = ayah,
                    settings = quranSettings,
                    isBookmarked = isBookmarked,
                    onBookmarkToggle = {
                        viewModel.toggleAyahBookmark(ayah.surahNumber, ayah.ayahNumber)
                    },
                    onCopy = {
                        val textToCopy = buildString {
                            appendLine("${ayah.surahNumber}:${ayah.ayahNumber}")
                            if (quranSettings.showArabic) appendLine(ayah.arabicText)
                            if (quranSettings.showHinglish) appendLine("Hinglish: ${ayah.hinglishText}")
                            if (quranSettings.showUrdu) appendLine("Urdu: ${ayah.urduTranslation}")
                            if (quranSettings.showHindi) appendLine("Hindi: ${ayah.hindiTranslation}")
                        }
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        clipboard.setPrimaryClip(ClipData.newPlainText("Ayah ${ayah.surahNumber}:${ayah.ayahNumber}", textToCopy))
                        viewModel.showFeedback("آیت کاپی کر لی گئی (Ayah copied)")
                    },
                    onShare = {
                        val shareText = buildString {
                            appendLine("القرآن الکریم • سورة ${currentSurah?.nameArabic ?: ""} (${ayah.surahNumber}:${ayah.ayahNumber})")
                            appendLine()
                            if (quranSettings.showArabic) {
                                appendLine(ayah.arabicText)
                                appendLine()
                            }
                            if (quranSettings.showHinglish) {
                                appendLine("Hinglish: ${ayah.hinglishText}")
                                appendLine()
                            }
                            if (quranSettings.showUrdu) {
                                appendLine("اردو ترجمہ: ${ayah.urduTranslation}")
                                appendLine()
                            }
                            if (quranSettings.showHindi) {
                                appendLine("हिन्दी अनुवाद: ${ayah.hindiTranslation}")
                                appendLine()
                            }
                        }
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, shareText)
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(sendIntent, "Share Ayah"))
                    }
                )
            }
        }
    }
}

@Composable
private fun SurahTitleCard(surah: Surah) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "سُورَةُ ${surah.nameArabic}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = surah.nameRoman,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = "${surah.nameTranslation} • ${surah.meaningHindi}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f),
                textAlign = TextAlign.Center
            )

            Text(
                text = "اردو معنی: ${surah.meaningUrdu}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.75f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = if (surah.revelationType == "Makki") "مکی (Makki)" else "مدنی (Madani)",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "${surah.totalVerses} آیات (Verses)",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "پارہ ${surah.juzNumber}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun BismillahCard(settings: QuranDisplaySettings) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Arabic Bismillah
            Text(
                text = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = (settings.arabicFontSizeSp * 1.05f).sp
                ),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            if (settings.showHinglish) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Bismil-laahir-Rahmaanir-Raheem",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                        fontSize = (settings.translationFontSizeSp * 0.95f).sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }

            if (settings.showUrdu) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "شروع اللہ کا نام لے کر جو بڑا مہربان نہایت رحم والا ہے",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = settings.translationFontSizeSp.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }

            if (settings.showHindi) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "अल्लाह के नाम से शुरू जो बड़ा मेहरबान और निहायत रहम करने वाला है।",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = settings.translationFontSizeSp.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun AyahCard(
    ayah: Ayah,
    settings: QuranDisplaySettings,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onCopy: () -> Unit,
    onShare: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Row: Ayah Number badge + Actions (Bookmark, Copy, Share)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ayah Badge
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "${ayah.surahNumber}:${ayah.ayahNumber}",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                // Action Icons
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBookmarkToggle) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark Ayah",
                            tint = if (isBookmarked) Color(0xFFD4AF37) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(onClick = onCopy) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Copy Ayah",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(onClick = onShare) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share Ayah",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 1. ARABIC TEXT
            if (settings.showArabic) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "${ayah.arabicText} ۝${ayah.ayahNumber}",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = settings.arabicFontSizeSp.sp,
                            lineHeight = (settings.arabicFontSizeSp * 1.6f).sp
                        ),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 2. HINGLISH / ROMAN TRANSLITERATION
            if (settings.showHinglish && ayah.hinglishText.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "HINGLISH",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = ayah.hinglishText,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontStyle = FontStyle.Italic,
                                fontSize = settings.translationFontSizeSp.sp,
                                lineHeight = (settings.translationFontSizeSp * 1.4f).sp
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 3. URDU TRANSLATION
            if (settings.showUrdu && ayah.urduTranslation.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "اردو ترجمہ",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = ayah.urduTranslation,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = settings.translationFontSizeSp.sp,
                                lineHeight = (settings.translationFontSizeSp * 1.5f).sp
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 4. HINDI TRANSLATION
            if (settings.showHindi && ayah.hindiTranslation.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.35f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "हिन्दी अनुवाद",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = ayah.hindiTranslation,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = settings.translationFontSizeSp.sp,
                                lineHeight = (settings.translationFontSizeSp * 1.4f).sp
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SurahBottomNavigationBar(
    currentSurahNumber: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onBackToIndex: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = onPrevious,
                enabled = currentSurahNumber > 1,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("سابقہ سورة")
            }

            FilledTonalButton(
                onClick = onBackToIndex,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.List, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("فہرست")
            }

            OutlinedButton(
                onClick = onNext,
                enabled = currentSurahNumber < 114,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("اگلی سورة")
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun SurahInfoDialog(
    surah: Surah,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column {
                Text(
                    text = "سورة ${surah.nameArabic} (${surah.nameRoman})",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${surah.nameTranslation} • ${surah.meaningHindi}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "معلومات و فضائل (Information & Context):",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "• سورة نمبر: ${surah.number}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• نزول کی جگہ: ${if (surah.revelationType == "Makki") "مکہ مکرمہ (مکی)" else "مدینہ منورہ (مدنی)"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• کل آیات: ${surah.totalVerses}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• پارہ: ${surah.juzNumber}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• تعارف: ${surah.summary}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("ٹھیک ہے (Close)")
            }
        }
    )
}
