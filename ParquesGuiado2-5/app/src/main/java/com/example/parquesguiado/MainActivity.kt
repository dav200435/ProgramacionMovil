package com.example.parquesguiado

import MyAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajustar los márgenes según las barras del sistema
        setupWindowInsets()

        // Datos de prueba para el RecyclerView
        val names = arrayOf(
            "Parc de Capçalera. Valencia",
            "Parque del Retiro. Madrid",
            "Parc Güell. Barcelona"
        )
        val descriptions = arrayOf(
            "Zona verde en el antiguo cauce de Túria, con senderos para caminar o ir en bicicleta.",
            "Jardín histórico y parque público.",
            "Parque público con jardines y elementos arquitectónicos únicos."
        )

        // Configurar el RecyclerView con el adaptador
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = MyAdapter(names, descriptions)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        updateMenuItems(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main -> navigateTo(MainActivity::class.java, 0)
            R.id.add_park -> navigateTo(EditParkActivity::class.java, 1)
            R.id.about -> navigateTo(about::class.java, 2)
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBarsInsets.left,
                systemBarsInsets.top,
                systemBarsInsets.right,
                systemBarsInsets.bottom
            )
            insets
        }
    }

    private fun updateMenuItems(menu: Menu) {
        // Desactiva el elemento del menú que corresponde a la actividad actual
        for (index in 0 until menu.size()) {
            menu.getItem(index).isEnabled = index != ActivityWithMenus.actividadActual
        }
    }

    private fun navigateTo(targetActivity: Class<*>, currentActivityIndex: Int): Boolean {
        if (ActivityWithMenus.actividadActual != currentActivityIndex) {
            ActivityWithMenus.actividadActual = currentActivityIndex
            val intent = Intent(this, targetActivity).apply {
                addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            }
            startActivity(intent)
        }
        return true
    }
}