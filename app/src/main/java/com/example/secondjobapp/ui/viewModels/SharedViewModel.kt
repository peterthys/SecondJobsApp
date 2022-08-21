package com.example.secondjobapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

   var client = Client("","","")

    val clientList = mainRepository.getAllClients()
//        mutableListOf(
//        Client("Peter", "Putte", "032"),
//        Client("Wouter", "Heultje", "025")
//    )

    fun saveClient() {
        viewModelScope.launch {
            mainRepository.insertClient(client)

        }
    }
}