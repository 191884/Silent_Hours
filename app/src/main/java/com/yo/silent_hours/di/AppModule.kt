package com.yo.silent_hours.di

import android.app.NotificationManager
import android.content.Context
import android.media.AudioManager
import androidx.work.WorkManager
import com.google.gson.Gson
import com.yo.silent_hours.database.ProfileDAO
import com.yo.silent_hours.database.ProfileRepository
import com.yo.silent_hours.database.ProfileRoomDatabase
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
    fun providesProfileRepository(profileDao: ProfileDAO) = ProfileRepository(profileDao)

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