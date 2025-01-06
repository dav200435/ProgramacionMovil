package com.example.proyectofinalprimertrimestre

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.io.File

class EditProductActivity : MenuActivity() {
    private val inventoryFile = "inventario.csv"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Editar Producto"

        val productNameField = findViewById<EditText>(R.id.productNameField)
        val newPriceField = findViewById<EditText>(R.id.newPriceField)
        val newStockField = findViewById<EditText>(R.id.newStockField)
        val editButton = findViewById<Button>(R.id.editButton)

        editButton.setOnClickListener {
            val productName = productNameField.text.toString()
            val newPrice = newPriceField.text.toString().toDoubleOrNull()
            val newStock = newStockField.text.toString().toIntOrNull()

            if (productName.isNotEmpty() && newPrice != null && newStock != null) {
                val file = File(filesDir, inventoryFile)
                val lines = file.readLines().toMutableList()
                val updatedLines = lines.map {
                    if (it.startsWith(productName)) "$productName,$newPrice,$newStock" else it
                }
                file.writeText(updatedLines.joinToString("\n"))
                Toast.makeText(this, "Producto editado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Completa los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
