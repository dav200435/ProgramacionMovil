package com.example.proyectofinalprimertrimestre

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.io.File

class MainActivity : MenuActivity() {

    private val inventoryFile = "inventario.csv"
    private lateinit var listView: ListView
    private lateinit var refreshButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el ListView y el botón de refresco
        listView = findViewById(R.id.inventoryListView)
        refreshButton = findViewById(R.id.refreshButton)

        // Asegurarse de que el archivo exista y mostrar el inventario
        ensureInventoryFileExists()

        // Mostrar el inventario inicialmente
        displayInventory()

        // Configurar el botón para refrescar la lista
        refreshButton.setOnClickListener {
            displayInventory() // Refrescar la lista
        }
    }

    private fun ensureInventoryFileExists() {
        val file = File(filesDir, inventoryFile)
        if (!file.exists()) {
            file.writeText("nombreProducto,precio,stock\nManzanas,2.50,50\nPlátanos,1.20,80")
            Log.i("MainActivity", "Archivo creado en: ${file.absolutePath}")
        }
    }

    private fun displayInventory() {
        val productList = readInventoryFromCSV()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productList)
        listView.adapter = adapter
    }

    private fun readInventoryFromCSV(): List<String> {
        val productList = mutableListOf<String>()
        val file = File(filesDir, inventoryFile)

        if (file.exists()) {
            file.readLines().forEach { line ->
                if (line.isNotBlank()) {
                    val parts = line.split(",")
                    if (parts.size == 3) {
                        val productName = parts[0].trim()
                        val productPrice = parts[1].trim()
                        val productStock = parts[2].trim()
                        productList.add("Nombre: $productName, Precio: $productPrice, Stock: $productStock")
                    }
                }
            }
        } else {
            Log.e("MainActivity", "Archivo no encontrado.")
        }

        return productList
    }
}
