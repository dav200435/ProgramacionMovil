package com.example.proyectofinalprimertrimestre

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.io.File

class AddProductActivity : MenuActivity() {
    private val inventoryFile = "inventario.csv"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Agregar Producto"

        val nameField = findViewById<EditText>(R.id.nameField)
        val priceField = findViewById<EditText>(R.id.priceField)
        val stockField = findViewById<EditText>(R.id.stockField)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val name = nameField.text.toString()
            val price = priceField.text.toString().toDoubleOrNull()
            val stock = stockField.text.toString().toIntOrNull()

            if (name.isNotEmpty() && price != null && stock != null) {
                val file = File(filesDir, inventoryFile)
                file.appendText("$name,$price,$stock\n")
                Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
