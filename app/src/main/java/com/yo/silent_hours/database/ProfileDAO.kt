package com.yo.silent_hours.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yo.silent_hours.database.Profile

@Dao
interface ProfileDAO {

    @Query("SELECT * FROM profile_table")
    fun getAllProfile(): LiveData<List<Profile>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProfile(profiles: Profile)

    @Update
    suspend fun updateProfile( profiles: Profile)

    @Delete
    suspend fun deleteProfile( profiles: Profile)
}