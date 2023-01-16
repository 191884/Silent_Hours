package com.snappy.silenthours.notificationDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotiProfile::class], version = 2)
abstract class NotiProfileRoomDatabase : RoomDatabase() {

    abstract fun notiProfileDao(): NotiProfileDAO

    companion object {
        @Volatile
        private var INSTANCE: NotiProfileRoomDatabase? = null

        fun getDatabase(context: Context): NotiProfileRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotiProfileRoomDatabase::class.java,
                    "Noti_Profile_Database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}