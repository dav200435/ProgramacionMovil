package com.example.parquesguiado

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus : AppCompatActivity() {

    companion object {
        var actividadActual = 0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        updateMenuItems(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main -> navigateTo(MainActivity::class.java, 0)
            R.id.add_park -> navigateTo(EditParkActivity::class.java, 1)
            R.id.about -> navigateTo(about::class.java, 2)
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun updateMenuItems(menu: Menu) {
        // Disable the current activity's menu item
        for (i in 0 until menu.size()) {
            menu.getItem(i).isEnabled = i != actividadActual
        }
    }

    private fun navigateTo(targetActivity: Class<*>, currentActivityIndex: Int) {
        actividadActual = currentActivityIndex
        val intent = Intent(this, targetActivity)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}
