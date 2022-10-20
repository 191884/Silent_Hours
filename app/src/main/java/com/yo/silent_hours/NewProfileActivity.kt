package com.yo.silent_hours

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication
import com.yo.silent_hours.databinding.ActivityNewProfileBinding

class NewProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewProfileBinding
    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((application as QuiteApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.toolBar.setNavigationOnClickListener{ onBackPressed() }
//        val viewModel: ProfileViewModel by lazy { ViewModelProvider(this)[ProfileViewModel::class.java] }

        binding.makeProfileFab.setOnClickListener {
            val profile = Profile(name = binding.userToDoEditText.text.toString())
            Toast.makeText(
                applicationContext,
                "Adding Name",
                Toast.LENGTH_LONG
            ).show()
            viewModel.insert(profile)
            finish()
        }
//        val profile = Profile(name = binding.userToDoEditText.text.toString())
//        binding.makeProfileFab.setOnClickListener {
//            viewModel.insert(profile)
////            validateProfileData(it)
//        }


    }
}