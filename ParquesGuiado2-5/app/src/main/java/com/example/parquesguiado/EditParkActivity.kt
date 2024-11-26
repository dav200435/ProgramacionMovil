package com.example.parquesguiado

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.parquesguiado.databinding.ActivityEditParkBinding

class EditParkActivity : ActivityWithMenus() {

    // View Binding
    private lateinit var binding: ActivityEditParkBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditParkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configurar el boton con el listener para guardar datos
        binding.button.setOnClickListener {
            confirmSaveData()
        }
    }

    // funcion para confirmar los datos antes de guardarlos
    private fun confirmSaveData() {
        try {
            val name = binding.name.text.toString()
            val description = binding.Description.text.toString()
            val phone = binding.phone.text.toString()
            val webSide = binding.webSide.text.toString()
            val opening = binding.spinner.selectedItem.toString()
            val closing = binding.spinner2.selectedItem.toString()
            val isSportAvailable = binding.sport.isChecked
            val isChildFriendly = binding.child.isChecked
            val hasBar = binding.bar.isChecked
            val hasPetsArea = binding.pets.isChecked

            // texto del dialogo
            val message = """
                Nombre: $name
                Descripción: $description
                Teléfono: $phone
                Web: $webSide
                Hora de apertura: $opening
                Hora de cierre: $closing
                ${if (isSportAvailable) "- Con instalaciones deportivas" else ""}
                ${if (isChildFriendly) "- Con instalaciones para niños" else ""}
                ${if (hasBar) "- Con zona de restauración" else ""}
                ${if (hasPetsArea) "- Con zona para mascotas" else ""}
            """.trimIndent()

            // crear el dialogo de confirmacion
            AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    saveData(name, description, phone, webSide, opening, closing, isSportAvailable, isChildFriendly, hasBar, hasPetsArea)
                }
                .setNegativeButton(android.R.string.cancel){
                        _, _ ->
                    Toast.makeText(this, "Se ha cancelado el guardado con exito", Toast.LENGTH_SHORT).show()
                }
                .show()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    // guardar los datos ingresados en logcat y mostrar mensaje con toast
    private fun saveData(
        name: String, description: String, phone: String, webSide: String, opening: String, closing: String, isSportAvailable: Boolean, isChildFriendly: Boolean, hasBar: Boolean, hasPetsArea: Boolean) {
        try {
            Log.d(
                "MainActivity",
                "Datos guardados: Nombre=$name, Descripción=$description, Teléfono=$phone, " +
                        "Sitio Web=$webSide, Apertura=$opening, Cierre=$closing, " +
                        "Deportes=$isSportAvailable, Infantil=$isChildFriendly, Bar=$hasBar, Mascotas=$hasPetsArea"
            )

            Toast.makeText(this, "Parque guardado con éxito", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
        }
    }
}
