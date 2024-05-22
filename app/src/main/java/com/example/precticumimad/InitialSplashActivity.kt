package com.example.precticumimad

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class InitialSplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_splash)

        // Delay for 3 seconds before navigating to the next screen
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SplashActivity::class.java))
            finish()
        }, 2000) // 3000 milliseconds delay
    }
}
