package com.example.proyectofinalprimertrimestre.modelview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.proyectofinalprimertrimestre.MenuActivity
import com.example.proyectofinalprimertrimestre.R
import java.io.File

class DeleteProductActivity : MenuActivity() {
    private val inventoryFile = "inventario.csv"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_product)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Eliminar Producto"

        val deleteProductNameField = findViewById<EditText>(R.id.deleteProductNameField)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        deleteButton.setOnClickListener {
            val productName = deleteProductNameField.text.toString()

            if (productName.isNotEmpty()) {
                val file = File(filesDir, inventoryFile)
                val lines = file.readLines().toMutableList()
                val updatedLines = lines.filterNot { it.startsWith(productName) }
                file.writeText(updatedLines.joinToString("\n"))
                Toast.makeText(this, "Producto eliminado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Ingresa un nombre de producto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
