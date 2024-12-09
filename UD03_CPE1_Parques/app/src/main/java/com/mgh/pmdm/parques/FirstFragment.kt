package com.mgh.pmdm.parques

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgh.pmdm.parques.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MiDialogFragment.OnOKOrCancelListener {

    // Propiedad privada para almacenar temporalmente un item
    // se utiliza cuando se va a eliminar un parque
    private var itemToRemove:Park?

    init{
        itemToRemove=null
    }

private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Poblamos la lista de parques, en lugar de this, utilizamos requireActivity(), tal y
        // como hacíamos con los fragmentos del diálogo
        Parks.populate(requireActivity(), R.raw.parks)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentFirstBinding.inflate(inflater, container, false)

        /* Aquí añadimos y adaptamos el código del proyecto anterior */


        // Preparación del RecyclerView:

        // 1. Asociamos el LayoutManager
        binding.ParksRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        //binding.ParksRecyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)

        // 2. Determinamos que tiene tamaño fijo (optimización)
        binding.ParksRecyclerView.setHasFixedSize(true)
        // 3. Asignamos el adaptador al RecyclerView, proporcionándole
        //    dos funciones lambda, que invocarán los callbacks definidos en esta clase,
        //    para gestionar el click y el click largo sobre un item del RecyclerView.
        binding.ParksRecyclerView.adapter = AdaptadorParques(
            { park: Park, v: View -> itemClicked(park, v) },
            { park: Park, v: View -> itemLongClicked(park, v) }
        )

        /* Fin del código importado */

      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /* Otros métodos*/

    private fun itemClicked(park: Park, v: View) {
        // Gestión del click sobre un elemento para editarlo
        // Creamos un objeto de tipo Bundle y lo adjuntamos a la navegación
        // hacia el fragmento.

        val bundle = bundleOf("park" to park)
        v.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

    }

    private fun itemLongClicked(park: Park, v: View): Boolean {
        // Con el click largo eliminamos el parque de la vista

        // Establecemos el elemento a eliminar
        itemToRemove=park

        // e Invocamos al diálogo para preguntar si deseamos eliminar el registro
        val miDialogo = MiDialogFragment(
            resources.getString(R.string.deletePark),
            resources.getString(R.string.askDeletePark)+park.name+"?",
        this)
        miDialogo.show(requireActivity().supportFragmentManager, "miDialogo")
        return true

    }

    // Métodos para implementar la interfaz MiDialogFragment.OnOKOrCancelListener
    override fun onPositiveClick() {
        // Si se pulsa en Aceptar en el diálogo
        // eliminamos el item.
        itemToRemove?.also {
            val index=Parks.remove(it)

            // Y actualizamos el adaptador del RecyclerView
            // En lugar de DataSetChanged, utilizamos el método notifyItemRemoved
            // indicando la posición eliminada. De este modo, se aplica una
            // animación en el borrado.

            binding.ParksRecyclerView.adapter?.notifyItemRemoved(index)
        }
    }

    override fun onCancelClick() {
        // Si pulsa cancelar mostramos un toast
        Toast.makeText(
            //applicationContext,
            requireActivity().applicationContext,
            resources.getString(R.string.actionCancelled), Toast.LENGTH_SHORT
        ).show()
    }



}