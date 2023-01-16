package com.snappy.silenthours.workManager

import android.util.Log
import androidx.work.*
import com.snappy.silenthours.notificationDb.NotiProfile
import com.snappy.silenthours.utils.Utils.timeCheck
import java.util.*
import java.util.concurrent.TimeUnit

object NotiWorkManagerHelper {

    private val calender: Calendar by lazy {
        Calendar.getInstance()
    }

    fun setStartAlarm(
        workManager: WorkManager,
        notiProfile: NotiProfile,
        year: Int,
        monthOfYear: Int,
        day: Int,
        startHour: Int,
        startMinute: Int
    ) {
        calender.set(Calendar.YEAR, year)
        calender.set(Calendar.MONTH, monthOfYear)
        calender.set(Calendar.DAY_OF_MONTH, day)
        calender.set(Calendar.HOUR_OF_DAY, startHour)
        calender.set(Calendar.MINUTE, startMinute)
        calender.set(Calendar.SECOND, 0)
        calender.set(Calendar.MILLISECOND, 0)

        timeCheck(calender)
        val profileData = workDataOf(
            Pair("ActiveProfileId", notiProfile.profileId),
            Pair("Profile_Name", notiProfile.name),
            Pair("Profile_Text",notiProfile.notes)
        )
        setAlarmRequest<ShowNotification>(workManager, notiProfile, profileData, calender, ShowNotification::class.java)
    }


    private inline fun <reified T : ListenableWorker> setAlarmRequest(
        workManager: WorkManager,
        profile: NotiProfile,
        profileData: Data,
        c: Calendar,
        alarmClass: Class<out ListenableWorker>
    ) {
        val workRequest = OneTimeWorkRequestBuilder<T>()
            .addTag(profile.profileId.toString())
            .setInputData(profileData)
            .setInitialDelay(
                c.timeInMillis - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS
            )
            .build()
        Log.e("WorkManager", "Reached Request")
        Log.e("WorkManager Delay", (c.timeInMillis - System.currentTimeMillis()).toString())
        Log.e("Setted Time", c.timeInMillis.toString())
        Log.e("System Time", System.currentTimeMillis().toString())
        workManager.enqueue(workRequest)
    }

    fun cancelWork(workManager: WorkManager, tag: String) {
        workManager.cancelAllWorkByTag(tag)
        Log.e("WorkManager", "$tag Work Canceled")
    }
}