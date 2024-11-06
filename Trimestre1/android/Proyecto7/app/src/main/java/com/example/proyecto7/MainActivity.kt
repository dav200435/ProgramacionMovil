package com.example.proyecto7

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto7.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflamos el layout utilizando el binding y establecemos la vista principal
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de la barra de navegación inferior
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Genera un número aleatorio entre 1 y 100000
        val randomNumber = Random.nextInt(1, 100001)

        // Muestra el número aleatorio mediante un Toast
        Toast.makeText(this, "Número a recordar: $randomNumber", Toast.LENGTH_LONG).show()

        // Referencias a los elementos de la interfaz
        val editTextNumber = findViewById<EditText>(R.id.num)
        val btnCheckNumber = findViewById<Button>(R.id.btn)

        // Configura el botón para verificar el número
        btnCheckNumber.setOnClickListener {
            // Obtén el número ingresado por el usuario
            val userInput = editTextNumber.text.toString()

            // Verifica si el usuario ingresó un número
            if (userInput.isNotEmpty()) {
                // Convierte la entrada del usuario a un número entero
                val userNumber = userInput.toInt()

                // Verifica si el número ingresado coincide con el número aleatorio
                if (userNumber == randomNumber) {
                    Toast.makeText(this, "¡Acertaste!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Número incorrecto, intenta de nuevo.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Muestra un mensaje si no se ingresó un número
                Toast.makeText(this, "Por favor ingresa un número.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
