package com.example.secondjobapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface JobsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob (job: Job)

    @Delete
    suspend fun deleteJob(job: Job)

    @Query("SELECT * FROM jobs_table ORDER BY client ASC")
    fun getAllJobsSortedByClient(): LiveData<List<Job>>

    @Query("SELECT * FROM jobs_table ORDER BY dateOfTheJob ASC")
    fun getAllJobsSortedByDate(): LiveData<List<Job>>
}