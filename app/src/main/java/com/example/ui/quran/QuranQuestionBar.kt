package com.example.ui.quran

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuranAnswerItem
import com.example.data.QuranQuestionAnswerData
import com.example.ui.theme.LocalBookPalette
import kotlinx.coroutines.launch

@Composable
fun QuranQuestionBar(
    onNavigateToSurah: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()

    var query by remember { mutableStateOf("") }
    var hasSubmitted by remember { mutableStateOf(false) }
    var isSearching by remember { mutableStateOf(false) }
    var currentAnswers by remember { mutableStateOf<List<QuranAnswerItem>>(emptyList()) }
    var selectedIndex by remember { mutableIntStateOf(0) }
    var isExpanded by remember { mutableStateOf(false) }

    val sampleQuestions = remember {
        listOf(
            "Allah kaun hai?",
            "kya namaz farz hai?",
            "kya roza farz hai?",
            "maa baap ke huqooq",
            "kya sood haram hai?",
            "dil ka sukoon kaise mile?",
            "dua qubool hona",
            "bimari se shifa",
            "sabar ka ajar",
            "tauba aur maghfirat",
            "rizq mein barkat",
            "zakat ka hukm",
            "hajj kis par farz hai?",
            "tahajjud ki fazeelat",
            "jannat ki neamatein",
            "nikah aur shadi",
            "ilm ki ahmiyat",
            "gussa zabt karna"
        )
    }

    // Function to trigger answering user query
    val triggerSearch: () -> Unit = {
        keyboardController?.hide()
        if (query.isNotBlank()) {
            isSearching = true
            coroutineScope.launch {
                val results = QuranQuestionAnswerData.searchQuranAnswers(query, context)
                currentAnswers = results
                selectedIndex = 0
                hasSubmitted = true
                isExpanded = true
                isSearching = false
            }
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = palette.cardBackground
        ),
        shape = RoundedCornerShape(16.dp),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(palette.border)
        ),
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(palette.accent.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.QuestionAnswer,
                            contentDescription = null,
                            tint = palette.accent,
                            modifier = Modifier.size(20.dp)
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
                            text = "سوال درج کریں اور Enter دبائیں • ہر سوال کا جواب آیت کے ساتھ",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textSecondary
                        )
                    }
                }

                IconButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Toggle",
                        tint = palette.accent
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Search / Question Input Field
            OutlinedTextField(
                value = query,
                onValueChange = {
                    query = it
                    if (it.isBlank()) {
                        hasSubmitted = false
                    }
                },
                placeholder = {
                    Text(
                        text = "e.g. Allah kaun hai? / کیا روزہ فرض ہے؟...",
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 4.dp)
                    ) {
                        if (query.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    query = ""
                                    hasSubmitted = false
                                    currentAnswers = emptyList()
                                },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    tint = palette.textSecondary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }

                        // Prominent inline Send / Enter Icon Button
                        IconButton(
                            onClick = { triggerSearch() },
                            enabled = query.isNotBlank() && !isSearching,
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    if (query.isNotBlank()) palette.accent else palette.accent.copy(alpha = 0.2f)
                                )
                                .testTag("quran_input_submit_icon_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Enter Question",
                                tint = if (query.isNotBlank()) Color.White else Color.White.copy(alpha = 0.5f),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { triggerSearch() }),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quran_question_input")
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Dedicated High-Visibility "Enter Question / Get Answer" Button
            Button(
                onClick = { triggerSearch() },
                enabled = query.isNotBlank() && !isSearching,
                colors = ButtonDefaults.buttonColors(
                    containerColor = palette.accent,
                    contentColor = Color.White,
                    disabledContainerColor = palette.accent.copy(alpha = 0.35f),
                    disabledContentColor = Color.White.copy(alpha = 0.6f)
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("quran_ask_enter_button")
            ) {
                if (isSearching) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "قرآن سے جواب تلاش ہو رہا ہے...",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Enter",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "سوال درج کریں اور جواب حاصل کریں (Enter Question)",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Sample Question Chips
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "عام سوالات منتخب کریں (یا اپنا نیا سوال لکھیں):",
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
                    val isSelected = query.equals(sample, ignoreCase = true)
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (isSelected) palette.accent else palette.surface,
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (isSelected) palette.accent else palette.border
                        ),
                        modifier = Modifier.clickable {
                            query = sample
                            isSearching = true
                            coroutineScope.launch {
                                val results = QuranQuestionAnswerData.searchQuranAnswers(sample, context)
                                currentAnswers = results
                                selectedIndex = 0
                                hasSubmitted = true
                                isExpanded = true
                                isSearching = false
                                keyboardController?.hide()
                            }
                        }
                    ) {
                        Text(
                            text = sample,
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isSelected) Color.White else palette.textPrimary,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            // Results / Selected Answer Display
            AnimatedVisibility(
                visible = isExpanded && hasSubmitted && currentAnswers.isNotEmpty(),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    val activeAnswer = currentAnswers.getOrNull(selectedIndex) ?: currentAnswers.firstOrNull()

                    if (activeAnswer != null) {
                        // Header indicating answered question
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "✨ قرآن پاک کا جواب:",
                                style = MaterialTheme.typography.labelMedium,
                                color = palette.accent,
                                fontWeight = FontWeight.Bold
                            )

                            // Quick reset / Ask another question button
                            TextButton(
                                onClick = {
                                    query = ""
                                    hasSubmitted = false
                                    currentAnswers = emptyList()
                                },
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "نیا سوال",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.accent,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // If multiple results found, display related tabs
                        if (currentAnswers.size > 1) {
                            Text(
                                text = "متعلقہ موضوعات (${currentAnswers.size} جوابات):",
                                style = MaterialTheme.typography.labelSmall,
                                color = palette.textSecondary,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            ) {
                                itemsIndexed(currentAnswers) { idx, resultItem ->
                                    val isCurrent = idx == selectedIndex
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = if (isCurrent) palette.accent.copy(alpha = 0.2f) else palette.surface,
                                        border = androidx.compose.foundation.BorderStroke(
                                            0.5.dp,
                                            if (isCurrent) palette.accent else palette.border
                                        ),
                                        modifier = Modifier.clickable {
                                            selectedIndex = idx
                                        }
                                    ) {
                                        Text(
                                            text = resultItem.questionHinglish.take(28) + if (resultItem.questionHinglish.length > 28) "..." else "",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = if (isCurrent) palette.accent else palette.textPrimary,
                                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }
                                }
                            }
                        }

                        // Answer Detail Card
                        QuranAnswerDetailCard(
                            answerItem = activeAnswer,
                            onOpenSurah = {
                                onNavigateToSurah(activeAnswer.surahNumber)
                            }
                        )
                    } else {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = palette.surface,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
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
    val context = LocalContext.current

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

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Copy Ayah & Answer Button
                    IconButton(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val textToCopy = """
                                ${answerItem.directAnswerHinglish}
                                
                                ${answerItem.arabicAyahText}
                                
                                ${answerItem.hinglishAyahText}
                                
                                اردو: ${answerItem.urduAyahTranslation}
                                हिन्दी: ${answerItem.hindiAyahTranslation}
                                (سورۃ ${answerItem.surahNameRoman}: آیت #${answerItem.ayahNumber})
                            """.trimIndent()
                            val clip = ClipData.newPlainText("Quran Answer", textToCopy)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "جواب اور آیت کاپی ہو گئی", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Copy Answer",
                            tint = palette.textSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

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
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = palette.accent,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Direct Concise Answer
            Text(
                text = "✨ براہِ راست قرآنی رہنمائی (Direct Answer):",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.accent
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = answerItem.directAnswerHinglish,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = palette.textPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.directAnswerUrdu,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 22.sp),
                color = palette.textPrimary,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = answerItem.directAnswerHindi,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
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

            // 2. Hinglish (Roman) Transliteration
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

            // 3. Urdu Translation
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

            Spacer(modifier = Modifier.height(8.dp))

            // 4. Hindi Translation
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
                color = palette.textSecondary
            )
        }
    }
}
