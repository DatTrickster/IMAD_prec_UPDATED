package com.example.precticumimad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the intent that started this activity
        val intent = intent
        val name = intent.getStringExtra("name")
        val studentNumber = intent.getStringExtra("studentNumber")

        // Display the name and student number in a TextView
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Name: $name\nStudent Number: $studentNumber"

        val buttonGoToHome = findViewById<Button>(R.id.buttonGoToHome)
        buttonGoToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


    }

}
