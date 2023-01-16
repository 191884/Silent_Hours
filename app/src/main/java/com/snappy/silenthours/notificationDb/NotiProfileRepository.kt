package com.snappy.silenthours.notificationDb

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.snappy.silenthours.notificationDb.NotiProfile
import com.snappy.silenthours.notificationDb.NotiProfileDAO

class NotiProfileRepository(private val notiProfileDAO: NotiProfileDAO) {

    val allProfiles: LiveData<List<NotiProfile>> = notiProfileDAO.getAllProfile()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(notiProfile: NotiProfile) {
        notiProfileDAO.insertProfile(notiProfile)
    }

    @WorkerThread
    suspend fun delete(notiProfile: NotiProfile) {
        notiProfileDAO.deleteProfile(notiProfile)
    }
    @WorkerThread
    suspend fun update(notiProfile: NotiProfile) {
        notiProfileDAO.updateProfile(notiProfile)
    }
}