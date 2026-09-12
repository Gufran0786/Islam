package com.example.ui.quran

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuranAnswerItem
import com.example.data.QuranQuestionAnswerData
import com.example.ui.theme.LocalBookPalette

@Composable
fun QuranQuestionBar(
    onNavigateToSurah: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    var query by remember { mutableStateOf("") }
    var selectedAnswer by remember { mutableStateOf<QuranAnswerItem?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    val sampleQuestions = remember {
        listOf(
            "kya shirk karna haram hai?",
            "kya namaz farz hai?",
            "maa baap ke huqooq",
            "kya sood haram hai?",
            "kya zina haram hai?",
            "sabar ka ajar",
            "tauba aur maafi",
            "rizq aur barkat",
            "kya ghaibat haram hai?",
            "sharab aur juwa"
        )
    }

    val searchResults = remember(query) {
        if (query.isBlank()) emptyList()
        else QuranQuestionAnswerData.searchQuranAnswers(query)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = palette.cardBackground
        ),
        shape = RoundedCornerShape(16.dp),
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.border)),
        modifier = modifier
            .fillMaxWidth()
            .testTag("quran_question_bar_card")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row with Title and Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(palette.accent.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.QuestionAnswer,
                            contentDescription = null,
                            tint = palette.accent,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "قرآن سے سوال پوچھیں (Ask Quran)",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "कुरआन से सवाल पूछें • हर सवाल का जवाब आयत के साथ",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textSecondary
                        )
                    }
                }

                IconButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Toggle",
                        tint = palette.accent
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Search / Question Input
            OutlinedTextField(
                value = query,
                onValueChange = {
                    query = it
                    if (it.isNotBlank()) isExpanded = true
                    if (it.isBlank()) selectedAnswer = null
                },
                placeholder = {
                    Text(
                        text = "e.g. Kya shirk karna haram hai? (سوال لکھیں)...",
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textSecondary
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.HelpOutline,
                        contentDescription = "Question",
                        tint = palette.accent
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = {
                            query = ""
                            selectedAnswer = null
                        }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = palette.textSecondary)
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quran_question_input")
            )

            // Sample Question Chips
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "عام سوالات (Common Questions):",
                style = MaterialTheme.typography.labelSmall,
                color = palette.accent,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(6.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(sampleQuestions) { sample ->
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (query.equals(sample, ignoreCase = true)) palette.accent else palette.surface,
                        border = androidx.compose.foundation.BorderStroke(1.dp, palette.border),
                        modifier = Modifier.clickable {
                            query = sample
                            isExpanded = true
                            val found = QuranQuestionAnswerData.searchQuranAnswers(sample).firstOrNull()
                            selectedAnswer = found
                        }
                    ) {
                        Text(
                            text = sample,
                            style = MaterialTheme.typography.labelSmall,
                            color = if (query.equals(sample, ignoreCase = true)) Color.White else palette.textPrimary,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            // Results / Selected Answer Display
            AnimatedVisibility(
                visible = isExpanded && (selectedAnswer != null || searchResults.isNotEmpty()),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    val activeAnswer = selectedAnswer ?: searchResults.firstOrNull()

                    if (activeAnswer != null) {
                        QuranAnswerDetailCard(
                            answerItem = activeAnswer,
                            onOpenSurah = {
                                onNavigateToSurah(activeAnswer.surahNumber)
                            }
                        )
                    } else if (query.isNotBlank()) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = palette.surface,
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                        ) {
                            Text(
                                text = "کوئی خاص نتیجہ نہیں ملا، برائے مہربانی الفاظ تبدیل کر کے تلاش کریں۔",
                                style = MaterialTheme.typography.bodySmall,
                                color = palette.textSecondary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuranAnswerDetailCard(
    answerItem: QuranAnswerItem,
    onOpenSurah: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current

    Card(
        colors = CardDefaults.cardColors(
            containerColor = palette.surface
        ),
        shape = RoundedCornerShape(14.dp),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.4f))
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Surah and Ayah Badge Header
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
                        text = "📖 ${answerItem.surahNameRoman} (${answerItem.surahNameArabic}) • آیت #${answerItem.ayahNumber}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                TextButton(
                    onClick = onOpenSurah,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "سورۃ کھولیں",
                        style = MaterialTheme.typography.labelSmall,
                        color = palette.accent,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = palette.accent,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Direct Concise Answer
            Text(
                text = "✨ براہِ راست جواب (Direct Quranic Answer):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.directAnswerHinglish,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = palette.textPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.directAnswerHindi,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(10.dp))

            // 1. Arabic Ayah Text
            Text(
                text = "آیت مبارکہ (Arabic Text):",
                style = MaterialTheme.typography.labelSmall,
                color = palette.accent,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = answerItem.arabicAyahText,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 22.sp,
                    lineHeight = 36.sp
                ),
                color = palette.textPrimary,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 2. Hinglish (Roman) Transliteration / Text
            Text(
                text = "🔤 Hinglish (Roman Urdu):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.hinglishAyahText,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textPrimary,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 3. Hindi Translation
            Text(
                text = "🇮🇳 हिन्दी तर्जुमा (Hindi Translation):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.hindiAyahTranslation,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 4. Urdu Translation
            Text(
                text = "🇵🇰 اردو ترجمہ (Urdu Translation):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.urduAyahTranslation,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 22.sp),
                color = palette.textPrimary,
                textAlign = TextAlign.Start
            )
        }
    }
}
