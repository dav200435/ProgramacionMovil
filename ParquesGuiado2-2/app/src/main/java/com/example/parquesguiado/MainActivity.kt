package com.example.parquesguiado

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parquesguiado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // crear var view Binding
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflar la vista con binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configurar el boton con el listener para guardar datos
        binding.button.setOnClickListener {
            saveData()
        }
    }

    // funcion para guardar los datos ingresados
    private fun saveData() {
        try {
            // Obtener datos de los elementos directamente desde binding
            val name = binding.name.text.toString()
            val description = binding.Description.text.toString()
            val phone = binding.phone.text.toString()
            val webSide = binding.webSide.text.toString()
            val opening = binding.spinner.selectedItem.toString()
            val closing = binding.spinner2.selectedItem.toString()
            val isSportAvailable = binding.sport.isChecked
            val isChildFriendly = binding.child.isChecked
            val hasBar = binding.bar.isChecked
            val isPet = binding.mascotas.isChecked

            // mostrar datos en logcat
            Log.d(
                "MainActivity",
                "Datos guardados: Nombre=$name, Descripcion=$description, Telefono=$phone, " +
                        "Sitio Web=$webSide, apertura=$opening, cierre=$closing, " +
                        "Deportes=$isSportAvailable, parque infantil=$isChildFriendly, Bar=$hasBar, mascotas?$isPet"
            )

            // mostrar un mensaje de exito en el Toast
            Toast.makeText(this, "Parque guardado con éxito", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            e.printStackTrace()
            // mostrar mensaje de error en Toast
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
        }
    }
}
