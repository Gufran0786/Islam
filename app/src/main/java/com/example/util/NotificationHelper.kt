package com.example.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.MainActivity
import com.example.R

class NotificationHelper(private val context: Context) {

    companion object {
        const val CHANNEL_ID = "daily_writing_reminder"
        const val CHANNEL_NAME = "Daily Reflection & Writing Habit"
        const val NOTIFICATION_ID = 1001
    }

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Daily reminder to read Prophet biographies and write personal reflections"
            }
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    fun showDailyReminderNotification() {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val quotes = listOf(
            "Anbiya-e-Kiram ke sabr aur hikmat se aaj kuch naya seekhein.",
            "Aaj ka din kaisa raha? Apne tajurbaat aur ehsaasaat ko diary me darj karein.",
            "Rozana thodi der qisas padhna dil ko sukoon aur noor bakhshta hai.",
            "Apne khayalat aur shukr-guzari ko voice note ya tahreer me mehfooz karein."
        )
        val selectedQuote = quotes.random()

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_app_icon)
            .setContentTitle("Qisas Anbiya: Aaj Ki Nasihat & Reflection")
            .setContentText(selectedQuote)
            .setStyle(NotificationCompat.BigTextStyle().bigText(selectedQuote))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }
}
