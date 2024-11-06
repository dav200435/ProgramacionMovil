package com.example.proyecto11

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class bienvenido : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val tvWelcome = findViewById<TextView>(R.id.texto)

        val message = intent.getStringExtra("WELCOME_MESSAGE")
        tvWelcome.text = message
    }
}
