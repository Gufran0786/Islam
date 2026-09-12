package com.example.ui.screens

import android.app.TimePickerDialog
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.LocalBookPalette
import com.example.util.AzanTakbeerHelper
import com.example.util.NamazPrayerTimeHelper
import com.example.util.NamazSchedule
import com.example.util.NamazTimeEntry
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrayerTimeScreen(
    azanHelper: AzanTakbeerHelper,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalBookPalette.current

    // State: Real-time vs Manual Time
    var isManualMode by remember { mutableStateOf(false) }
    var manualTimeMillis by remember { mutableStateOf(System.currentTimeMillis()) }
    var isAzanAutoEnabled by remember { mutableStateOf(true) }

    // Live clock ticker
    var currentTimeMillis by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(isManualMode) {
        if (!isManualMode) {
            while (true) {
                currentTimeMillis = System.currentTimeMillis()
                delay(1000L)
            }
        }
    }

    val activeTimeMillis = if (isManualMode) manualTimeMillis else currentTimeMillis
    val prayerSchedule = remember(activeTimeMillis) {
        NamazPrayerTimeHelper.calculatePrayerTimes(activeTimeMillis)
    }

    val isPlayingTakbeer by azanHelper.isPlaying.collectAsState()

    val timeFormat = remember { SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH) }
    val dateFormat = remember { SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.ENGLISH) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "اوقاتِ نماز و وقت (Prayer Times)",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "नमाज़ के औक़ात • अज़ान तकबीर • मैन्युअल व लाइव टाइम",
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
            // Live / Manual Time Card
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
                    shape = RoundedCornerShape(18.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.border)),
                    modifier = Modifier.fillMaxWidth().testTag("prayer_time_clock_card")
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Mode Switcher Header
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(20.dp),
                                color = if (isManualMode) palette.accent.copy(alpha = 0.2f) else Color(0xFF4CAF50).copy(alpha = 0.2f)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .clip(CircleShape)
                                            .background(if (isManualMode) palette.accent else Color(0xFF4CAF50))
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isManualMode) "دستی وقت (Manual Mode)" else "لائیو وقت (Real-time Live)",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isManualMode) palette.accent else Color(0xFF2E7D32)
                                    )
                                }
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "دستی موڈ:",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.textSecondary
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Switch(
                                    checked = isManualMode,
                                    onCheckedChange = { checked ->
                                        isManualMode = checked
                                        if (checked) manualTimeMillis = currentTimeMillis
                                    },
                                    modifier = Modifier.testTag("switch_manual_time_mode")
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Clock Display
                        Text(
                            text = timeFormat.format(Date(activeTimeMillis)),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontSize = 32.sp,
                                fontWeight = FontWeight.ExtraBold
                            ),
                            color = palette.accent
                        )

                        Text(
                            text = dateFormat.format(Date(activeTimeMillis)),
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )

                        // Manual Mode Controls
                        AnimatedVisibility(visible = isManualMode) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                            ) {
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "وقت تبدیل کریں (Adjust Time Manually):",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.accent
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedButton(
                                        onClick = { manualTimeMillis -= 3600000L }, // -1 hour
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("-1 گھنٹہ", style = MaterialTheme.typography.labelSmall)
                                    }

                                    OutlinedButton(
                                        onClick = { manualTimeMillis -= 900000L }, // -15 mins
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("-15 منٹ", style = MaterialTheme.typography.labelSmall)
                                    }

                                    Button(
                                        onClick = {
                                            val c = Calendar.getInstance().apply { timeInMillis = manualTimeMillis }
                                            TimePickerDialog(
                                                context,
                                                { _, hourOfDay, minute ->
                                                    val newC = Calendar.getInstance().apply {
                                                        timeInMillis = manualTimeMillis
                                                        set(Calendar.HOUR_OF_DAY, hourOfDay)
                                                        set(Calendar.MINUTE, minute)
                                                    }
                                                    manualTimeMillis = newC.timeInMillis
                                                },
                                                c.get(Calendar.HOUR_OF_DAY),
                                                c.get(Calendar.MINUTE),
                                                false
                                            ).show()
                                        },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                                    ) {
                                        Icon(Icons.Default.AccessTime, contentDescription = null, modifier = Modifier.size(14.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("وقت چنیں", style = MaterialTheme.typography.labelSmall)
                                    }

                                    OutlinedButton(
                                        onClick = { manualTimeMillis += 900000L }, // +15 mins
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("+15 منٹ", style = MaterialTheme.typography.labelSmall)
                                    }

                                    OutlinedButton(
                                        onClick = { manualTimeMillis += 3600000L }, // +1 hour
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("+1 گھنٹہ", style = MaterialTheme.typography.labelSmall)
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                TextButton(
                                    onClick = {
                                        manualTimeMillis = System.currentTimeMillis()
                                        isManualMode = false
                                    }
                                ) {
                                    Icon(Icons.Default.Refresh, contentDescription = null, tint = palette.accent, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("حقیقی وقت پر ری سیٹ کریں (Reset to Real-Time)", color = palette.accent, style = MaterialTheme.typography.labelSmall)
                                }
                            }
                        }
                    }
                }
            }

            // Azan Takbeer Bar (Double Allahu Akbar)
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.4f))),
                    modifier = Modifier.fillMaxWidth().testTag("azan_takbeer_card")
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(palette.accent.copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = null,
                                        tint = palette.accent,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "اذان تکبیر (اللهُ أَكْبَرُ ، اللهُ أَكْبَرُ)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "नमाज़ के वक़्त सिर्फ़ 2 बार अल्लाहु अकबर (Double Takbeer)",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = palette.textSecondary
                                    )
                                }
                            }

                            Switch(
                                checked = isAzanAutoEnabled,
                                onCheckedChange = { isAzanAutoEnabled = it },
                                modifier = Modifier.testTag("switch_azan_auto")
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Big Play Azan Button
                        Button(
                            onClick = {
                                if (isPlayingTakbeer) {
                                    azanHelper.stopTakbeer()
                                } else {
                                    azanHelper.playDoubleTakbeer()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isPlayingTakbeer) Color(0xFFD32F2F) else palette.accent
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().testTag("btn_play_double_takbeer")
                        ) {
                            Icon(
                                imageVector = if (isPlayingTakbeer) Icons.Default.Stop else Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isPlayingTakbeer) "اذان تکبیر روکیں (Stop)" else "اذان تکبیر سنیں (اللهُ أَكْبَرُ دو بار)",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Next Prayer Banner
            item {
                prayerSchedule.nextPrayer?.let { next ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = palette.accent.copy(alpha = 0.12f)),
                        shape = RoundedCornerShape(16.dp),
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.3f))),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "اگلی نماز (Next Prayer):",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.accent,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${next.nameRoman} (${next.nameUrdu}) • ${next.timeFormatted}",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.textPrimary
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = palette.accent
                            ) {
                                Text(
                                    text = prayerSchedule.remainingTimeString,
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }

            // 5 Daily Prayers List Header
            item {
                Text(
                    text = "اوقاتِ پنجگانہ نماز (Daily Prayer Schedule):",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent
                )
            }

            val prayerList = listOf(
                prayerSchedule.fajr,
                prayerSchedule.sunrise,
                prayerSchedule.dhuhr,
                prayerSchedule.asr,
                prayerSchedule.maghrib,
                prayerSchedule.isha
            )

            items(prayerList, key = { it.id }) { entry ->
                PrayerRowCard(
                    entry = entry,
                    onPlayTakbeer = { azanHelper.playDoubleTakbeer() }
                )
            }
        }
    }
}

@Composable
private fun PrayerRowCard(
    entry: NamazTimeEntry,
    onPlayTakbeer: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current

    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (entry.isNext) palette.accent.copy(alpha = 0.08f) else palette.cardBackground
        ),
        shape = RoundedCornerShape(14.dp),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(
                if (entry.isNext) palette.accent else palette.border
            )
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = entry.nameUrdu,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${entry.nameRoman} (${entry.nameHindi})",
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textSecondary
                    )

                    if (entry.isNext) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = palette.accent
                        ) {
                            Text(
                                text = "اگلی",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "رکعت: ${entry.rakats}",
                    style = MaterialTheme.typography.labelSmall,
                    color = palette.accent,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = entry.description,
                    style = MaterialTheme.typography.labelSmall,
                    color = palette.textSecondary
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = entry.timeFormatted,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (entry.isNext) palette.accent else palette.textPrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                IconButton(
                    onClick = onPlayTakbeer,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Azan Takbeer",
                        tint = palette.accent,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
