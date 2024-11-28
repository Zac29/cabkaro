package com.example.cabkaro

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OtpVerificationActivity : AppCompatActivity() {

    private lateinit var otpInstruction: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        otpInstruction = findViewById(R.id.otp_instruction)

        // Retrieve phone number from intent
        val phone = intent.getStringExtra("phone")
        if (phone != null) {
            otpInstruction.text = "Please wait.\nWe will auto-verify the OTP sent to $phone"
        } else {
            Toast.makeText(this, "Phone number not found", Toast.LENGTH_SHORT).show()
        }
    }
}
