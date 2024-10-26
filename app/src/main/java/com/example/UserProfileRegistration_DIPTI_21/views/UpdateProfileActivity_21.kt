package com.example.UserProfileRegistration_DIPTI_21.views

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21
import com.example.UserProfileRegistration_DIPTI_21.R
import com.example.UserProfileRegistration_DIPTI_21.viewModel.UserProfileViewModel_21

import java.util.Calendar

class UpdateProfileActivity_21 : AppCompatActivity() {
    private lateinit var userProfile21: UserProfile_21
    private lateinit var profileViewModel: UserProfileViewModel_21

    private lateinit var NameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var dobEt: EditText
    private lateinit var districtEt: EditText
    private lateinit var mobileEt: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_update_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel_21::class.java)
        userProfile21 = intent.getSerializableExtra("USER_PROFILE") as UserProfile_21

        NameEt = findViewById(R.id.NameEt)
        emailEt = findViewById(R.id.emailEt)
        dobEt = findViewById(R.id.dobEt)
        dobEt.setOnClickListener{
            showDatePickerDialog()
        }

        districtEt = findViewById(R.id.districtEt)
        mobileEt = findViewById(R.id.mobileEt)


        populateFields()

        findViewById<Button>(R.id.updateBtn).setOnClickListener {
            updateUserProfile()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            dobEt.setText(date)
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun populateFields() {
            NameEt.setText(userProfile21.name)
            emailEt.setText(userProfile21.email)
            dobEt.setText(userProfile21.dob)
            districtEt.setText(userProfile21.district)
            mobileEt.setText(userProfile21.mobile)
        }
        fun updateUserProfile() {

            val name = NameEt.text.toString().trim()
            val email = emailEt.text.toString().trim()
            val dob = dobEt.text.toString().trim()
            val district = districtEt.text.toString().trim()
            val mobile = mobileEt.text.toString().trim()

            val updateUserProfile21 = UserProfile_21(id= userProfile21.id,name = name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.updateUserProfile(updateUserProfile21)
            finish()
        }

    }

