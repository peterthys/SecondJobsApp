package com.example.secondjobapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _clientsName = MutableLiveData("")
    val clientsName: LiveData<String> = _clientsName
    fun saveCountry(newClientsName : String){
        _clientsName.value = newClientsName
    }
}