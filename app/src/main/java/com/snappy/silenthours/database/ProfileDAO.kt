package com.snappy.silenthours.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.snappy.silenthours.database.Profile

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