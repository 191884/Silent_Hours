package com.yo.silent_hours.ui.adapter

import com.yo.silent_hours.database.Profile

interface AdapterCallback {
    fun updateItem(profile: Profile)
    fun openProfileDetails(profile: Profile)
    fun setAlarms(profile: Profile, startHour: Int = profile.shr, startMinute: Int = profile.smin)
    fun cancelWorkByTag(tag: String)
}