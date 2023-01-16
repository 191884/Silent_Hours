package com.snappy.silenthours.workManager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.snappy.silenthours.ui.MainFragment
import com.snappy.silenthours.utils.Utils
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ShowNotification @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    private val notificationManager: NotificationManager by lazy { appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }

    override fun doWork(): Result {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(
                    "422",
                    "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val profileName = "Reminding You For: ${inputData.getString("Profile_Name")}"
        val profileText = inputData.getString("Profile_Text")

        val intent = Intent(applicationContext, MainFragment::class.java)
        val pi = PendingIntent.getActivity(
            applicationContext,
            333,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        Utils.sendReminder(applicationContext, profileName, profileText.toString(), pi)
        Log.e("ShowNotification", "Reached Request")


        return Result.success()
    }
}