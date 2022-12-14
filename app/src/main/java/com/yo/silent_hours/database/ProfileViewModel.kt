package com.yo.silent_hours.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.yo.silent_hours.workManager.WorkManagerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository,
    private val workManager: WorkManager
    ): ViewModel(){

    val allProfiles: LiveData<List<Profile>> = repository.allProfiles

    fun insert(profile: Profile) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(profile)
    }

    fun delete(profile: Profile) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(profile)
    }

    fun update(profile: Profile) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(profile)
    }

    fun setAlarms(profile: Profile, startHour: Int = profile.shr, startMinute: Int = profile.smin) {
        WorkManagerHelper.setAlarms(workManager, profile, startHour, startMinute)
    }

    fun cancelAllWorkByTag(tag: String) {
        WorkManagerHelper.cancelWork(workManager, tag)
    }
}
