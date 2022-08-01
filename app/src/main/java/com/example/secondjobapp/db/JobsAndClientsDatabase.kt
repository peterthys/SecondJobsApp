package com.example.secondjobapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Job::class, Client::class],
    version = 2
)
abstract class JobsAndClientsDatabase : RoomDatabase() {

    abstract fun getJobsDao():JobsDAO
    abstract fun getClientsDao():ClientsDAO

}