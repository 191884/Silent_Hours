package com.yo.silent_hours

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication
import com.yo.silent_hours.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val viewModel: ProfileViewModel by viewModels {
//        ProfileViewModelFactory((application as QuiteApplication).repository)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val profileListAdapter = ProfileListAdapter()
//        binding.rv.adapter = profileListAdapter
//        binding.rv.layoutManager = LinearLayoutManager(this)
//        viewModel.allProfiles.observe(this, Observer { profileListAdapter.submitList(it) })
//        binding.addButton.setOnClickListener{
//            val intent = Intent(this,NewProfileActivity::class.java)
//            startActivity(intent)
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(binding.myNavHostFragment.rootView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}