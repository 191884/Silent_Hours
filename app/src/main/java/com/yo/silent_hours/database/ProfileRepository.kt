package com.yo.silent_hours.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileDAO

class ProfileRepository(private val profileDAO: ProfileDAO) {

    val allProfiles: LiveData<List<Profile>> = profileDAO.getAllProfile()

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