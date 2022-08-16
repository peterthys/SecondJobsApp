package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.secondjobapp.ClientsAdaptor
import com.example.secondjobapp.R
import com.example.secondjobapp.databinding.FragmentNewClientBinding
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.viewModels.MainViewModel
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_new_client.*

@AndroidEntryPoint
class NewClient : Fragment(R.layout.fragment_new_client) {
    private var _binding : FragmentNewClientBinding? = null
    private val binding get () = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val clientsList = mutableListOf<Client>()
        val adapter = ClientsAdaptor(clientsList)



//        btn_addNewClientToList.setOnClickListener {
//            @Override
//            fun onClick(view: View) {
//
//
//                val name = et_newClientName.text.toString()
//                val adress = et_newClientAdress.text.toString()
//                val phoneNumber: String = et_newClientPhone.text.toString()
//                val newClient = Client(name, adress, phoneNumber)
//                clientsList.add(newClient)
//                adapter.notifyItemInserted(clientsList.size - 1)
//                navHostFragment.findNavController()
//                    .navigate(R.id.action_newClient_to_clientsFragment)
//            }
//
//
//        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return super.onCreateView(
//            inflater,
//            container,
//            savedInstanceState
//        )

        _binding = FragmentNewClientBinding.inflate(inflater, container, false)


        sharedViewModel.country.observe(viewLifecycleOwner, { country ->
            binding.etNewClientName.setText(country)
        })
        binding.btnAddNewClientToList.setOnClickListener{
            sharedViewModel.saveCountry(binding.etNewClientName.text.toString())
            navHostFragment.findNavController()
                .navigate(R.id.action_newClient_to_clientsFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}