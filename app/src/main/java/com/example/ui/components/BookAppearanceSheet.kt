package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.BookFont
import com.example.data.PaperStyle
import com.example.data.ReaderSettings
import com.example.ui.theme.AmoledBg
import com.example.ui.theme.CreamBg
import com.example.ui.theme.DarkBg
import com.example.ui.theme.ForestBg
import com.example.ui.theme.LocalBookPalette
import com.example.ui.theme.ParchmentBg
import com.example.ui.theme.WhiteBg

@Composable
fun BookAppearanceSheet(
    settings: ReaderSettings,
    onSelectPaperStyle: (PaperStyle) -> Unit,
    onSelectBookFont: (BookFont) -> Unit,
    onFontSizeChange: (Float) -> Unit,
    onToggleDarkMode: (Boolean) -> Unit,
    onDismiss: () -> Unit
) {
    val palette = LocalBookPalette.current

    val paperStylesWithPreview = listOf(
        Triple(PaperStyle.PARCHMENT, "Qadim Kagaz", ParchmentBg),
        Triple(PaperStyle.CREAM, "Ivory Cream", CreamBg),
        Triple(PaperStyle.WHITE, "Crisp White", WhiteBg),
        Triple(PaperStyle.FOREST, "Forest Green", ForestBg),
        Triple(PaperStyle.DARK, "Midnight", DarkBg),
        Triple(PaperStyle.AMOLED, "AMOLED Black", AmoledBg)
    )

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .testTag("book_appearance_dialog"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = palette.surface),
            border = BorderStroke(1.dp, palette.border)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Title
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = palette.accent
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Kitab Ka Andaaz & Paper Style",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = palette.textSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // 1. Paper Texture / Background Style
                Text(
                    text = "Paper Texture & Style (Safha):",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.textPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    paperStylesWithPreview.take(3).forEach { (style, name, color) ->
                        PaperChip(
                            name = name,
                            bgColor = color,
                            isSelected = settings.paperStyle == style,
                            palette = palette,
                            onClick = { onSelectPaperStyle(style) },
                            modifier = Modifier.weight(1f).padding(horizontal = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    paperStylesWithPreview.drop(3).forEach { (style, name, color) ->
                        PaperChip(
                            name = name,
                            bgColor = color,
                            isSelected = settings.paperStyle == style,
                            palette = palette,
                            onClick = { onSelectPaperStyle(style) },
                            modifier = Modifier.weight(1f).padding(horizontal = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 2. Font Style
                Text(
                    text = "Font Ka Style (Rasm-ul-Khat):",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.textPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    BookFont.entries.forEach { font ->
                        val isSelected = settings.bookFont == font
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) palette.accent else palette.border.copy(alpha = 0.35f),
                            border = BorderStroke(1.dp, if (isSelected) palette.accent else palette.border),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onSelectBookFont(font) }
                        ) {
                            Text(
                                text = when (font) {
                                    BookFont.SERIF -> "Serif (Kitab)"
                                    BookFont.SANS -> "Sans-Serif"
                                    BookFont.MONO -> "Monospace"
                                },
                                modifier = Modifier.padding(vertical = 10.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontFamily = when (font) {
                                        BookFont.SERIF -> FontFamily.Serif
                                        BookFont.SANS -> FontFamily.SansSerif
                                        BookFont.MONO -> FontFamily.Monospace
                                    }
                                ),
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 3. Font Size Slider
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.FormatSize,
                            contentDescription = null,
                            tint = palette.textSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Huroof Ka Size (Font Size):",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.textPrimary
                        )
                    }
                    Text(
                        text = "${settings.fontSizeSp.toInt()} sp",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent
                    )
                }

                Slider(
                    value = settings.fontSizeSp,
                    onValueChange = onFontSizeChange,
                    valueRange = 13f..24f,
                    steps = 11,
                    colors = SliderDefaults.colors(
                        thumbColor = palette.accent,
                        activeTrackColor = palette.accent
                    ),
                    modifier = Modifier.testTag("font_size_slider")
                )

                Spacer(modifier = Modifier.height(10.dp))

                // 4. Dark Mode Option (Requested)
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = palette.border.copy(alpha = 0.25f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (settings.isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Raat Ka Andaaz (Dark Mode)",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.textPrimary
                                )
                                Text(
                                    text = "Aankhon ki hifazat aur late-night mutala",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.textSecondary
                                )
                            }
                        }

                        Switch(
                            checked = settings.isDarkMode,
                            onCheckedChange = onToggleDarkMode,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = palette.accent,
                                checkedTrackColor = palette.accent.copy(alpha = 0.5f)
                            ),
                            modifier = Modifier.testTag("dark_mode_switch")
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PaperChip(
    name: String,
    bgColor: Color,
    isSelected: Boolean,
    palette: com.example.ui.theme.BookPalette,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = bgColor,
        border = BorderStroke(
            if (isSelected) 2.dp else 1.dp,
            if (isSelected) palette.accent else palette.border
        ),
        modifier = modifier
            .height(44.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier.padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (bgColor == AmoledBg || bgColor == DarkBg || bgColor == ForestBg) Color.White else Color.Black,
                maxLines = 1
            )
        }
    }
}
