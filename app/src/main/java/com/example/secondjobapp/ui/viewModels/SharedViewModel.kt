package com.example.secondjobapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondjobapp.db.Client

class SharedViewModel : ViewModel() {

    private var _newClientsName = MutableLiveData("")
    val clientsName: LiveData<String> = _newClientsName

    private var _newClientsAdress = MutableLiveData("")
    val clientsAdress: LiveData<String> = _newClientsAdress

    private var _newClientsPhone = MutableLiveData("")
    val clientsPhone: LiveData<String> = _newClientsPhone
    
   fun saveNewClient  (clientsName : String, clientsAdress : String, clientsPhone : String) //: Client
   {
        _newClientsName.value = clientsName
        _newClientsAdress.value = clientsAdress
        _newClientsPhone.value = clientsPhone
// val newMadeClient = Client (clientsName,clientsAdress,clientsPhone)
//        return newMadeClient

    }
}