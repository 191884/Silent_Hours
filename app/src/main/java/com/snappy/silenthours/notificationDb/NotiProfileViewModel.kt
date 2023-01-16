package com.snappy.silenthours.notificationDb

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.snappy.silenthours.workManager.NotiWorkManagerHelper
import com.snappy.silenthours.workManager.WorkManagerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotiProfileViewModel @Inject constructor(
    private val repository: NotiProfileRepository,
    private val workManager: WorkManager
    ): ViewModel(){

    val allProfiles: LiveData<List<NotiProfile>> = repository.allProfiles

    fun insert(notiProfile: NotiProfile) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notiProfile)
    }

    fun delete(notiProfile: NotiProfile) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notiProfile)
    }

    fun update(notiProfile: NotiProfile) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(notiProfile)
    }

    fun setAlarms(
        notiProfile: NotiProfile,
        startYear:Int = notiProfile.syear,
        startMonth: Int = notiProfile.smonth,
        startDay: Int = notiProfile.sday,
        startHour: Int = notiProfile.shr,
        startMinute: Int = notiProfile.smin
    ) {
        NotiWorkManagerHelper.setStartAlarm(workManager, notiProfile, startYear, startMonth, startDay, startHour, startMinute)
    }
//
    fun cancelAllWorkByTag(tag: String) {
        NotiWorkManagerHelper.cancelWork(workManager, tag)
    }
}
