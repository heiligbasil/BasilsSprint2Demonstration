package com.lambdaschool.basilssprint2challengedemonstration.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationMaker {

    fun notify(context: Context) {

//        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), PendingIntent.FLAG_ONE_SHOT)

        val channelId: String = "${context.packageName}.demo"
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: String = "Sprint 2 Demo Channel"
            val importance: Int = NotificationManager.IMPORTANCE_HIGH
            val description: String = "Know your notifications and its components!"

            val notificationChannel = NotificationChannel(channelId, name, importance)
            notificationChannel.description = description

            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Sprint 2 Demonstration")
            .setContentText("Is this starting to become clear?")
            /*.setContentIntent(pendingIntent)*/
            .setAutoCancel(true)
        notificationManager.notify(367, notificationBuilder.build())
    }
}