package com.example.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar

data class NamazCustomSettings(
    val isCustomPrayerTimesEnabled: Boolean = false,
    val customTimes: Map<String, Pair<Int, Int>> = defaultCustomTimes(),
    val prayerAlarmsEnabled: Map<String, Boolean> = defaultPrayerAlarms(),
    val isManualCustomAlarmEnabled: Boolean = false,
    val manualCustomAlarmHour: Int = 5,
    val manualCustomAlarmMinute: Int = 0,
    val manualCustomAlarmLabel: String = "Namaz Tahajjud / Fajr"
) {
    companion object {
        fun defaultCustomTimes(): Map<String, Pair<Int, Int>> = mapOf(
            "fajr" to Pair(5, 15),
            "sunrise" to Pair(6, 20),
            "dhuhr" to Pair(13, 15),
            "asr" to Pair(16, 45),
            "maghrib" to Pair(18, 30),
            "isha" to Pair(20, 15)
        )

        fun defaultPrayerAlarms(): Map<String, Boolean> = mapOf(
            "fajr" to true,
            "sunrise" to false,
            "dhuhr" to true,
            "asr" to true,
            "maghrib" to true,
            "isha" to true
        )
    }
}

class NamazAlarmManager(private val context: Context) {

    private val prefs = context.getSharedPreferences("namaz_alarm_prefs", Context.MODE_PRIVATE)

    private val _settings = MutableStateFlow(loadSettings())
    val settings: StateFlow<NamazCustomSettings> = _settings.asStateFlow()

    private fun loadSettings(): NamazCustomSettings {
        val isCustomTimes = prefs.getBoolean("is_custom_times_enabled", false)
        val defaultTimes = NamazCustomSettings.defaultCustomTimes()
        val customTimes = defaultTimes.keys.associateWith { key ->
            val h = prefs.getInt("time_${key}_h", defaultTimes[key]?.first ?: 12)
            val m = prefs.getInt("time_${key}_m", defaultTimes[key]?.second ?: 0)
            Pair(h, m)
        }

        val defaultAlarms = NamazCustomSettings.defaultPrayerAlarms()
        val prayerAlarms = defaultAlarms.keys.associateWith { key ->
            prefs.getBoolean("alarm_${key}", defaultAlarms[key] ?: false)
        }

        val manualAlarmEnabled = prefs.getBoolean("manual_alarm_enabled", false)
        val manualHour = prefs.getInt("manual_alarm_h", 5)
        val manualMinute = prefs.getInt("manual_alarm_m", 0)
        val manualLabel = prefs.getString("manual_alarm_label", "Namaz Tahajjud / Fajr") ?: "Namaz Alarm"

        return NamazCustomSettings(
            isCustomPrayerTimesEnabled = isCustomTimes,
            customTimes = customTimes,
            prayerAlarmsEnabled = prayerAlarms,
            isManualCustomAlarmEnabled = manualAlarmEnabled,
            manualCustomAlarmHour = manualHour,
            manualCustomAlarmMinute = manualMinute,
            manualCustomAlarmLabel = manualLabel
        )
    }

    fun setCustomPrayerTimesEnabled(enabled: Boolean) {
        prefs.edit().putBoolean("is_custom_times_enabled", enabled).apply()
        _settings.value = _settings.value.copy(isCustomPrayerTimesEnabled = enabled)
    }

    fun updateCustomPrayerTime(prayerId: String, hour: Int, minute: Int) {
        prefs.edit()
            .putInt("time_${prayerId}_h", hour)
            .putInt("time_${prayerId}_m", minute)
            .apply()
        val updated = _settings.value.customTimes.toMutableMap()
        updated[prayerId] = Pair(hour, minute)
        _settings.value = _settings.value.copy(customTimes = updated)

        if (_settings.value.prayerAlarmsEnabled[prayerId] == true) {
            schedulePrayerAlarm(prayerId, hour, minute)
        }
    }

    fun setPrayerAlarmEnabled(prayerId: String, enabled: Boolean) {
        prefs.edit().putBoolean("alarm_${prayerId}", enabled).apply()
        val updated = _settings.value.prayerAlarmsEnabled.toMutableMap()
        updated[prayerId] = enabled
        _settings.value = _settings.value.copy(prayerAlarmsEnabled = updated)

        val time = _settings.value.customTimes[prayerId] ?: Pair(12, 0)
        if (enabled) {
            schedulePrayerAlarm(prayerId, time.first, time.second)
        } else {
            cancelPrayerAlarm(prayerId)
        }
    }

    fun updateManualCustomAlarm(enabled: Boolean, hour: Int, minute: Int, label: String) {
        prefs.edit()
            .putBoolean("manual_alarm_enabled", enabled)
            .putInt("manual_alarm_h", hour)
            .putInt("manual_alarm_m", minute)
            .putString("manual_alarm_label", label)
            .apply()

        _settings.value = _settings.value.copy(
            isManualCustomAlarmEnabled = enabled,
            manualCustomAlarmHour = hour,
            manualCustomAlarmMinute = minute,
            manualCustomAlarmLabel = label
        )

        if (enabled) {
            scheduleManualAlarm(hour, minute, label)
        } else {
            cancelManualAlarm()
        }
    }

    private fun schedulePrayerAlarm(prayerId: String, hour: Int, minute: Int) {
        try {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, NamazAlarmReceiver::class.java).apply {
                putExtra("PRAYER_NAME", prayerId.replaceFirstChar { it.uppercase() })
            }
            val requestCode = prayerId.hashCode()
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val calendar = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
                if (before(Calendar.getInstance())) {
                    add(Calendar.DAY_OF_YEAR, 1)
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun cancelPrayerAlarm(prayerId: String) {
        try {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, NamazAlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                prayerId.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            alarmManager.cancel(pendingIntent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun scheduleManualAlarm(hour: Int, minute: Int, label: String) {
        try {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, NamazAlarmReceiver::class.java).apply {
                putExtra("PRAYER_NAME", label)
            }
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                99999,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val calendar = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
                if (before(Calendar.getInstance())) {
                    add(Calendar.DAY_OF_YEAR, 1)
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun cancelManualAlarm() {
        try {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, NamazAlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                99999,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            alarmManager.cancel(pendingIntent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
