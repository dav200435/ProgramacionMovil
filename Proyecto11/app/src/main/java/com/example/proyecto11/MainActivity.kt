package com.example.proyecto11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPassword = findViewById<EditText>(R.id.passwd)
        val btnIngresar = findViewById<Button>(R.id.btn)

        btnIngresar.setOnClickListener {
            val password = etPassword.text.toString()
            if (password == "abc123") {
                val intent = Intent(this, bienvenido::class.java)
                intent.putExtra("WELCOME_MESSAGE", "Bienvenido al segundo Activity!")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Clave incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
