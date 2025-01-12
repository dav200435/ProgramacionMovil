package com.example.proyectofinal.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import java.io.File

class DeleteItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_item)

        val nameField = findViewById<EditText>(R.id.editItemName)
        val deleteButton = findViewById<Button>(R.id.btnDeleteItem)

        deleteButton.setOnClickListener {
            val name = nameField.text.toString()

            if (name.isNotBlank()) {
                val file = File(filesDir, "inventario.csv")
                val lines = file.readLines().toMutableList()
                val updatedLines = lines.filterNot {
                    val parts = it.split(",")
                    parts[0] == name
                }
                file.writeText(updatedLines.joinToString("\n"))
                finish()
            }
        }
    }
}