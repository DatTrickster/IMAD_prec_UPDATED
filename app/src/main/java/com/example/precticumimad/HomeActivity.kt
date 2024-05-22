package com.example.precticumimad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

// Main activity class for handling user input and navigation
class HomeActivity : AppCompatActivity() {

    // Declare EditText fields for user inputs
    private lateinit var etDate: EditText
    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText

    // ArrayList to store screen time entries
    private val screenTimeData = ArrayList<ScreenTimeEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge layout for a more immersive experience
        setContentView(R.layout.activity_home)

        // Initialize EditText fields by finding their IDs
        etDate = findViewById(R.id.etDate)
        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
        etNotes = findViewById(R.id.etNotes)

        // Initialize buttons by finding their IDs
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        // Set onClickListener for Save button to save user input
        buttonSave.setOnClickListener {
            saveData() // Call saveData method when Save button is clicked
        }

        // Set onClickListener for Clear button to clear input fields
        buttonClear.setOnClickListener {
            clearData() // Call clearData method when Clear button is clicked
        }

        // Set onClickListener for Next button to navigate to DetailedViewActivity
        buttonNext.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            // Pass the screen time data to DetailedViewActivity
            intent.putParcelableArrayListExtra("data", screenTimeData)
            startActivity(intent) // Start the DetailedViewActivity
        }
    }

    // Method to save user input data
    private fun saveData() {
        // Get text from EditText fields
        val date = etDate.text.toString()
        val morning = etMorning.text.toString()
        val afternoon = etAfternoon.text.toString()
        val notes = etNotes.text.toString()

        // Check if any field is empty
        if (date.isEmpty() || morning.isEmpty() || afternoon.isEmpty()) {
            // Show a Toast message if any field is empty
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Try to parse the screen time inputs to Double
        try {
            val morningDouble = morning.toDouble()
            val afternoonDouble = afternoon.toDouble()

            // Check if the parsed values are negative
            if (morningDouble < 0 || afternoonDouble < 0) {
                // Show a Toast message if any screen time is negative
                Toast.makeText(this, "Screen time cannot be negative", Toast.LENGTH_SHORT).show()
                return
            }

            // Create a new ScreenTimeEntry object
            val entry = ScreenTimeEntry(date, morningDouble, afternoonDouble, notes)
            // Add the entry to the screenTimeData list
            screenTimeData.add(entry)
            // Show a Toast message indicating the data is saved
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        } catch (e: NumberFormatException) {
            // Show a Toast message if parsing fails (invalid number format)
            Toast.makeText(this, "Please enter valid numbers for screen time", Toast.LENGTH_SHORT).show()
        }
    }

    // Method to clear input fields
    private fun clearData() {
        // Clear text in all EditText fields
        etDate.text.clear()
        etMorning.text.clear()
        etAfternoon.text.clear()
        etNotes.text.clear()
        // Show a Toast message indicating the data is cleared
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}
