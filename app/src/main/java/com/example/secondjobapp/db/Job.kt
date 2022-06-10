package com.example.secondjobapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs_table")
data class Job(
    var dateOfTheJob: Long = 0L,
    var startTime: Long = 0L,
    var endTime: Long = 0L,
    var pause: Int = 30,
    var distance: Int = 0,
    var client: String = ""


) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}