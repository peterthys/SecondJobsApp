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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.secondjobapp.databinding.ActivityMainBinding
import com.example.secondjobapp.db.Client
import com.example.secondjobapp.ui.fragments.ClientsFragment
import com.example.secondjobapp.ui.fragments.JobFragment
import com.example.secondjobapp.ui.fragments.OverviewFragment
import com.example.secondjobapp.ui.viewModels.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clients.*
import kotlinx.android.synthetic.main.fragment_new_client.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val clientsFragment = ClientsFragment()
        val overViewFragment = OverviewFragment()
        val jobFragment = JobFragment()
setCurentFragment(jobFragment)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.jobFragment -> setCurentFragment(jobFragment)
                R.id.clientsFragment -> setCurentFragment(clientsFragment)
                R.id.overviewFragment -> setCurentFragment(overViewFragment)
            }
            true
        }
    }

    private fun setCurentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.bottomNavigationView, fragment)
            commit()
        }

//    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//    val navController = findNavController(R.id.navHostFragment)
//    bottomNavigationView.setupWithNavController(navController)
//
//
//
//    setSupportActionBar(toolbar)
//
//    bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
//    navHostFragment.findNavController().addOnDestinationChangedListener
//    {
//        _, destination, _ ->
//        navHostFragment.findNavController()
//    }


}








