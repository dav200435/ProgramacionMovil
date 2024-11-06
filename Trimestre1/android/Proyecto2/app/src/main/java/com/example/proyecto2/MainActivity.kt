package com.example.proyecto2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto2.databinding.ActivityMainBinding

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

        val num1=findViewById<EditText>(R.id.num1)
        val num2=findViewById<EditText>(R.id.num2)
        val result=findViewById<TextView>(R.id.resultado)
        val button=findViewById<Button>(R.id.button)
        val radioG = findViewById<RadioGroup>(R.id.operacion)
        val op = radioG.checkedRadioButtonId
        button.setOnClickListener {
            val selectedOp = radioG.checkedRadioButtonId
            if (selectedOp == R.id.r1){
                val et1=findViewById<EditText>(R.id.num1)
                val nro1 = num1.text.toString().toInt()
                val nro2 = num2.text.toString().toInt()
                val suma = nro1 + nro2
                result.text = "Resultado: ${suma.toString()}"
            } else {
                val et1=findViewById<EditText>(R.id.num1)
                val nro1 = num1.text.toString().toInt()
                val nro2 = num2.text.toString().toInt()
                val suma = nro1 - nro2
                result.text = "Resultado: ${suma.toString()}"
            }

        }


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}