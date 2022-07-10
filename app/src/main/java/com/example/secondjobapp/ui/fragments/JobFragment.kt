package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.secondjobapp.R
import com.example.secondjobapp.R.drawable
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@AndroidEntryPoint
class JobFragment : Fragment(R.layout.fragment_job) {

    private lateinit var dateText: TextView

    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatterDate = DateTimeFormatter.ofPattern("dd-MM-YYYY")
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss")
        val start = LocalDateTime.now()
        val dateOfJob = formatterDate.format(LocalDateTime.now())
        val startTime = formatterTime.format(start)


        text_date.text = "$dateOfJob"

        btn_start.setOnClickListener() {
            btn_start.text = "$startTime"
        }
        val end = LocalDateTime.now()
        val endTime = formatterTime.format(end)
        btn_end.setOnClickListener() {
            btn_end.text = "$endTime"
        }

    }

}