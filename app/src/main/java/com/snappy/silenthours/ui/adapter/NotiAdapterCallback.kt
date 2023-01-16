package com.snappy.silenthours.ui.adapter

import com.snappy.silenthours.notificationDb.NotiProfile

interface NotiAdapterCallback {
    fun updateItem(profile: NotiProfile)
    fun openProfileDetails(notiProfile: NotiProfile)
    fun setAlarms(notiProfile: NotiProfile, startHour: Int = notiProfile.shr, startMinute: Int = notiProfile.smin)
    fun cancelWorkByTag(tag: String)
}