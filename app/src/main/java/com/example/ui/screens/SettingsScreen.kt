package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Language
import com.example.data.AppLanguage
import com.example.data.BookFont
import com.example.data.PaperStyle
import com.example.data.ReaderSettings
import com.example.ui.CloudSyncState
import com.example.util.AppLocaleManager
import com.example.ui.theme.AmoledBg
import com.example.ui.theme.CreamBg
import com.example.ui.theme.DarkBg
import com.example.ui.theme.ForestBg
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette
import com.example.ui.theme.ParchmentBg
import com.example.ui.theme.WhiteBg
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SettingsScreen(
    settings: ReaderSettings,
    cloudSyncState: CloudSyncState,
    onSelectLanguage: (AppLanguage) -> Unit = {},
    onOpenCalendar: () -> Unit = {},
    onSelectPaperStyle: (PaperStyle) -> Unit,
    onSelectBookFont: (BookFont) -> Unit,
    onFontSizeChange: (Float) -> Unit,
    onToggleDarkMode: (Boolean) -> Unit,
    onSetAppLock: (enabled: Boolean, pin: String) -> Unit,
    onTriggerCloudSync: () -> Unit,
    onExportJson: ((String) -> Unit) -> Unit,
    onImportJson: (String) -> Unit,
    onRestoreFactoryData: () -> Unit,
    onTestDailyReminder: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current
    val context = LocalContext.current

    var showPinDialog by remember { mutableStateOf(false) }
    var pinInput by remember { mutableStateOf(settings.lockPin) }
    var showExportDialog by remember { mutableStateOf(false) }
    var exportedJsonText by remember { mutableStateOf("") }
    var showImportDialog by remember { mutableStateOf(false) }
    var importJsonInput by remember { mutableStateOf("") }
    var showResetConfirm by remember { mutableStateOf(false) }

    val syncDateFormat = remember { SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 100.dp, top = 16.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Title Header
            item {
                Column {
                    Text(
                        text = "Kitab Ki Tanzeem & Settings",
                        style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                    Text(
                        text = "Paper texture, fonts, dark mode, cloud sync & security",
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textSecondary
                    )
                }
            }

            // SECTION 0A: WORLDWIDE LANGUAGES SELECTOR
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.accent.copy(alpha = 0.5f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Language,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "App Ki Language (विश्व भाषाएं / زبانیں)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "Poori app ki bhasha chunne ki suvidha",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = palette.textSecondary,
                                        fontSize = 11.sp
                                    )
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = palette.accent.copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, palette.accent)
                            ) {
                                Text(
                                    text = "${settings.appLanguage.flag} ${settings.appLanguage.nativeName}",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.accent,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Quran Exemption Notice
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF1B5E20).copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, Color(0xFF2E7D32).copy(alpha = 0.3f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "✨ نوٹ: منتخب کردہ زبان پوری ایپ پر لاگو ہوگی سوائے قرآن پاک کے، جہاں عربی، ہنگلش، اردو اور ہندی ترجمہ اپنی مستند حالت میں محفوظ رہیں گے۔",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF1B5E20),
                                fontSize = 11.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Worldwide Languages List / Grid
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            AppLanguage.values().toList().chunked(2).forEach { rowLangs ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    rowLangs.forEach { lang ->
                                        val isSelected = settings.appLanguage == lang
                                        Surface(
                                            shape = RoundedCornerShape(10.dp),
                                            color = if (isSelected) palette.accent.copy(alpha = 0.22f) else palette.border.copy(alpha = 0.35f),
                                            border = BorderStroke(
                                                width = if (isSelected) 1.5.dp else 0.5.dp,
                                                color = if (isSelected) palette.accent else palette.border
                                            ),
                                            modifier = Modifier
                                                .weight(1f)
                                                .clickable { onSelectLanguage(lang) }
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Text(text = lang.flag, fontSize = 16.sp)
                                                    Spacer(modifier = Modifier.width(6.dp))
                                                    Column {
                                                        Text(
                                                            text = lang.nativeName,
                                                            style = MaterialTheme.typography.labelMedium,
                                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                                            color = if (isSelected) palette.accent else palette.textPrimary,
                                                            maxLines = 1
                                                        )
                                                        Text(
                                                            text = lang.displayName,
                                                            style = MaterialTheme.typography.labelSmall,
                                                            color = palette.textSecondary,
                                                            fontSize = 10.sp,
                                                            maxLines = 1
                                                        )
                                                    }
                                                }

                                                if (isSelected) {
                                                    Icon(
                                                        imageVector = Icons.Default.Check,
                                                        contentDescription = "Selected",
                                                        tint = palette.accent,
                                                        modifier = Modifier.size(16.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                    if (rowLangs.size == 1) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // SECTION 0B: REAL-TIME TRI-CALENDAR & CLOCK
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CalendarMonth,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "سہ رخی تقویم و گھڑی (Tri-Calendar)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "Hijri, Hindi (Panchang) & Gregorian live clock",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = palette.textSecondary,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedButton(
                            onClick = onOpenCalendar,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = palette.accent
                            ),
                            border = BorderStroke(1.dp, palette.accent)
                        ) {
                            Icon(Icons.Default.CalendarMonth, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "مکمل کیلنڈر و حقیقی وقت کھولیں (Open Tri-Calendar)",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }

            // SECTION 1: BOOK APPEARANCE & PAPER TEXTURE
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Palette,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Kitab Ka Paper Texture & Font",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.textPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Paper Style (Safha):",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.textSecondary
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        val paperStyles = listOf(
                            Pair(PaperStyle.PARCHMENT, "Qadim (Parchment)"),
                            Pair(PaperStyle.CREAM, "Ivory Cream"),
                            Pair(PaperStyle.WHITE, "Crisp White"),
                            Pair(PaperStyle.FOREST, "Forest Green"),
                            Pair(PaperStyle.DARK, "Midnight"),
                            Pair(PaperStyle.AMOLED, "AMOLED Black")
                        )

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            paperStyles.take(3).forEach { (style, name) ->
                                val isSelected = settings.paperStyle == style
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isSelected) palette.accent else palette.border.copy(alpha = 0.35f),
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { onSelectPaperStyle(style) }
                                ) {
                                    Text(
                                        text = name,
                                        modifier = Modifier.padding(vertical = 8.dp),
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            paperStyles.drop(3).forEach { (style, name) ->
                                val isSelected = settings.paperStyle == style
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isSelected) palette.accent else palette.border.copy(alpha = 0.35f),
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { onSelectPaperStyle(style) }
                                ) {
                                    Text(
                                        text = name,
                                        modifier = Modifier.padding(vertical = 8.dp),
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Font switcher
                        Text(
                            text = "Rasm-ul-Khat (Book Font):",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.textSecondary
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            BookFont.entries.forEach { font ->
                                val isSelected = settings.bookFont == font
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isSelected) palette.accent else palette.border.copy(alpha = 0.35f),
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
                                        modifier = Modifier.padding(vertical = 8.dp),
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontFamily = when (font) {
                                                BookFont.SERIF -> FontFamily.Serif
                                                BookFont.SANS -> FontFamily.SansSerif
                                                BookFont.MONO -> FontFamily.Monospace
                                            }
                                        ),
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Font size slider
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Font Size: ${settings.fontSizeSp.toInt()} sp",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.textSecondary
                            )
                        }
                        Slider(
                            value = settings.fontSizeSp,
                            onValueChange = onFontSizeChange,
                            valueRange = 13f..24f,
                            steps = 11,
                            colors = SliderDefaults.colors(thumbColor = palette.accent, activeTrackColor = palette.accent)
                        )

                        Divider(modifier = Modifier.padding(vertical = 8.dp), color = palette.border)

                        // Dark Mode Toggle
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.DarkMode,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Raat Ka Andaaz (Dark Mode)",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = palette.textPrimary
                                )
                            }
                            Switch(
                                checked = settings.isDarkMode,
                                onCheckedChange = onToggleDarkMode,
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = palette.accent,
                                    checkedTrackColor = palette.accent.copy(alpha = 0.5f)
                                )
                            )
                        }
                    }
                }
            }

            // SECTION 2: SECURITY (PIN & BIOMETRIC LOCK)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Hifazat & Diary Lock (Security)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.textPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Apni zaati diary aur tajurbaat ko mehfooz rakhne ke liye 4-hanso ka PIN ya Biometric lock lagayein.",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "App Passcode Lock",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.textPrimary
                                )
                                Text(
                                    text = if (settings.isAppLockEnabled) "PIN: •••• (Active)" else "Lock Ghair Fa'al (Disabled)",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (settings.isAppLockEnabled) palette.accent else palette.textSecondary
                                )
                            }

                            Switch(
                                checked = settings.isAppLockEnabled,
                                onCheckedChange = { checked ->
                                    if (checked) {
                                        showPinDialog = true
                                    } else {
                                        onSetAppLock(false, "")
                                    }
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = palette.accent,
                                    checkedTrackColor = palette.accent.copy(alpha = 0.5f)
                                ),
                                modifier = Modifier.testTag("toggle_security_lock")
                            )
                        }

                        if (settings.isAppLockEnabled) {
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedButton(
                                onClick = { showPinDialog = true },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(imageVector = Icons.Default.Lock, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("PIN Change Karein", color = palette.textPrimary)
                            }
                        }
                    }
                }
            }

            // SECTION 3: CLOUD SYNC & DATA BACKUP / EXPORT
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CloudSync,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Cloud Sync & Data Backup",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.textPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = palette.border.copy(alpha = 0.35f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CloudDone,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = cloudSyncState.statusMessage,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "Aakhri Sync: ${syncDateFormat.format(Date(cloudSyncState.lastSyncTimeMillis))}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = palette.textSecondary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Cloud Sync Button
                        Button(
                            onClick = onTriggerCloudSync,
                            enabled = !cloudSyncState.isSyncing,
                            colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("cloud_sync_button")
                        ) {
                            if (cloudSyncState.isSyncing) {
                                CircularProgressIndicator(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(18.dp),
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Sync Ho Raha Hai...")
                            } else {
                                Icon(imageVector = Icons.Default.CloudSync, contentDescription = null)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Abhi Cloud Sync Karein")
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Custom Data Export / Import Row
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            OutlinedButton(
                                onClick = {
                                    onExportJson { json ->
                                        exportedJsonText = json
                                        showExportDialog = true
                                    }
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("export_data_btn")
                            ) {
                                Icon(imageVector = Icons.Default.FileDownload, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("JSON Export", fontSize = 12.sp, color = palette.textPrimary)
                            }

                            OutlinedButton(
                                onClick = { showImportDialog = true },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("import_data_btn")
                            ) {
                                Icon(imageVector = Icons.Default.FileUpload, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("JSON Import", fontSize = 12.sp, color = palette.textPrimary)
                            }
                        }
                    }
                }
            }

            // SECTION 4: DAILY HABIT NOTIFICATIONS
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.NotificationsActive,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Rozana Likhne Ki Aadat (Daily Reminders)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.textPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Daily notifications taaki aap Anbiya ke jivan se seekhein aur apni diary me likhne ki aadat ko barqarar rakhein.",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = onTestDailyReminder,
                            colors = ButtonDefaults.buttonColors(containerColor = palette.border),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("test_reminder_button")
                        ) {
                            Text("Test Reminder Notification Bhejein", color = palette.textPrimary, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }

            // SECTION 5: RESET TO FACTORY DATA
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.RestartAlt,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Asal Kitab Restore Karein",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.error
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Agar aapne manual badlaav kiye hain aur dubaara mukammal 25 Anbiya ki asal kitab chahte hain to reset karein.",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedButton(
                            onClick = { showResetConfirm = true },
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Default 25 Anbiya Restore Karein")
                        }
                    }
                }
            }
        }
    }

    // PIN Setup Dialog
    if (showPinDialog) {
        AlertDialog(
            onDismissRequest = { showPinDialog = false },
            title = { Text("4-Digit PIN Set Karein") },
            text = {
                Column {
                    Text("Naya 4-hanso ka lock PIN darj karein:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = pinInput,
                        onValueChange = { if (it.length <= 4 && it.all { char -> char.isDigit() }) pinInput = it },
                        label = { Text("PIN (e.g. 1234)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (pinInput.length == 4) {
                            onSetAppLock(true, pinInput)
                            showPinDialog = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = palette.accent)
                ) {
                    Text("Save PIN")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showPinDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Export Dialog
    if (showExportDialog) {
        AlertDialog(
            onDismissRequest = { showExportDialog = false },
            title = { Text("JSON Data Export") },
            text = {
                Column {
                    Text("Aapki kitab aur personal diary ka backup JSON format me tayyar hai:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = exportedJsonText,
                        onValueChange = {},
                        readOnly = true,
                        minLines = 6,
                        maxLines = 10,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        clipboard.setPrimaryClip(ClipData.newPlainText("Qisas Anbiya Backup", exportedJsonText))
                        showExportDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = palette.accent)
                ) {
                    Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Copy Backup")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showExportDialog = false }) {
                    Text("Close")
                }
            }
        )
    }

    // Import Dialog
    if (showImportDialog) {
        AlertDialog(
            onDismissRequest = { showImportDialog = false },
            title = { Text("JSON Data Restore / Import") },
            text = {
                Column {
                    Text("Apna backup JSON data neeche paste karein:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = importJsonInput,
                        onValueChange = { importJsonInput = it },
                        placeholder = { Text("Paste JSON here...") },
                        minLines = 6,
                        maxLines = 10,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (importJsonInput.isNotBlank()) {
                            onImportJson(importJsonInput)
                            showImportDialog = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = palette.accent)
                ) {
                    Text("Restore Karein")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showImportDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Reset Confirm Dialog
    if (showResetConfirm) {
        AlertDialog(
            onDismissRequest = { showResetConfirm = false },
            title = { Text("Kitab Reset Karein?") },
            text = { Text("Isse tamam 25 Anbiya aur unke waqiat default halat me dubaara restore ho jayenge.") },
            confirmButton = {
                Button(
                    onClick = {
                        onRestoreFactoryData()
                        showResetConfirm = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Haan, Restore Karein")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showResetConfirm = false }) {
                    Text("Nahi")
                }
            }
        )
    }
}
