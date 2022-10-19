package com.yo.silent_hours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.databinding.FragmentNewProfileBinding
import java.text.SimpleDateFormat
import java.util.*

class NewProfileFragment() : Fragment() {

//    private val viewModel: ProfileViewModel =ViewModelProvider(this).get(ProfileViewModel::class.java)
    private val profileViewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentNewProfileBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNewProfileBinding.inflate(inflater, container, false)
        binding.toolBar.setNavigationOnClickListener { requireActivity().onBackPressed() }

        val profile = Profile(name = binding.userToDoEditText.text.toString())
        binding.makeProfileFab.setOnClickListener {
            profileViewModel.insert(profile)
//            validateProfileData(it)
        }

        return binding.root

    }

    private fun addProfile() {
        val currentTime =
            SimpleDateFormat("EEE, d MMM yyyy hh:mm", Locale.getDefault()).format(Date())
        val profile = Profile(
            name = binding.userToDoEditText.text.toString(),
//            shr = shr,
//            smin = smin,
//            ehr = ehr,
//            emin = emin,
//            d = daysSelected.joinToString ("-"),
//            colorIndex = Random.nextInt(0, 8),
//            vibSwitch = binding.vibSwitch.isChecked,
//            timeInstance = currentTime,
//            repeatWeekly = binding.repeatWeeklySwitch.isChecked,
//            pauseSwitch = true
        )
//        profile.profileId = System.currentTimeMillis()
//            viewModel.insert(profile)
    }

}
