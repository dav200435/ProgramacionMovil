package com.example.proyectofinalprimertrimestre

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

abstract class MenuActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun setContentView(layoutResID: Int) {
        // Carga el diseño del menú
        val fullLayout = layoutInflater.inflate(R.layout.navigation_menu, null)
        val contentLayout = fullLayout.findViewById<FrameLayout>(R.id.content_frame)

        // Infla el diseño específico de la actividad hija
        layoutInflater.inflate(layoutResID, contentLayout, true)
        super.setContentView(fullLayout)

        // Configura el DrawerLayout y NavigationView
        drawerLayout = fullLayout.findViewById(R.id.drawer_layout)
        navigationView = fullLayout.findViewById(R.id.navigationView)

        setupToolbar()
        setupDrawer()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupDrawer() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_add -> {
                    startActivity(Intent(this, AddProductActivity::class.java))
                }
                R.id.action_edit -> {
                    startActivity(Intent(this, EditProductActivity::class.java))
                }
                R.id.action_delete -> {
                    startActivity(Intent(this, DeleteProductActivity::class.java))
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                startActivity(Intent(this, AddProductActivity::class.java))
                return true
            }
            R.id.action_edit -> {
                startActivity(Intent(this, EditProductActivity::class.java))
                return true
            }
            R.id.action_delete -> {
                startActivity(Intent(this, DeleteProductActivity::class.java))
                return true
            }
            android.R.id.home -> {
                drawerLayout.openDrawer(navigationView)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
