package com.example.secondjobapp.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.db.Job
import com.example.secondjobapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository : MainRepository
) : ViewModel(){

    var job = Job(0L,"",0L,0L, 0,"")
    val jobsList = mainRepository.getAllJobsSortedByDate()

    fun saveJob(){

        viewModelScope.launch {
            mainRepository.insertJob(job)
        }
    }
}
