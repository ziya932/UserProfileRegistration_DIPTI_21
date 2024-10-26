package com.example.UserProfileRegistration_DIPTI_21.views

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.UserProfileRegistration_DIPTI_21.R
import com.example.UserProfileRegistration_DIPTI_21.Models.UserProfile_21

import com.example.UserProfileRegistration_DIPTI_21.viewModel.UserProfileViewModel_21
import java.util.Calendar

class AddProfileActivity : AppCompatActivity() {
    private  lateinit var   profileViewModel: UserProfileViewModel_21
    private  lateinit var  nameTxt:EditText
    private  lateinit var  emailTxt:EditText
    private  lateinit var  dobTxt:EditText
    private  lateinit var  districtTxt:EditText
    private  lateinit var  mobileTxt:EditText
    private  lateinit var  saveBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel_21::class.java)

         nameTxt = findViewById(R.id.profileNameEt)
         emailTxt = findViewById(R.id.emailEt)
         dobTxt = findViewById(R.id.dobEt)

        dobTxt.setOnClickListener{
                showDatePickerDialog()
            }
         districtTxt = findViewById(R.id.districtEt)
         mobileTxt = findViewById(R.id.mobileEt)

        saveBtn = findViewById(R.id.addBtn)
         saveBtn.setOnClickListener{

             val name = nameTxt.text.toString().trim()
             val email = emailTxt.text.toString().trim()
             val dob = dobTxt.text.toString().trim()
             val district = districtTxt.text.toString().trim()
             val mobile = mobileTxt.text.toString().trim()
              val userProfile21 = UserProfile_21(name = name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.insertUserProfile(userProfile21)
             finish()
         }

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            dobTxt.setText(date)
        }, year, month, day)

        datePickerDialog.show()

    }

}