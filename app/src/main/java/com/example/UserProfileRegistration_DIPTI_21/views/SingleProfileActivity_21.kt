package com.example.UserProfileRegistration_DIPTI_21.views

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.R
import com.example.UserProfileRegistration_DIPTI_21.viewModel.UserProfileViewModel_21


class SingleProfileActivity_21 : AppCompatActivity() {

    private  lateinit var  userProfile21: UserProfile_21
    private lateinit var  nameTxt: TextView
    private lateinit var  emailTxt: TextView
    private lateinit var  dobTxt: TextView
    private lateinit var  districtTxt: TextView
    private lateinit var  mobileTxt: TextView
    private  lateinit var updateBtn:ImageButton
    private  lateinit var deleteBtn:ImageButton

    private  lateinit var  profileViewHolder: UserProfileViewModel_21


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_profile)

        profileViewHolder = ViewModelProvider(this).get(UserProfileViewModel_21::class.java)
        userProfile21  = intent.getSerializableExtra("USER_PROFILE") as UserProfile_21


        nameTxt = findViewById(R.id.nameTxt)
        emailTxt = findViewById(R.id.emailTxt)
        dobTxt = findViewById(R.id.dobTxt)
        districtTxt = findViewById(R.id.districtTxt)
        mobileTxt = findViewById(R.id.mobileTxt)
        updateBtn= findViewById(R.id.editBtn)
        deleteBtn = findViewById(R.id.deleteBtn)

        updateBtn.setOnClickListener {
            val intent = android.content.Intent(this, UpdateProfileActivity_21::class.java)
            intent.putExtra("USER_PROFILE", userProfile21)
            startActivity(intent)
        }
        deleteBtn.setOnClickListener{

            profileViewHolder.deleteUserProfile(userProfile21)
            finish()
        }
       populateFields()
    }
    private fun populateFields() {
        nameTxt.text = userProfile21.name
        emailTxt.text = userProfile21.email
        dobTxt.text = userProfile21.dob
        districtTxt.text = userProfile21.district
        mobileTxt.text = userProfile21.mobile
    }
}
