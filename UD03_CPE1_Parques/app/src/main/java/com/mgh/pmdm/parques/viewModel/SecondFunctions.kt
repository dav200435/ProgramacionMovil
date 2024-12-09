package com.mgh.pmdm.parques.viewModel

import SecondFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mgh.pmdm.parques.R
import com.mgh.pmdm.parques.databinding.FragmentSecondBinding
import com.mgh.pmdm.parques.model.Park
import com.mgh.pmdm.parques.repository.Parks
import com.mgh.pmdm.parques.view.dialogs.MiDialogFragment

class SecondFunctions : Fragment(), MiDialogFragment.OnOKOrCancelListener{
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var currentPark: Park? = null
    private lateinit var parkView: SecondFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        parkView = SecondFragment(binding)

        setupUI()
        loadPark()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupUI() {
        populateSpinner()

        binding.btSave.setOnClickListener {
            showSaveDialog()
        }
    }

    private fun loadPark() {
        val park: Park? = arguments?.getSerializable("park") as Park?
        currentPark = park

        if (park != null) {
            parkView.bindData(park)
        } else {
            binding.Image.setImageResource(R.drawable.appimg)
        }
    }

    private fun populateSpinner() {
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.horas,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            binding.SpinnerClosingTime.adapter = adapter
        }
    }

    private fun showSaveDialog() {
        val dialog = MiDialogFragment(
            resources.getString(R.string.SaveData),
            resources.getString(R.string.AskSaveData),
            this
        )
        dialog.show(requireActivity().supportFragmentManager, "miDialogo")
    }

    override fun onPositiveClick() {
        val newPark = Park(
            binding.Name.text.toString(),
            binding.Description.text.toString(),
            binding.Phone.text.toString(),
            binding.webSite.text.toString(),
            binding.SpinnerOpeningTime.selectedItem.toString(),
            binding.SpinnerClosingTime.selectedItem.toString(),
            binding.cbSport.isChecked,
            binding.cbChildren.isChecked,
            binding.cbBar.isChecked,
            binding.cbMascotas.isChecked
        )

        if (currentPark != null) {
            Parks.replace(currentPark!!, newPark)
        } else {
            Parks.add(newPark)
        }

        currentPark = newPark.copy()

        Snackbar.make(binding.root, resources.getString(R.string.dataSaved), Snackbar.LENGTH_LONG).show()
    }

    override fun onCancelClick() {
        Toast.makeText(
            requireContext(),
            resources.getString(R.string.actionCancelled), Toast.LENGTH_SHORT
        ).show()
    }
}