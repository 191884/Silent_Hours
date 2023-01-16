package com.snappy.silenthours.notificationDb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotiProfileDAO {

    @Query("SELECT * FROM notification_db")
    fun getAllProfile(): LiveData<List<NotiProfile>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProfile(notiProfiles: NotiProfile)

    @Update
    suspend fun updateProfile( notiProfiles: NotiProfile)

    @Delete
    suspend fun deleteProfile( notiProfiles: NotiProfile)
}