package com.example.primeraapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.primeraapp.ui.theme.PrimeraAppTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {

    // Estado para guardar la lista de eventos
    private var eventList by mutableStateOf(listOf<String>())

    // Definir una variable de nombre para usar en EventListDisplay (si se necesita en el futuro)
    private val name: String = "Android User"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeraAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventListDisplay(
                        modifier = Modifier.padding(innerPadding),
                        events = eventList // Pasar la lista de eventos
                    )
                }
            }
        }
    }

    // Sobrescribir onPause y registrar evento
    override fun onPause() {
        super.onPause()
        val currentTime = getCurrentTime()
        val newEvent = "App en pausa a las $currentTime"
        Log.d("MainActivity", newEvent)
        updateEventList(newEvent) // Actualizar la lista de eventos
    }

    // Sobrescribir onResume y registrar evento
    override fun onResume() {
        super.onResume()
        val currentTime = getCurrentTime()
        val newEvent = "App reanudada a las $currentTime"
        Log.d("MainActivity", newEvent)
        updateEventList(newEvent) // Actualizar la lista de eventos
    }

    // Función para obtener la hora actual en formato legible
    private fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return sdf.format(Date())
    }

    // Función para actualizar la lista de eventos
    private fun updateEventList(newEvent: String) {
        eventList = eventList + newEvent // Agregar el nuevo evento a la lista
    }
}

@Composable
fun EventListDisplay(modifier: Modifier = Modifier, events: List<String>) {
    // Mostrar solo la lista de eventos, sin el saludo
    LazyColumn(modifier = modifier) {
        // Mostrar cada evento en una nueva fila
        items(events) { event ->
            Text(text = event)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventListPreview() {
    PrimeraAppTheme {
        EventListDisplay(events = listOf("App reanudada a las 12:00:00", "App en pausa a las 12:05:00"))
    }
}
