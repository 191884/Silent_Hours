package com.yo.silent_hours.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository): ViewModel(){

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

}


class ProfileViewModelFactory(private val repository: ProfileRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
