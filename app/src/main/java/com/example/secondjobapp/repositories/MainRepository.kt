package com.example.secondjobapp.repositories

import com.example.secondjobapp.db.Job
import com.example.secondjobapp.db.JobsDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val jobsDAO: JobsDAO
) {
    suspend fun insertJob (job: Job) = jobsDAO.insertJob(job)
    suspend fun deleteJob (job: Job) = jobsDAO.deleteJob(job)
    fun getAllJobsSortedByClient() = jobsDAO.getAllJobsSortedByClient()
    fun getAllJobsSortedByDate() = jobsDAO.getAllJobsSortedByDate()
}