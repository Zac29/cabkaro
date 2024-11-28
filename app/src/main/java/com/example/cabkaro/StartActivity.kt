package com.example.cabkaro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    private lateinit var btnContinue: Button
    private lateinit var phoneInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // Initialize views
        btnContinue = findViewById(R.id.btn_continue)
        phoneInput = findViewById(R.id.phone_input)

        // Initially hide the phone input field
        phoneInput.visibility = View.GONE

        // Button click handling
        btnContinue.setOnClickListener {
            if (phoneInput.visibility == View.GONE) {
                // Show phone input field and update button text to "Send OTP"
                phoneInput.visibility = View.VISIBLE
                btnContinue.text = "Send OTP"
            } else {
                // Validate phone number and proceed
                val phoneNumber = phoneInput.text.toString().trim()
                if (phoneNumber.isEmpty() || !phoneNumber.matches(Regex("^[0-9]{10}$"))) {
                    Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
                } else {
                    // Move to OTP Verification Activity
                    val intent = Intent(this, OtpVerificationActivity::class.java)
                    intent.putExtra("phone", phoneNumber)
                    startActivity(intent)
                }
            }
        }
    }
}
