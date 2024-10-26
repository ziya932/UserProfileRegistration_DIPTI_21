package com.example.UserProfileRegistration_DIPTI_21.viewModel
import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.database.UserDatabase_21
import com.example.UserProfileRegistration_DIPTI_21.repository.UserProfileRepository_21
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel_21 (application: Application): AndroidViewModel(application){

    private val repository: UserProfileRepository_21


    init{
         val userProfileDao = UserDatabase_21.getDatabase(application)._userProfileDao()

        repository= UserProfileRepository_21(userProfileDao)
    }

    fun getUserProfiles(): LiveData<List<UserProfile_21>> {
        return repository.getUserProfiles()
    }
    fun insertUserProfile(userProfile21: UserProfile_21) {
       viewModelScope.launch (Dispatchers.IO){
           repository.insert(userProfile21)
       }

    }
    fun updateUserProfile(userProfile21: UserProfile_21) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(userProfile21)
        }
    }
    fun deleteUserProfile(userProfile21: UserProfile_21) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(userProfile21)
        }
    }

}