package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.secondjobapp.R
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients) {

    private val viewModel: MainViewModel by viewModels()




}