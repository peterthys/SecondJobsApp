package com.example.secondjobapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondjobapp.db.Client

class SharedViewModel : ViewModel() {

    private var _clientsName = MutableLiveData("")
    val clientsName: LiveData<String> = _clientsName
    val clientList = mutableListOf(
        Client("Peter", "Putte", "032"),
        Client("Wouter", "Heultje", "025")
    )

    fun saveCountry(newClientsName : String){
        _clientsName.value = newClientsName
        val newClient = Client(newClientsName,"put","123")
        clientList.add(newClient)

    }
}