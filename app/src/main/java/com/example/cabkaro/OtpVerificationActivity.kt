package com.example.cabkaro

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OtpVerificationActivity : AppCompatActivity() {

    private lateinit var otpInstruction: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        otpInstruction = findViewById(R.id.otp_instruction)

        val phone = intent.getStringExtra("phone")
        otpInstruction.text = "Please wait.\nWe will auto verify OTP sent to $phone"
    }
}
