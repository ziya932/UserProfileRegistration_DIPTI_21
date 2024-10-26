package com.example.UserProfileRegistration_DIPTI_21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.UserProfileRegistration_DIPTI_21.views.ProfileListActivity_21

class MainActivity_21 : AppCompatActivity() {
    private lateinit var listButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        listButton = findViewById(R.id.showUserlistBtn)

        listButton.setOnClickListener {
            startActivity(Intent(this, ProfileListActivity_21::class.java))
            finish()
        }
    }
}