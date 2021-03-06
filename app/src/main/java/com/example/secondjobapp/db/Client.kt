package com.example.secondjobapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_table")
data class Client(
   @PrimaryKey(autoGenerate = false)
   val name : String,
   val adress : String,
   val phoneNumber : String
)
