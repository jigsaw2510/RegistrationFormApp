package com.example.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPhoneNumber: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButton()


        editTextPhoneNumber = findViewById<EditText>(R.id.edit_text_phone_number)
        val phoneNumber = editTextPhoneNumber.text

        editTextPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${phoneNumber}")
            }
            startActivity(intent)
        }
    }

    private fun setupButton() {
        registerButton = findViewById(R.id.button_register)
        registerButton.setOnClickListener {
            val moveToSummaryActivity = Intent(this, SummaryActivity::class.java)
            startActivity(moveToSummaryActivity)
            }

        }
}