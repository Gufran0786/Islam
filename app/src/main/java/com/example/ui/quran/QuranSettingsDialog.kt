package com.example.ui.quran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.QuranDisplaySettings

@Composable
fun QuranSettingsDialog(
    settings: QuranDisplaySettings,
    onDismiss: () -> Unit,
    onSave: (QuranDisplaySettings) -> Unit
) {
    var showArabic by remember { mutableStateOf(settings.showArabic) }
    var showHinglish by remember { mutableStateOf(settings.showHinglish) }
    var showUrdu by remember { mutableStateOf(settings.showUrdu) }
    var showHindi by remember { mutableStateOf(settings.showHindi) }
    var arabicSize by remember { mutableFloatStateOf(settings.arabicFontSizeSp) }
    var transSize by remember { mutableFloatStateOf(settings.translationFontSizeSp) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Language,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "قرآن سیٹنگز (Display Settings)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 12.dp))

                // Text toggles
                Text(
                    text = "زبانی متن منتخب کریں (Select Languages):",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Arabic toggle
                SettingSwitchRow(
                    label = "عربی متن (Arabic Script)",
                    sublabel = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",
                    checked = showArabic,
                    onCheckedChange = { showArabic = it }
                )

                // Hinglish toggle
                SettingSwitchRow(
                    label = "Hinglish / Roman Transliteration",
                    sublabel = "Bismil-laahir-Rahmaanir-Raheem",
                    checked = showHinglish,
                    onCheckedChange = { showHinglish = it }
                )

                // Urdu toggle
                SettingSwitchRow(
                    label = "اردو ترجمہ (Urdu Translation)",
                    sublabel = "شروع اللہ کا نام لے کر جو بڑا مہربان نہایت رحم والا ہے",
                    checked = showUrdu,
                    onCheckedChange = { showUrdu = it }
                )

                // Hindi toggle
                SettingSwitchRow(
                    label = "हिन्दी अनुवाद (Hindi Translation)",
                    sublabel = "अल्लाह के नाम से शुरू जो बड़ा मेहरबान और निहायत रहम करने वाला है।",
                    checked = showHindi,
                    onCheckedChange = { showHindi = it }
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Arabic font size slider
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "عربی فونٹ سائز (Arabic Font Size):",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "${arabicSize.toInt()} sp",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Slider(
                    value = arabicSize,
                    onValueChange = { arabicSize = it },
                    valueRange = 20f..38f,
                    steps = 8
                )

                // Translation font size slider
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ترجمہ فونٹ سائز (Translation Font Size):",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "${transSize.toInt()} sp",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Slider(
                    value = transSize,
                    onValueChange = { transSize = it },
                    valueRange = 13f..22f,
                    steps = 8
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("منسوخ (Cancel)")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onSave(
                                QuranDisplaySettings(
                                    showArabic = showArabic,
                                    showHinglish = showHinglish,
                                    showUrdu = showUrdu,
                                    showHindi = showHindi,
                                    arabicFontSizeSp = arabicSize,
                                    translationFontSizeSp = transSize
                                )
                            )
                            onDismiss()
                        }
                    ) {
                        Text("محفوظ کریں (Save)")
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingSwitchRow(
    label: String,
    sublabel: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = sublabel,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}
