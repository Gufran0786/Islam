package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppLanguage
import com.example.ui.AppScreen
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette
import com.example.util.AppLocaleManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    language: AppLanguage,
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "صفحۂ اول (Home)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { onNavigate(AppScreen.SETTINGS) },
                        modifier = Modifier.testTag("home_btn_settings")
                    ) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings", tint = palette.accent)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = palette.surface)
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Main Branding Header (Requested by user)
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    shape = RoundedCornerShape(20.dp),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.4f))
                    ),
                    modifier = Modifier.fillMaxWidth().testTag("home_header_card")
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = palette.accent,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // App Name
                        Text(
                            text = "Qisas Anbiya",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.ExtraBold
                            ),
                            color = palette.textPrimary,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "قصص الأنبياء عليهم السلام",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = palette.accent
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // USER REQUIREMENT: "create by Gufran Khan"
                        Surface(
                            shape = CircleShape,
                            color = palette.accent.copy(alpha = 0.12f)
                        ) {
                            Text(
                                text = "create by Gufran Khan",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = palette.accent,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "۴۲ انبیائے کرام کی سوانح حیات، بیویاں، مکمل قرآن مجید، سوال و جواب اور نماز کے اوقات",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Quick Feature Grid
            item {
                Text(
                    text = "اہم شعبہ جات (Key Sections):",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent
                )
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FeatureRow(
                        title = "قصص الأنبياء (42 Prophets & Wives)",
                        subtitle = "حضرت آدم علیہ السلام سے خاتم النبیین ﷺ تک، بیویاں و واقعات",
                        icon = Icons.Default.AutoStories,
                        badge = "42",
                        onClick = { onNavigate(AppScreen.BOOKSHELF) },
                        testTag = "home_nav_prophets"
                    )

                    FeatureRow(
                        title = "القرآن الكريم وسوالات (Quran & Questions)",
                        subtitle = "۱۱۴ سورتیں، ترجمہ، تلاوت اور قرآنی سوال و جواب سرچ بار",
                        icon = Icons.Default.MenuBook,
                        badge = "114",
                        onClick = { onNavigate(AppScreen.QURAN_INDEX) },
                        testTag = "home_nav_quran"
                    )

                    FeatureRow(
                        title = "اوقاتِ نماز و الارم (Prayer Times & Alarm)",
                        subtitle = "دستی اوقات سیٹ کریں، تکبیر الارم اور لائیو وقت",
                        icon = Icons.Default.AccessTime,
                        badge = "اذان",
                        onClick = { onNavigate(AppScreen.PRAYER_TIME) },
                        testTag = "home_nav_prayer"
                    )

                    FeatureRow(
                        title = "شجرۂ انبیائے کرام (Family Tree)",
                        subtitle = "انبیائے کرام کے باہمی شجرہ نسب اور آباء و اجداد کا نقشہ",
                        icon = Icons.Default.AccountTree,
                        badge = "شجرہ",
                        onClick = { onNavigate(AppScreen.FAMILY_TREE) },
                        testTag = "home_nav_tree"
                    )

                    FeatureRow(
                        title = "ملائکہ (Angels in Islam)",
                        subtitle = "مقدس فرشتوں کے فرائض و احکامات",
                        icon = Icons.Default.AutoAwesome,
                        badge = "ملائکہ",
                        onClick = { onNavigate(AppScreen.ANGELS) },
                        testTag = "home_nav_angels"
                    )

                    FeatureRow(
                        title = "روحانی ڈائری (Spiritual Diary)",
                        subtitle = "روزمرہ تاثرات، دعائیں اور محفوظ ذاتی نوٹس",
                        icon = Icons.Default.EditNote,
                        badge = "نوٹس",
                        onClick = { onNavigate(AppScreen.DIARY_JOURNAL) },
                        testTag = "home_nav_diary"
                    )
                }
            }

            // Ayat of the Day / Quranic reflection banner
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.accent.copy(alpha = 0.08f)),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.25f))),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.FormatQuote, contentDescription = null, tint = palette.accent, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "آیتِ مبارکہ (Quranic Reflection):",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = palette.accent
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "لَقَدْ كَانَ فِي قَصَصِهِمْ عِبْرَةٌ لِّأُولِي الْأَلْبَابِ ۗ",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "“Albatta unke qisson me aqal-mandon ke liye azeem ibrat aur sabak hai.” (Surah Yusuf 12:111)",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            // Footer with Creator signature
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Qisas Anbiya • create by Gufran Khan",
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textSecondary
                    )
                }
            }
        }
    }
}

@Composable
private fun FeatureRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    badge: String,
    onClick: () -> Unit,
    testTag: String,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current

    Card(
        colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
        shape = RoundedCornerShape(14.dp),
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.border)),
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(palette.accent.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = palette.accent,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.textPrimary
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = palette.textSecondary,
                    maxLines = 2
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = palette.accent.copy(alpha = 0.12f)
            ) {
                Text(
                    text = badge,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = palette.textSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
