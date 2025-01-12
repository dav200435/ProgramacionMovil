package com.example.proyectofinal.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.model.InventoryItem
import com.example.proyectofinal.modelView.InventoryAdapter
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InventoryAdapter
    private lateinit var inventoryList: MutableList<InventoryItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAddItem)
        val editButton = findViewById<Button>(R.id.btnEditItem)
        val deleteButton = findViewById<Button>(R.id.btnDeleteItem)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        inventoryList = loadInventory()
        adapter = InventoryAdapter(inventoryList)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))
        }

        editButton.setOnClickListener {
            startActivity(Intent(this, EditItemActivity::class.java))
        }

        deleteButton.setOnClickListener {
            startActivity(Intent(this, DeleteItemActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        inventoryList.clear()
        inventoryList.addAll(loadInventory())
        adapter.notifyDataSetChanged()
    }

    private fun loadInventory(): MutableList<InventoryItem> {
        val file = File(filesDir, "inventario.csv")

        // Si el archivo no existe, crearlo y agregar datos iniciales
        if (!file.exists()) {
            file.writeText(
                """
            Producto1,19.99,10
            Producto2,9.99,5
            Producto3,29.99,2
            """.trimIndent()
            )
        }

        // Leer las líneas del archivo y convertirlas en objetos InventoryItem
        return file.readLines().mapNotNull { line ->
            val parts = line.split(",")
            try {
                if (parts.size == 3) InventoryItem(parts[0], parts[1].toDouble(), parts[2].toInt()) else null
            } catch (e: Exception) {
                null // Ignorar líneas mal formateadas
            }
        }.toMutableList()
    }


    private fun saveInventory() {
        val file = File(filesDir, "inventario.csv")
        file.writeText(
            inventoryList.joinToString("\n") {
                "${it.name},${it.price},${it.stock}"
            }
        )
    }
}
