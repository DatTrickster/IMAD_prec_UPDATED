package com.example.precticumimad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

class HomeActivity : AppCompatActivity() {

    private lateinit var etDate: EditText
    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText
    private val screenTimeData = ArrayList<ScreenTimeEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        etDate = findViewById(R.id.etDate)
        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
        etNotes = findViewById(R.id.etNotes)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        buttonSave.setOnClickListener {
            saveData()
        }

        buttonClear.setOnClickListener {
            clearData()
        }

        buttonNext.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putParcelableArrayListExtra("data", screenTimeData)
            startActivity(intent)
        }
    }

    private fun saveData() {
        val date = etDate.text.toString()
        val morning = etMorning.text.toString()
        val afternoon = etAfternoon.text.toString()
        val notes = etNotes.text.toString()

        if (date.isEmpty() || morning.isEmpty() || afternoon.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val entry = ScreenTimeEntry(date, morning.toDouble(), afternoon.toDouble(), notes)
        screenTimeData.add(entry)
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    private fun clearData() {
        etDate.text.clear()
        etMorning.text.clear()
        etAfternoon.text.clear()
        etNotes.text.clear()
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}
