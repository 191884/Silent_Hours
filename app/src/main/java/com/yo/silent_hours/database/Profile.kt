package com.yo.silent_hours.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
//@Entity(tableName = "profile_table")
//data class Profile(@PrimaryKey @ColumnInfo(name = "ProfileName") val name: String)
//data class Profile(@PrimaryKey(autoGenerate = true) val name: String)

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true) var profileId: Long = 0L,
    var name: String,
    var shr: Int,
    var smin: Int,
    var ehr: Int,
    var emin: Int,
    var vibSwitch: Boolean,
//    var d: String,
    // Adding parameter for timestamp
    var timeInstance: String,
    var repeatWeekly: Boolean,
    var pauseSwitch: Boolean,
//    var notes: String
)
