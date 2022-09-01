package com.example.secondjobapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondjobapp.databinding.ItemJobBinding
import com.example.secondjobapp.db.Job
import com.example.secondjobapp.ui.fragments.OverviewFragment
import kotlinx.android.synthetic.main.item_job.view.*

class JobsAdapter(
    private val listener: OverviewFragment
    //private var jobsList: List<Job>
) : RecyclerView.Adapter<JobsAdapter.JobViewHolder>() {

    inner class JobViewHolder(val itemBinding: ItemJobBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    var jobsList: List<Job> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {

        val itemBinding = ItemJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return JobViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        with(holder) {
            with(jobsList[position]) {
                itemBinding.tvJobDate2.text = this.dateOfTheJob.toString()
                itemBinding.tvJobClient2.text = this.client
                itemBinding.tvJobEnd2.text = this.endTime.toString()
                itemBinding.tvJobPause2.text = this.pause.toString()
                itemBinding.tvJobStart2.text = this.startTime.toString()
                itemBinding.tvJobResult2.text = this.result
            }
        }
//        val currentJob = jobsList[position]
//        holder.textViewDate2.text = currentJob.dateOfTheJob.toString()
//        holder.textViewClient2.text = currentJob.client
//        holder.textViewStart2.text = currentJob.startTime.toString()
//        holder.textViewEnd2.text = currentJob.endTime.toString()
//        holder.textViewPause2.text = currentJob.pause.toString()
//        holder.textViewResult2.text = currentJob.result
    }

    override fun getItemCount(): Int = jobsList.size

    //    inner class JobViewHolder(val itemBinding : ItemJobBinding):RecyclerView.ViewHolder(itemBinding.root){
//
//        val textViewDate1: TextView = itemView.tv_jobDate1
//        val textViewDate2: TextView = itemView.tv_jobDate2
//        val textViewClient1: TextView = itemView.tv_jobClient1
//        val textViewClient2: TextView = itemView.tv_jobClient2
//        val textViewStart1: TextView = itemView.tv_jobStart1
//        val textViewStart2: TextView = itemView.tv_jobStart2
//        val textViewEnd1: TextView = itemView.tv_jobEnd1
//        val textViewEnd2: TextView = itemView.tv_jobEnd2
//        val textViewPause1: TextView = itemView.tv_jobPause1
//        val textViewPause2: TextView = itemView.tv_jobPause2
//        val textViewResult1: TextView = itemView.tv_jobResult1
//        val textViewResult2: TextView = itemView.tv_jobResult2
//    }
    fun updateList(list: List<Job>) {
        jobsList = list
        notifyDataSetChanged()
    }

}