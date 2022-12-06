package com.snappy.silenthours.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.snappy.silenthours.database.Profile
import com.snappy.silenthours.database.ProfileDAO

class ProfileRepository(private val profileDAO: ProfileDAO) {

    val allProfiles: LiveData<List<Profile>> = profileDAO.getAllProfile()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(profile: Profile) {
        profileDAO.insertProfile(profile)
    }

    @WorkerThread
    suspend fun delete(profile: Profile) {
        profileDAO.deleteProfile(profile)
    }
    @WorkerThread
    suspend fun update(profile: Profile) {
        profileDAO.updateProfile(profile)
    }
}