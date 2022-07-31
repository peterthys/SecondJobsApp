package com.example.secondjobapp

import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.secondjobapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clients.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint

class MainActivity() : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    private lateinit var dateText: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateText = findViewById(R.id.text_date)

        val formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY HH:mm:ss")
        val dateOfJob = formatter.format(LocalDateTime.now())


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.navHostFragment)
        bottomNavigationView.setupWithNavController(navController)


        dateText.text = "Hallo"
        setSupportActionBar(toolbar)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
                navHostFragment.findNavController()
            }


        //      var clientList = mutableListOf(
        //          Client("Peter", "Putte", "032"),
        //          Client("Wouter", "Heultje", "025")
        //      )
//        val adaptor = ClientsAdaptor(clientList)
//        rv_clients.adapter = adaptor
//        rv_clients.layoutManager = LinearLayoutManager(this)

//        bt_make_new_client.setOnClickListener(){
//            navHostFragment.findNavController().navigate(R.id.action_clientsFragment_to_newClient)
//        }

    }
}





