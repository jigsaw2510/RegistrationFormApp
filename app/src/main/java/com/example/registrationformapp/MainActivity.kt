package com.example.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.button_register
import kotlinx.android.synthetic.main.activity_main.edit_text_email
import kotlinx.android.synthetic.main.activity_main.edit_text_first_name
import kotlinx.android.synthetic.main.activity_main.edit_text_last_name
import kotlinx.android.synthetic.main.activity_main.edit_text_password
import kotlinx.android.synthetic.main.activity_main.edit_text_phone_number
import kotlinx.android.synthetic.main.activity_main.spinner_title_select

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()
        setupButton()
        setupIntentInitiatePhoneCall()
    }

    private fun setupIntentInitiatePhoneCall() {
        val phoneNumber = edit_text_phone_number.text
        edit_text_phone_number.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${phoneNumber}")
            }
            startActivity(intent)
        }
    }

    private fun setupSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        spinner_title_select.adapter = titleAdapter
    }

    private fun createAccount() {
        val user = User(
            spinner_title_select.selectedItem as String,
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone_number.text.toString(),
            edit_text_password.text.toString()
        )
        /*val moveToSummaryActivity = Intent(this, SummaryActivity::class.java)
        startActivity(moveToSummaryActivity)*/
    }

    private fun setupButton() {
        button_register.setOnClickListener {
                createAccount()
            }
        }
}