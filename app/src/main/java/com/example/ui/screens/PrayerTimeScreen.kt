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
import com.example.util.NamazAlarmManager
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

    val alarmManager = remember { NamazAlarmManager(context) }
    val alarmSettings by alarmManager.settings.collectAsState()

    // State: Real-time vs Manual Clock Mode
    var isManualClockMode by remember { mutableStateOf(false) }
    var manualClockMillis by remember { mutableStateOf(System.currentTimeMillis()) }
    var isAzanAutoEnabled by remember { mutableStateOf(true) }

    // Live clock ticker
    var currentTimeMillis by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(isManualClockMode) {
        if (!isManualClockMode) {
            while (true) {
                currentTimeMillis = System.currentTimeMillis()
                delay(1000L)
            }
        }
    }

    val activeTimeMillis = if (isManualClockMode) manualClockMillis else currentTimeMillis
    val prayerSchedule = remember(activeTimeMillis, alarmSettings.isCustomPrayerTimesEnabled, alarmSettings.customTimes) {
        val customMap = if (alarmSettings.isCustomPrayerTimesEnabled) alarmSettings.customTimes else null
        NamazPrayerTimeHelper.calculatePrayerTimes(activeTimeMillis, customMap)
    }

    val isPlayingTakbeer by azanHelper.isPlaying.collectAsState()

    val timeFormat = remember { SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH) }
    val dateFormat = remember { SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.ENGLISH) }

    var editingPrayerId by remember { mutableStateOf<String?>(null) }
    var editingPrayerName by remember { mutableStateOf("") }

    // TimePicker for individual prayer time customization
    if (editingPrayerId != null) {
        val id = editingPrayerId!!
        val currentPair = alarmSettings.customTimes[id] ?: Pair(12, 0)
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                alarmManager.updateCustomPrayerTime(id, hourOfDay, minute)
                alarmManager.setCustomPrayerTimesEnabled(true)
                editingPrayerId = null
            },
            currentPair.first,
            currentPair.second,
            false
        ).show()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "اوقاتِ نماز و الارم (Prayer & Alarm)",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "मैन्युअल नमाज़ समय • तकबीर अलार्म • लाइव घड़ी",
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
            // Live / Manual Clock Card
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(20.dp),
                                color = if (isManualClockMode) palette.accent.copy(alpha = 0.2f) else Color(0xFF4CAF50).copy(alpha = 0.2f)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .clip(CircleShape)
                                            .background(if (isManualClockMode) palette.accent else Color(0xFF4CAF50))
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isManualClockMode) "دستی گھڑی (Manual Clock)" else "لائیو وقت (Real-time Live)",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isManualClockMode) palette.accent else Color(0xFF2E7D32)
                                    )
                                }
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "دستی گھڑی:",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.textSecondary
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Switch(
                                    checked = isManualClockMode,
                                    onCheckedChange = { checked ->
                                        isManualClockMode = checked
                                        if (checked) manualClockMillis = currentTimeMillis
                                    },
                                    modifier = Modifier.testTag("switch_manual_clock_mode")
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

                        // Manual Clock Adjust Buttons
                        AnimatedVisibility(visible = isManualClockMode) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                            ) {
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedButton(
                                        onClick = { manualClockMillis -= 900000L },
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("-15 منٹ", style = MaterialTheme.typography.labelSmall)
                                    }

                                    Button(
                                        onClick = {
                                            val c = Calendar.getInstance().apply { timeInMillis = manualClockMillis }
                                            TimePickerDialog(
                                                context,
                                                { _, hourOfDay, minute ->
                                                    val newC = Calendar.getInstance().apply {
                                                        timeInMillis = manualClockMillis
                                                        set(Calendar.HOUR_OF_DAY, hourOfDay)
                                                        set(Calendar.MINUTE, minute)
                                                    }
                                                    manualClockMillis = newC.timeInMillis
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
                                        Text("گھڑی چنیں", style = MaterialTheme.typography.labelSmall)
                                    }

                                    OutlinedButton(
                                        onClick = { manualClockMillis += 900000L },
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text("+15 منٹ", style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // USER FEATURE: "Namaz ka time hum khud set kar saken" Card
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(
                            if (alarmSettings.isCustomPrayerTimesEnabled) palette.accent else palette.border
                        )
                    ),
                    modifier = Modifier.fillMaxWidth().testTag("manual_prayer_times_card")
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
                                        .size(38.dp)
                                        .clip(CircleShape)
                                        .background(palette.accent.copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.EditCalendar,
                                        contentDescription = null,
                                        tint = palette.accent,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "نماز کا وقت خود سیٹ کریں (Custom Prayer Times)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = if (alarmSettings.isCustomPrayerTimesEnabled) "آپ کے طے کردہ دستی اوقات لاگو ہیں" else "شمسی حساب کتاب (Auto Calculated)",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = if (alarmSettings.isCustomPrayerTimesEnabled) palette.accent else palette.textSecondary
                                    )
                                }
                            }

                            Switch(
                                checked = alarmSettings.isCustomPrayerTimesEnabled,
                                onCheckedChange = { alarmManager.setCustomPrayerTimesEnabled(it) },
                                modifier = Modifier.testTag("switch_custom_prayer_times")
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "نیچے ہر نماز کے سامنے 'وقت بدلیں' پر کلک کر کے اپنی مرضی کا گھنٹہ اور منٹ چنیں۔",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }
                }
            }

            // USER FEATURE: "Namaz ka Alarm hum khud manually set kar saken" Card
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(palette.accent.copy(alpha = 0.5f))
                    ),
                    modifier = Modifier.fillMaxWidth().testTag("manual_namaz_alarm_card")
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
                                        .size(38.dp)
                                        .clip(CircleShape)
                                        .background(palette.accent.copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Alarm,
                                        contentDescription = null,
                                        tint = palette.accent,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "نماز کا الارم دستی سیٹ کریں (Manual Namaz Alarm)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "تہجد / نفل یا خاص نماز کے لیے الارم",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = palette.textSecondary
                                    )
                                }
                            }

                            Switch(
                                checked = alarmSettings.isManualCustomAlarmEnabled,
                                onCheckedChange = {
                                    alarmManager.updateManualCustomAlarm(
                                        enabled = it,
                                        hour = alarmSettings.manualCustomAlarmHour,
                                        minute = alarmSettings.manualCustomAlarmMinute,
                                        label = alarmSettings.manualCustomAlarmLabel
                                    )
                                },
                                modifier = Modifier.testTag("switch_manual_custom_alarm")
                            )
                        }

                        AnimatedVisibility(visible = alarmSettings.isManualCustomAlarmEnabled) {
                            Column(modifier = Modifier.fillMaxWidth().padding(top = 12.dp)) {
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column {
                                        Text(
                                            text = "الارم کا مقررہ وقت:",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = palette.textSecondary
                                        )
                                        val cal = Calendar.getInstance().apply {
                                            set(Calendar.HOUR_OF_DAY, alarmSettings.manualCustomAlarmHour)
                                            set(Calendar.MINUTE, alarmSettings.manualCustomAlarmMinute)
                                        }
                                        val customTimeStr = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(cal.time)
                                        Text(
                                            text = customTimeStr,
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = palette.accent
                                        )
                                    }

                                    Button(
                                        onClick = {
                                            TimePickerDialog(
                                                context,
                                                { _, hourOfDay, minute ->
                                                    alarmManager.updateManualCustomAlarm(
                                                        enabled = true,
                                                        hour = hourOfDay,
                                                        minute = minute,
                                                        label = alarmSettings.manualCustomAlarmLabel
                                                    )
                                                },
                                                alarmSettings.manualCustomAlarmHour,
                                                alarmSettings.manualCustomAlarmMinute,
                                                false
                                            ).show()
                                        },
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent)
                                    ) {
                                        Icon(Icons.Default.Schedule, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("الارم ٹائم بدلیں", style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Test Alarm Sound Button
                        OutlinedButton(
                            onClick = {
                                if (isPlayingTakbeer) {
                                    azanHelper.stopTakbeer()
                                } else {
                                    azanHelper.playDoubleTakbeer()
                                }
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth().testTag("btn_test_alarm_sound")
                        ) {
                            Icon(
                                imageVector = if (isPlayingTakbeer) Icons.Default.Stop else Icons.Default.VolumeUp,
                                contentDescription = null,
                                tint = if (isPlayingTakbeer) Color(0xFFD32F2F) else palette.accent
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isPlayingTakbeer) "الارم تکبیر روکیں (Stop Alarm)" else "الارم آواز چیک کریں (اللهُ أَكْبَرُ ، اللهُ أَكْبَرُ)",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isPlayingTakbeer) Color(0xFFD32F2F) else palette.accent
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
                    text = "اوقاتِ پنجگانہ نماز و الارم کنٹرول (Schedule & Alarms):",
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
                val isAlarmOn = alarmSettings.prayerAlarmsEnabled[entry.id] ?: false
                PrayerRowCard(
                    entry = entry,
                    isAlarmEnabled = isAlarmOn,
                    onToggleAlarm = { alarmManager.setPrayerAlarmEnabled(entry.id, !isAlarmOn) },
                    onEditTime = {
                        editingPrayerName = entry.nameUrdu
                        editingPrayerId = entry.id
                    },
                    onPlayTakbeer = { azanHelper.playDoubleTakbeer() }
                )
            }
        }
    }
}

@Composable
private fun PrayerRowCard(
    entry: NamazTimeEntry,
    isAlarmEnabled: Boolean,
    onToggleAlarm: () -> Unit,
    onEditTime: () -> Unit,
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

                Spacer(modifier = Modifier.height(6.dp))

                // Action Buttons for this specific prayer
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(
                        onClick = onEditTime,
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit Time", tint = palette.accent, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("وقت بدلیں (Set Time)", style = MaterialTheme.typography.labelSmall, color = palette.accent)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(
                        onClick = onToggleAlarm,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = if (isAlarmEnabled) Icons.Default.NotificationsActive else Icons.Default.NotificationsOff,
                            contentDescription = "Toggle Alarm",
                            tint = if (isAlarmEnabled) palette.accent else palette.textSecondary.copy(alpha = 0.5f),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
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
