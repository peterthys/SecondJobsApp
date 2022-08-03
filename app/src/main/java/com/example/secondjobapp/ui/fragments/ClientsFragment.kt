package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondjobapp.ClientsAdaptor
import com.example.secondjobapp.R
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clients.*
import kotlinx.android.synthetic.main.fragment_new_client.*


@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients) {

    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val clientList = mutableListOf(
        Client("Peter", "Putte", "032"),
        Client("Wouter", "Heultje", "025")
    )


     val adapter = ClientsAdaptor(clientList)
      rv_clients.adapter = adapter
       rv_clients.layoutManager = LinearLayoutManager(this)

       bt_make_new_client.setOnClickListener(){
           navHostFragment.findNavController().navigate(R.id.action_clientsFragment_to_newClient)
           val name = et_newClientName.text.toString()
            val adress = et_newClientAdress.text.toString()
          val phoneNumber : String = et_newClientPhone.text.toString()
          val newClient = Client(name,adress,phoneNumber)
           clientList.add(newClient)
          adapter.notifyItemInserted(clientList.size-1)}
}}