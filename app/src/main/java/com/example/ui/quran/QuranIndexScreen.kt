package com.example.ui.quran

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.LastReadPosition
import com.example.data.Surah
import com.example.ui.MainViewModel
import com.example.ui.QuranFilter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuranIndexScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val surahs by viewModel.filteredSurahs.collectAsState()
    val searchQuery by viewModel.quranSearchQuery.collectAsState()
    val currentFilter by viewModel.quranFilter.collectAsState()
    val lastRead by viewModel.quranLastRead.collectAsState()
    val quranSettings by viewModel.quranSettings.collectAsState()

    var showSettingsDialog by remember { mutableStateOf(false) }

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "القرآن الكريم",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Al-Quran • Arabic, Hinglish, Urdu & Hindi",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
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
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding() + 80.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Banner Card
            item {
                QuranHeaderBanner(
                    lastRead = lastRead,
                    onContinueReading = {
                        viewModel.selectSurah(lastRead.surahNumber)
                    }
                )
            }

            // Quran Question Bar (Ask Quran with Arabic, Hinglish, Urdu, Hindi answers)
            item {
                QuranQuestionBar(
                    onNavigateToSurah = { surahNum ->
                        viewModel.selectSurah(surahNum)
                    }
                )
            }

            // Quick Jump Chips
            item {
                QuickJumpSection(
                    onSurahSelected = { surahNum ->
                        viewModel.selectSurah(surahNum)
                    }
                )
            }

            // Search Bar
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.setQuranSearchQuery(it) },
                    placeholder = {
                        Text("سورة، نام، معنی یا آیت تلاش کریں (Search Surah / Ayah)...")
                    },
                    leadingIcon = {
                        Icon(Icons.Outlined.Search, contentDescription = "Search")
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { viewModel.setQuranSearchQuery("") }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear search")
                            }
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Category Filter Chips (All, Makki, Madani, Bookmarks)
            item {
                FilterChipsRow(
                    currentFilter = currentFilter,
                    onFilterSelected = { viewModel.setQuranFilter(it) }
                )
            }

            // Surah Count Indicator
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "سورتیں (Surahs): ${surahs.size}",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "114 سورتیں • 30 پارے",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Surah List
            items(surahs, key = { it.number }) { surah ->
                SurahItemCard(
                    surah = surah,
                    onClick = {
                        viewModel.selectSurah(surah.number)
                    }
                )
            }

            if (surahs.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "کوئی سورت نہیں ملی (No Surahs found)",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun QuranHeaderBanner(
    lastRead: LastReadPosition,
    onContinueReading: () -> Unit
) {
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
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "كِتَٰبٌ أَنزَلْنَٰهُ إِلَيْكَ مُبَٰرَكٌ لِّيَدَّبَّرُوٓا۟ ءَايَٰتِهِۦ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                    )
                    Text(
                        text = "یہ ایک بابرکت کتاب ہے جو ہم نے آپ پر نازل کی تاکہ وہ اس کی آیات پر غور کریں",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.75f)
                    )
                }
                Icon(
                    imageVector = Icons.Default.AutoStories,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            Divider(color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f))
            Spacer(modifier = Modifier.height(10.dp))

            // Last Read Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "پڑھنا جاری رکھیں (Last Read)",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                        )
                        Text(
                            text = "${lastRead.surahNumber}. ${lastRead.surahNameRoman} (آیت ${lastRead.ayahNumber})",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }

                Button(
                    onClick = onContinueReading,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Icon(
                        Icons.Default.MenuBook,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("پڑھیں / Read", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
private fun QuickJumpSection(onSurahSelected: (Int) -> Unit) {
    Column {
        Text(
            text = "اہم سورتیں (Quick Jump):",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(6.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            val quickList = listOf(
                Pair(1, "الفاتحة • Fatihah"),
                Pair(2, "آية الكرسي • Baqarah"),
                Pair(36, "يس • Ya-Sin"),
                Pair(55, "الرحمن • Ar-Rahman"),
                Pair(67, "الملك • Al-Mulk"),
                Pair(18, "الكهف • Al-Kahf"),
                Pair(93, "الضحى • Ad-Duha"),
                Pair(112, "الإخلاص • Al-Ikhlas"),
                Pair(113, "الفلق • Al-Falaq"),
                Pair(114, "الناس • An-Nas")
            )
            items(quickList) { (number, label) ->
                SuggestionChip(
                    onClick = { onSurahSelected(number) },
                    label = { Text(label, style = MaterialTheme.typography.labelSmall) },
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }
    }
}

@Composable
private fun FilterChipsRow(
    currentFilter: QuranFilter,
    onFilterSelected: (QuranFilter) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = currentFilter == QuranFilter.ALL,
            onClick = { onFilterSelected(QuranFilter.ALL) },
            label = { Text("تمام (All 114)") },
            leadingIcon = if (currentFilter == QuranFilter.ALL) {
                { Icon(Icons.Default.Done, contentDescription = null, modifier = Modifier.size(16.dp)) }
            } else null
        )
        FilterChip(
            selected = currentFilter == QuranFilter.MAKKI,
            onClick = { onFilterSelected(QuranFilter.MAKKI) },
            label = { Text("مکی (Makki)") }
        )
        FilterChip(
            selected = currentFilter == QuranFilter.MADANI,
            onClick = { onFilterSelected(QuranFilter.MADANI) },
            label = { Text("مدنی (Madani)") }
        )
        FilterChip(
            selected = currentFilter == QuranFilter.BOOKMARKS,
            onClick = { onFilterSelected(QuranFilter.BOOKMARKS) },
            label = { Text("محفوظ (Saved)") },
            leadingIcon = {
                Icon(Icons.Outlined.BookmarkBorder, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        )
    }
}

@Composable
fun SurahItemCard(
    surah: Surah,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Surah Number Badge with Islamic star / circle look
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${surah.number}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            // Details Column
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = surah.nameRoman,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = surah.nameArabic,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Meaning in English and Hindi
                Text(
                    text = "${surah.nameTranslation} • ${surah.meaningHindi}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Urdu Meaning
                Text(
                    text = "اردو معنی: ${surah.meaningUrdu}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Tags: Verses count, Makki/Madani, Para
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f)
                    ) {
                        Text(
                            text = "${surah.totalVerses} آیات (Ayahs)",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (surah.revelationType == "Makki") {
                            MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f)
                        } else {
                            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                        }
                    ) {
                        Text(
                            text = if (surah.revelationType == "Makki") "مکی (Makki)" else "مدنی (Madani)",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "پارہ ${surah.juzNumber}",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
