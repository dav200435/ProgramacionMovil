package com.example.proyecto5

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto5.databinding.ActivityMainBinding

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

        val tv1 = findViewById<TextView>(R.id.habitantes)
        val list1 = findViewById<ListView>(R.id.paises)

        val paises = arrayOf(
            "Argentina", "Bolivia", "Brasil", "Chile", "Colombia",
            "Ecuador", "Paraguay", "Perú", "Uruguay", "Venezuela"
        )
        val habitantes = arrayOf(
            45_376_763, 11_508_000, 213_993_437, 19_212_361, 50_372_424,
            17_373_662, 7_252_672, 33_035_304, 3_485_151, 28_704_954
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        list1.adapter = adapter

        list1.setOnItemClickListener { _, _, position, _ ->
            val paisSeleccionado = paises[position]
            val poblacion = habitantes[position]
            tv1.text = "Población de $paisSeleccionado: $poblacion"
        }
    }
}