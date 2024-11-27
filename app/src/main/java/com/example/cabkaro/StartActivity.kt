package com.example.cabkaro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    private lateinit var btnContinue: Button
    private lateinit var phoneInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnContinue = findViewById(R.id.btn_continue)
        phoneInput = findViewById(R.id.phone_input)

        btnContinue.setOnClickListener {
            btnContinue.visibility = View.GONE
            phoneInput.visibility = View.VISIBLE

            phoneInput.setOnEditorActionListener { _, _, _ ->
                val phoneNumber = phoneInput.text.toString().trim()
                if (phoneNumber.isNotEmpty()) {
                    val intent = Intent(this@StartActivity, OtpVerificationActivity::class.java)
                    intent.putExtra("phone", phoneNumber)
                    startActivity(intent)
                }
                false
            }
        }
    }
}
