package com.example.ui.screens

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
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AngelEntity
import com.example.data.AngelsData
import com.example.ui.theme.LocalBookPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AngelsScreen(
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    var selectedCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }

    val categories = listOf(
        "All" to "تمام فرشتے (All)",
        "Chaar Muqarrab" to "چار مقرب فرشتے (4 Archangels)",
        "Aamaal o Qabar" to "اعمال و قبر (Deeds & Grave)",
        "Jannat o Jahannam" to "جنت و جہنم (Keepers)",
        "Nizam-e-Kainat" to "نظامِ کائنات و حفاظت (Guardians)"
    )

    val filteredAngels = remember(selectedCategory, searchQuery) {
        AngelsData.angelsList.filter { angel ->
            val matchesCategory = if (selectedCategory == "All") true else angel.category == selectedCategory
            val matchesSearch = if (searchQuery.isBlank()) true else {
                val q = searchQuery.trim().lowercase()
                angel.nameRoman.lowercase().contains(q) ||
                        angel.nameArabic.contains(q) ||
                        angel.nameHindi.lowercase().contains(q) ||
                        angel.nameUrdu.contains(q) ||
                        angel.primaryDutyHinglish.lowercase().contains(q) ||
                        angel.primaryDutyHindi.lowercase().contains(q) ||
                        angel.title.lowercase().contains(q)
            }
            matchesCategory && matchesSearch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "ملائکہ کرام (Angels in Islam)",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "फ़रिश्तों के नाम, उनके काम और क़ुरआनी हवाले",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = palette.surface
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
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Overview Banner
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.border)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(palette.accent.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.AutoAwesome,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "ایمان بالملائکہ (Angels Belief in Islam)",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.accent
                                )
                                Text(
                                    text = "اسلام کے بنیادی ارکانِ ایمان میں فرشتوں پر ایمان لانا فرض ہے۔",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = palette.textSecondary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "✨ فرشتے نور سے پیدا کیے گئے ہیں۔ وہ نہ مرد ہیں نہ عورت، نہ کھاتے ہیں نہ سوتے ہیں، اور ہر وقت اللہ کے حکم کی تعمیل میں مصروف رہتے ہیں۔",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textPrimary
                        )
                    }
                }
            }

            // Search Bar for Angels
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text("فرشتے کا نام یا کام تلاش کریں (Search Angel or duty)...", style = MaterialTheme.typography.bodySmall)
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = palette.accent)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear", tint = palette.textSecondary)
                            }
                        }
                    },
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().testTag("angels_search_input")
                )
            }

            // Category Filter Chips
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { (catKey, catLabel) ->
                        FilterChip(
                            selected = selectedCategory == catKey,
                            onClick = { selectedCategory = catKey },
                            label = { Text(catLabel, style = MaterialTheme.typography.labelSmall) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = palette.accent,
                                selectedLabelColor = Color.White,
                                containerColor = palette.surface,
                                labelColor = palette.textPrimary
                            )
                        )
                    }
                }
            }

            // Angel Cards
            items(filteredAngels, key = { it.id }) { angel ->
                AngelCard(angel = angel)
            }
        }
    }
}

@Composable
private fun AngelCard(
    angel: AngelEntity,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
        shape = RoundedCornerShape(16.dp),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(palette.border)
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
            .testTag("angel_card_${angel.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header Row: Category Badge & Arabic Name
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = palette.accent.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = angel.category,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Text(
                    text = angel.nameArabic,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                    fontWeight = FontWeight.Bold,
                    color = palette.accent,
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Roman, Urdu & Hindi Names
            Text(
                text = angel.nameRoman,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = palette.textPrimary
            )
            Text(
                text = "${angel.nameHindi} • ${angel.nameUrdu}",
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary
            )
            Text(
                text = angel.title,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                color = palette.accent
            )

            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(10.dp))

            // Primary Duty (بنیادی کام)
            Text(
                text = "⚡ بنیادی کام (Primary Duty):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = angel.primaryDutyHinglish,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = palette.textPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = angel.primaryDutyHindi,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary
            )

            // Expanded Details
            if (isExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // Detailed Responsibilities
                Text(
                    text = "📋 تفصیلی ذمہ داریاں (Detailed Duties):",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent
                )
                Spacer(modifier = Modifier.height(4.dp))
                angel.detailedResponsibilities.forEach { resp ->
                    Row(modifier = Modifier.padding(vertical = 2.dp)) {
                        Text(text = "• ", color = palette.accent, fontWeight = FontWeight.Bold)
                        Text(
                            text = resp,
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Quranic Reference Box
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = palette.surface,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "📖 قرآن پاک کا حوالہ (${angel.quranSurahReference}):",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = palette.accent
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = angel.quranAyahArabic,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp),
                            color = palette.textPrimary,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = angel.quranAyahTranslationUrdu,
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = angel.quranAyahTranslationHindi,
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Hadith Reference & Sifat
                Text(
                    text = "📜 حدیث حوالہ:",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent
                )
                Text(
                    text = angel.hadithReference,
                    style = MaterialTheme.typography.bodySmall,
                    color = palette.textSecondary
                )

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "🌟 صفات و خصوصیت: ${angel.specialCharacteristics}",
                    style = MaterialTheme.typography.labelSmall,
                    color = palette.textPrimary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Expand / Collapse Toggle Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isExpanded) "کم تفصیل دیکھیں (Show Less)" else "مزید تفصیلات و آیات دیکھیں (Show More Details)",
                    style = MaterialTheme.typography.labelSmall,
                    color = palette.accent,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = palette.accent,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
