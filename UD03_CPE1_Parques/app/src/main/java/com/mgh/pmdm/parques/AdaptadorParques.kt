package com.mgh.pmdm.parques

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// El adaptador recibirá en su constructor los objetos de escucha de eventos
// para el click y el click largo
class AdaptadorParques(
    val eventListenerClick: (Park, View) -> Unit,
    val eventListenerLongClick: (Park, View) -> Boolean
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Método invocado por el RecyclerView cuando necesita un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // Modificaciones para el PP5
        // val vista=inflater.inflate(R.layout.parque_card, parent,false);
        val vista=inflater.inflate(R.layout.parque_card, parent,false);
        return parkViewHolder(vista)

    }

    // Método invocado por el RecyclerView para enlazar un ViewHolder con un parque
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Debemos proporcionarle el parque, y los eventos de click y click largo que recibimos
        (holder as parkViewHolder).bind(Parks.parks[position], eventListenerClick, eventListenerLongClick);
    }

    // Devuelve el número de elementos del Dataset
    override fun getItemCount(): Int {
        return Parks.parks.size;
    }
}