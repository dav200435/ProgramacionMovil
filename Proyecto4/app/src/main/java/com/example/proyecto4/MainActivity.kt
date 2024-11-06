package com.example.proyecto4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val numero1 = findViewById<EditText>(R.id.num1)
        val numero2 = findViewById<EditText>(R.id.num2)
        val spinnerOperaciones = findViewById<Spinner>(R.id.spinner)
        val btnCalcular = findViewById<Button>(R.id.button)
        val textResultado = findViewById<TextView>(R.id.resultado)

        // Configuración de las opciones del Spinner
        val opciones = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperaciones.adapter = adapter

        // Configuración del botón de cálculo
        btnCalcular.setOnClickListener {
            val num1 = numero1.text.toString().toDoubleOrNull()
            val num2 = numero2.text.toString().toDoubleOrNull()
            val operacion = spinnerOperaciones.selectedItem.toString()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Por favor, ingrese ambos números", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultado = when (operacion) {
                "Sumar" -> num1 + num2
                "Restar" -> num1 - num2
                "Multiplicar" -> num1 * num2
                "Dividir" -> if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else -> 0.0
            }

            textResultado.text = "Resultado: $resultado"
        }
    }
}