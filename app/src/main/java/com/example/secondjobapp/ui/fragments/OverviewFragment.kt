package com.example.secondjobapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondjobapp.JobsAdapter
import com.example.secondjobapp.R
import com.example.secondjobapp.databinding.ActivityMainBinding
import com.example.secondjobapp.databinding.FragmentOverviewBinding
import com.example.secondjobapp.db.Job
import com.example.secondjobapp.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_overview.*

@AndroidEntryPoint
class OverviewFragment : Fragment(R.layout.fragment_overview) {
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private val mainviewModel: MainViewModel by activityViewModels()
    private var jobsAdapter =  JobsAdapter(this)


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater,container,false)
        mainviewModel.jobsList.observe(viewLifecycleOwner, {
            jobsAdapter.updateList(it)

        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        val job1 = Job(dateOfTheJob = 1111, "jean", 1112, 1113, 30, "1111")
//        val job2 = Job(dateOfTheJob = 2221, "jeanke", 2222, 2223, 30, "2222")
//        var jobsList = listOf(job1,job2)


     rv_jobs.adapter = jobsAdapter
        rv_jobs.layoutManager = LinearLayoutManager(context)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}