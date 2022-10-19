package com.yo.silent_hours.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "profile_table")
data class Profile(@PrimaryKey(autoGenerate = true) val name: String)


//@Entity(tableName = "profile_table")
//data class Profile(
//    @PrimaryKey(autoGenerate = true) var profileId: Long = 0L,
//    var name: String
//    var shr: Int,
//    var smin: Int,
//    var ehr: Int,
//    var emin: Int,
//    var d: String,
    // To store profile color in the database
//    var colorIndex: Int,
//    var vibSwitch: Boolean,
    // Adding parameter for timestamp
//    var timeInstance: String,
//    var repeatWeekly: Boolean,
//    var pauseSwitch: Boolean,
//    var notes: String
//)
