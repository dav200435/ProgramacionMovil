package com.example.parquesguiado

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Inflate menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        updateMenuItems(menu)
        return true
    }

    // Handle menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return handleMenuNavigation(item)
    }

    private fun updateMenuItems(menu: Menu) {
        // Disable the current activity's menu item
        for (i in 0 until menu.size()) {
            menu.getItem(i).isEnabled = i != ActivityWithMenus.actividadActual
        }
    }

    private fun handleMenuNavigation(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main -> navigateTo(MainActivity::class.java, 0)
            R.id.add_park -> navigateTo(EditParkActivity::class.java, 1)
            R.id.about -> navigateTo(about::class.java, 2)
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun navigateTo(targetActivity: Class<*>, currentActivityIndex: Int) {
        ActivityWithMenus.actividadActual = currentActivityIndex
        val intent = Intent(this, targetActivity)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}
