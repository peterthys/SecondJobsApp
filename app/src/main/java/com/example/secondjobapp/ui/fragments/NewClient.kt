package com.example.secondjobapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.secondjobapp.R
import com.example.secondjobapp.databinding.FragmentNewClientBinding
import com.example.secondjobapp.ui.viewModels.MainViewModel
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class NewClient : Fragment(R.layout.fragment_new_client) {
    private var _binding: FragmentNewClientBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewClientBinding.inflate(inflater, container, false)
        binding.etNewClientName.setText(sharedViewModel.client.name)

        binding.btnAddNewClientToList.setOnClickListener {
            sharedViewModel.client.name = binding.etNewClientName.text.toString()
            sharedViewModel.client.adress = binding.etNewClientAdress.text.toString()
            sharedViewModel.client.phoneNumber = binding.etNewClientPhone.text.toString()
            sharedViewModel.saveClient()
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