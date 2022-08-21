package com.example.secondjobapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_table")
data class Client(
   @PrimaryKey(autoGenerate = false)
   var name : String,
   var adress : String,
   var phoneNumber : String
)
