package com.example.secondjobapp.repositories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.db.ClientsDAO
import com.example.secondjobapp.db.Job
import com.example.secondjobapp.db.JobsDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val jobsDAO: JobsDAO,val clientsDAO: ClientsDAO
) {
    suspend fun insertJob (job: Job) = jobsDAO.insertJob(job)
    suspend fun deleteJob (job: Job) = jobsDAO.deleteJob(job)
    fun getAllJobsSortedByClient() = jobsDAO.getAllJobsSortedByClient()
    fun getAllJobsSortedByDate() = jobsDAO.getAllJobsSortedByDate()

    suspend fun insertClient (client: Client) = clientsDAO.insertClient(client)
    suspend fun deleteClient (client: Client) = clientsDAO.deleteClient(client)
    fun getAllClients() = clientsDAO.getAllClients()
    var clientList : LiveData<List<Client>> = clientsDAO.getAllClients()

}