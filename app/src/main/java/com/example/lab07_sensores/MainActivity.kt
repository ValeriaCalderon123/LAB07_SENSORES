package com.example.lab07_sensores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSensor1: Button = findViewById(R.id.btnSensor1)
        val btnSensor2: Button = findViewById(R.id.btnSensor2)

        btnSensor1.setOnClickListener {
            val intent = Intent(this, Sensor1::class.java)
            startActivity(intent)
        }

        btnSensor2.setOnClickListener {
            val intent = Intent(this, Sensor2::class.java)
            startActivity(intent)
        }

    }
}