package com.example.precticumimad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.buttonEnter).setOnClickListener {
            // Retrieve user input from EditText fields
            val etName = findViewById<EditText>(R.id.etName)
            val etStudentNumber = findViewById<EditText>(R.id.etStudentNumber)

            val name = etName.text.toString()
            val studentNumber = etStudentNumber.text.toString()

            // Start MainActivity and pass user input as extras
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("studentNumber", studentNumber)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.buttonExit).setOnClickListener {
            finish()
        }
    }
}
