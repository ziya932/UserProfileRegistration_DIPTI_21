package com.example.UserProfileRegistration_DIPTI_21.repository

import androidx.lifecycle.LiveData
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.dao.UserProfileDao_21

class UserProfileRepository_21(private val userProfileDao21: UserProfileDao_21)  {

        fun  getUserProfiles():LiveData<List<UserProfile_21>> {

            return userProfileDao21.getAllProfiles()
        }
      suspend fun  insert(userProfile21: UserProfile_21){
        return userProfileDao21.insert(userProfile21)

      }
    suspend fun  update(userProfile21: UserProfile_21){
       return  userProfileDao21.update(userProfile21)

    }

    suspend fun  delete(userProfile21: UserProfile_21){
        return  userProfileDao21.delete(userProfile21)

    }


}