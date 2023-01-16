package com.snappy.silenthours.notificationDb

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "notification_db")
data class NotiProfile(
    @PrimaryKey(autoGenerate = true) var profileId: Long = 0L,
    var name: String,
    var shr: Int,
    var smin: Int,
    var sday: Int,
    var smonth: Int,
    val syear: Int,
    // Adding parameter for timestamp
    var timeInstance: String,
    var pauseSwitch: Boolean,
    var notes: String
) : Parcelable
