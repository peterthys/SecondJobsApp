package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.secondjobapp.R
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_job.*
import java.lang.String
import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@AndroidEntryPoint
class JobFragment : Fragment(R.layout.fragment_job) {


    private var startTime: Long = 0L
    private var endTime: Long = 0L
    private var pause: Int = 30
    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatterDate = DateTimeFormatter.ofPattern("dd-MM-YYYY")
        val dateOfJob = formatterDate.format(LocalDateTime.now())
        text_date.text = "$dateOfJob"

        btn_start.setOnClickListener {

            val formatTime = SimpleDateFormat("HH:mm:ss")
            startTime = currentTimeMillis()
            val formattedStartTime = formatTime.format(startTime)
            btn_start.text = "start at $formattedStartTime"
        }

        btn_end.setOnClickListener {
            val formatTime = SimpleDateFormat("HH:mm:ss")
            endTime = currentTimeMillis()
            val formattedEndTime = formatTime.format(endTime)
            btn_end.text = "end at $formattedEndTime"
            val total = endTime - startTime

            val seconds = total / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24

            text_result.text = "total job is ${hours} : ${minutes} : ${seconds}"


        }
        val numberPicker = np_pause_lenght
        numberPicker.minValue = 0
        numberPicker.maxValue = 60
        numberPicker.value = 30

        numberPicker.setOnValueChangedListener { numberPicker, oldValue, newValue ->
            pause = newValue
        }

        btn_choose_client.setOnClickListener {
            navHostFragment.findNavController()
                .navigate(R.id.action_jobFragment_to_clientsFragment)
        }

//        fun lachErEensMee(){
//            val a = 1
//        }


    }


}