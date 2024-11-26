package com.example.parquesguiado

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de los elementos de la interfaz
    private lateinit var imageView: ImageView
    private lateinit var nameEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var webSideEditText: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var locationSpinner: Spinner
    private lateinit var sportCheckBox: CheckBox
    private lateinit var childCheckBox: CheckBox
    private lateinit var barCheckBox: CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlace de los elementos de la interfaz
        imageView = findViewById(R.id.image)
        nameEditText = findViewById(R.id.name)
        descriptionEditText = findViewById(R.id.Description)
        phoneEditText = findViewById(R.id.phone)
        webSideEditText = findViewById(R.id.webSide)
        categorySpinner = findViewById(R.id.spinner)
        locationSpinner = findViewById(R.id.spinner2)
        sportCheckBox = findViewById(R.id.sport)
        childCheckBox = findViewById(R.id.child)
        barCheckBox = findViewById(R.id.bar)

        // Configuración de acción para el botón "Guardar"
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            saveData()
        }
    }

    // Función para guardar los datos ingresados
    private fun saveData() {
        try {
            // Obtén los datos de los campos de texto y otros elementos
            val name = nameEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val webSide = webSideEditText.text.toString()
            val opening = categorySpinner.selectedItem.toString()
            val closing = locationSpinner.selectedItem.toString()
            val isSportAvailable = sportCheckBox.isChecked
            val isChildFriendly = childCheckBox.isChecked
            val hasBar = barCheckBox.isChecked

            // Mostrar datos en Logcat
            Log.d(
                "MainActivity",
                "Datos guardados: Nombre=$name, Descripcion=$description, Telefono=$phone, " +
                        "Sitio Web=$webSide, apertura=$opening, cierre=$closing, " +
                        "Deportes=$isSportAvailable, parque infantil=$isChildFriendly, Bar=$hasBar"
            )

            // Mostrar un mensaje breve de éxito en el Toast
            Toast.makeText(this, "Parque guardado con éxito", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            e.printStackTrace()
            // Mostrar un mensaje breve de error en el Toast
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
        }
    }
}
