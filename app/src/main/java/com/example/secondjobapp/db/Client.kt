package com.example.secondjobapp.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "clients_table")
data class Client(
   @PrimaryKey(autoGenerate = false)
   var name : String,
   var adress : String,
   var phoneNumber : String
):Parcelable
