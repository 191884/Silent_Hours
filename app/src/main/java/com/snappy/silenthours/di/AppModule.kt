package com.snappy.silenthours.di

import android.app.NotificationManager
import android.content.Context
import android.media.AudioManager
import androidx.work.WorkManager
import com.google.gson.Gson
import com.snappy.silenthours.database.ProfileDAO
import com.snappy.silenthours.database.ProfileRepository
import com.snappy.silenthours.database.ProfileRoomDatabase
import com.snappy.silenthours.notificationDb.NotiProfileDAO
import com.snappy.silenthours.notificationDb.NotiProfileRepository
import com.snappy.silenthours.notificationDb.NotiProfileRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesGson() = Gson()

    @Provides
    fun providesProfileDAO(@ApplicationContext context: Context) =
        ProfileRoomDatabase.getDatabase(context).profileDao()

    @Provides
    fun providesNotiProfileDAO(@ApplicationContext context: Context) =
        NotiProfileRoomDatabase.getDatabase(context).notiProfileDao()

    @Provides
    fun providesProfileRepository(profileDao: ProfileDAO) = ProfileRepository(profileDao)

    @Provides
    fun providesNotiProfileRepository(notiProfileDao: NotiProfileDAO) = NotiProfileRepository(notiProfileDao)


    @Provides
    fun providesAudioManager(@ApplicationContext context: Context): AudioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    @Provides
    fun providesNotificationManager(@ApplicationContext context: Context): NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @Provides
    fun providesWorkManager(@ApplicationContext context: Context): WorkManager =
        WorkManager.getInstance(context)
}