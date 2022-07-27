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
import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.logging.SimpleFormatter


@AndroidEntryPoint
class JobFragment : Fragment(R.layout.fragment_job) {


    private var startTime: Long = 0L
    private var endTime: Long = 0L

    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatterDate = DateTimeFormatter.ofPattern("dd-MM-YYYY")
        val dateOfJob = formatterDate.format(LocalDateTime.now())
        text_date.text = "$dateOfJob"

        btn_start.setOnClickListener() {

            val formatTime = SimpleDateFormat("hh:mm:ss")
            startTime = currentTimeMillis()
            val formattedStartTime = formatTime.format(startTime)
            btn_start.text = "start at $formattedStartTime"
        }

        btn_end.setOnClickListener() {
            val formatTime = SimpleDateFormat("hh:mm:ss")
            endTime = currentTimeMillis()
            val formattedEndTime = formatTime.format(endTime)
            btn_end.text = "end at $formattedEndTime"
            val total = endTime - startTime
            val formattedTotal = formatTime.format(total)
            text_result.text = "total job is ${formattedTotal}"


        }



     //   text_result.text = "23"
//        val formatterTime = SimpleDateFormat("HH:mm:ss")
//        val startTime = formatterTime.format(System.currentTimeMillis())
//        Long currentTime = System.currentTimeMillis();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
//        Date date = new Date(currentTime);
//        String time = simpleDateFormat.format(date);


        // val end = LocalDateTime.now()
        //val endTime = formatterTime.format(System.currentTimeMillis())
//        btn_end.setOnClickListener() {
//            val endTime = formatterTime.format(System.currentTimeMillis())
//            btn_end.text = "end at : $endTime"
//        }

    }



}