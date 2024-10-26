package com.example.UserProfileRegistration_DIPTI_21.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21


@Dao

interface UserProfileDao_21 {

 @Insert
    suspend fun   insert(userProfile21: UserProfile_21)

    @Update
    suspend fun   update(userProfile21: UserProfile_21)

       @Delete
    suspend fun   delete(userProfile21: UserProfile_21)

        @Query("SELECT * FROM user_profile")
     fun   getAllProfiles(): LiveData<List<UserProfile_21>>

}