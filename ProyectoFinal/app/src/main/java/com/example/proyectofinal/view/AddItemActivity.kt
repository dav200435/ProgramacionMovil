package com.example.proyectofinal.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import java.io.File

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val nameField = findViewById<EditText>(R.id.editItemName)
        val priceField = findViewById<EditText>(R.id.editItemPrice)
        val stockField = findViewById<EditText>(R.id.editItemStock)
        val saveButton = findViewById<Button>(R.id.btnSaveItem)

        saveButton.setOnClickListener {
            val name = nameField.text.toString()
            val price = priceField.text.toString().toDoubleOrNull()
            val stock = stockField.text.toString().toIntOrNull()

            if (name.isNotBlank() && price != null && stock != null) {
                val file = File(filesDir, "inventario.csv")
                file.appendText("$name,$price,$stock\n")
                finish()
            }
        }
    }
}