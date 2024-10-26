package com.example.UserProfileRegistration_DIPTI_21.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.dao.UserProfileDao_21
import kotlin.concurrent.Volatile


@Database(entities = [UserProfile_21::class], version = 1)
 abstract class UserDatabase_21 : RoomDatabase(){
     abstract  fun _userProfileDao(): UserProfileDao_21

     companion object{
         @Volatile
         private var INSTANCE:UserDatabase_21?=null
            fun getDatabase(context: Context):UserDatabase_21{

                return  INSTANCE?: synchronized(this){
                    val instance=Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase_21::class.java,
                        "user_profile_database"

                    ).build()
                   INSTANCE =instance
                    instance
                }
            }
     }


}