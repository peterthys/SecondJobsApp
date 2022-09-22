package com.example.secondjobapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.secondjobapp.R
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mSharedViewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mSharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        view.et_updateClientName.setText(args.currentClient.name)
        view.et_updateClientAdress.setText(args.currentClient.adress)
        view.et_updateClientPhone.setText(args.currentClient.phoneNumber)

        btn_updateClient.setOnClickListener {
            updateAClient()
        }
        return view
    }

    private fun updateAClient() {
        val clientsName = et_updateClientName.text.toString()
        val clientsAdress = et_updateClientAdress.text.toString()
        val clientsPhone = et_updateClientPhone.text.toString()
        val updatedClient = Client(clientsName, clientsAdress, clientsPhone)
        mSharedViewModel.updateClient(updatedClient)
        Toast.makeText(requireContext(), "Updated !", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_clientsFragment)



    }
}