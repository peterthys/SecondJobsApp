package com.example.secondjobapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Job::class],
    version = 1
)
abstract class JobsDatabase : RoomDatabase() {


}g