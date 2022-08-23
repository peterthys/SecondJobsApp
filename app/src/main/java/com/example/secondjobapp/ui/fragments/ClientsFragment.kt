package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondjobapp.ClientsAdaptor
import com.example.secondjobapp.R
import com.example.secondjobapp.databinding.FragmentClientsBinding
import com.example.secondjobapp.databinding.FragmentNewClientBinding
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.viewModels.MainViewModel
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clients.*
import kotlinx.android.synthetic.main.fragment_job.*
import kotlinx.android.synthetic.main.fragment_new_client.*
import kotlinx.android.synthetic.main.item_client.*


@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients),ClientsAdaptor.OnItemClickListener {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentClientsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val adaptor = ClientsAdaptor(this)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentClientsBinding.inflate(inflater, container, false)

        sharedViewModel.clientList.observe(viewLifecycleOwner, {
            adaptor.updateList(it)

        })

        binding.btMakeNewClient.setOnClickListener {
            navHostFragment.findNavController()
                .navigate(R.id.action_clientsFragment_to_newClient)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_clients.adapter = adaptor
        rv_clients.layoutManager = LinearLayoutManager(context)

        bt_make_new_client.setOnClickListener {

            navHostFragment.findNavController().navigate(R.id.action_clientsFragment_to_newClient)

        }

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
