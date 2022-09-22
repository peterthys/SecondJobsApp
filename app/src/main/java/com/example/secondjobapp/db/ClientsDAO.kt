package com.example.secondjobapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ClientsDAO {




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient (client: Client)

    @Delete
    suspend fun deleteClient(client: Client)

    @Query("SELECT * FROM clients_table ORDER BY NAME ASC")
    fun getAllClients(): LiveData<List<Client>>

@Update
suspend fun updateClient(client: Client)
}