package com.example.secondjobapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.secondjobapp.R
import com.example.secondjobapp.R.drawable
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class JobFragment : Fragment(R.layout.fragment_job) {

    private val viewModel : MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}