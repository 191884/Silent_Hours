package com.yo.silent_hours.workManager

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.yo.silent_hours.ui.MainFragment
import com.yo.silent_hours.utils.Utils
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class EndAlarm @AssistedInject constructor(@Assisted appContext: Context, @Assisted workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    private val audioManager: AudioManager by lazy { appContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager }

    override fun doWork(): Result {
        val profileName = inputData.getString("Profile_Name")
//        if (StoreSession.readInt(AppConstants.BEGIN_STATUS) > 0)
//            StoreSession.writeInt(
//                AppConstants.BEGIN_STATUS,
//                StoreSession.readInt(AppConstants.BEGIN_STATUS) - 1
//            )
        audioManager.ringerMode =AudioManager.RINGER_MODE_NORMAL
        Log.wtf("EndAlarm"," Reaching Done")

//            if (StoreSession.readInt(AppConstants.BEGIN_STATUS) > 0) {
//                if (StoreSession.readInt(AppConstants.VIBRATE_STATE_ICON) == 1)
//                    AudioManager.RINGER_MODE_VIBRATE
//                else
//                    AudioManager.RINGER_MODE_SILENT
//            } else AudioManager.RINGER_MODE_NORMAL
        val intent = Intent(applicationContext, MainFragment::class.java)
        val pi = PendingIntent.getActivity(
            applicationContext,
            333,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        Utils.sendNotification(applicationContext, profileName!!, "ended", pi)

        return Result.success()
    }
}
