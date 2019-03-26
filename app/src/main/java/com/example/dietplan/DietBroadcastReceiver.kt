package com.example.dietplan

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class DietBroadcastReceiver : BroadcastReceiver() {

    companion object {
        private const val CHANNEL_ID = "1"
    }

    lateinit var notificationManager: NotificationManager

    override fun onReceive(context: Context?, intent: Intent?) {

        val foodName = intent?.getStringExtra("foodName")

        notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel()
        }

        val builder = NotificationCompat.Builder(context,
            CHANNEL_ID
        )
        builder
            .setAutoCancel(true)
            .setContentTitle("Meal Reminder")
            .setContentText(foodName)
            .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setChannelId(CHANNEL_ID)
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(Notification.PRIORITY_HIGH)

        notificationManager.notify(21, builder.build())

    }


    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        if (notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
            val notificationChannel =
                NotificationChannel(CHANNEL_ID, "Meal Reminder", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}
