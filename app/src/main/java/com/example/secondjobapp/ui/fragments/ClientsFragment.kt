package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondjobapp.ClientsAdaptor
import com.example.secondjobapp.R
import com.example.secondjobapp.databinding.FragmentClientsBinding
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.viewModels.MainViewModel
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clients.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients) {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentClientsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    var clientsList: LiveData<List<Client>> = viewModel.mainRepository.clientList

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        sharedViewModel.clientsName.observe(viewLifecycleOwner, { name ->
            binding.etNaamvdklant.setText(name)
        })

        sharedViewModel.clientsAdress.observe(viewLifecycleOwner, { adress ->
            binding.etNaamvdklant.setText(adress)
        })

        sharedViewModel.clientsPhone.observe(viewLifecycleOwner, { phone ->
            binding.etNaamvdklant.setText(phone)

            //      val newMadeClient = Client ()

        })
        binding.btMakeNewClient.setOnClickListener {
            sharedViewModel.saveNewClient(binding.etNaamvdklant.text.toString(), "gent", "012")
            navHostFragment.findNavController()
                .navigate(R.id.action_clientsFragment_to_newClient)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var klantPeter = Client("Peter", "Putte", "012")
        lifecycleScope.launch {
            viewModel.mainRepository.insertClient(klantPeter)

        }
        val adapter = ClientsAdaptor(clientsList)
        rv_clients.adapter = adapter
        rv_clients.layoutManager = LinearLayoutManager(context)
        //  rv_clients.setOnClickListener(context)
        bt_make_new_client.setOnClickListener {


            navHostFragment.findNavController().navigate(R.id.action_clientsFragment_to_newClient)
//            val name = et_naamvdklant.text.toString()
//            val client = Client(name, "hollebolle", "007")
//            clientsList!!.add(client)
//            val name = et_newClientName.text.toString()
//            val adress = et_newClientAdress.text.toString()
//            val phoneNumber : String = et_newClientPhone.text.toString()
//            val newClient = Client(name,adress,phoneNumber)
//            clientList.add(newClient)
//            adapter.notifyItemInserted(clientsList!!.size - 1)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

