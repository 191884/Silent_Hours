package com.yo.silent_hours.ui

import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yo.silent_hours.R
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.databinding.FragmentNewProfileBinding
import com.yo.silent_hours.utils.Utils
import com.yo.silent_hours.utils.Utils.checkDays
import com.yo.silent_hours.utils.Utils.selectDays
import com.yo.silent_hours.utils.Utils.setStringFormat
import com.yo.silent_hours.utils.Utils.showTimePicker
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class NewProfileFragment() : Fragment() {

    @Inject
    lateinit var gson: Gson


    private val viewModel: ProfileViewModel by viewModels()
//    { ProfileViewModelFactory((activity?.application as QuiteApplication).repository) }

    private var _binding: FragmentNewProfileBinding? = null
    private val binding
        get() = _binding!!
    private val type = object : TypeToken<List<Boolean>>() {}.type
    private var shr = 0
    private var smin = 0
    private var ehr = 0
    private var emin = 0
    private var daysSelected: MutableList<Boolean> = arrayListOf(false, false, false, false, false, false, false)
    private var currentTime = Calendar.getInstance()
    private val hour = currentTime.get(Calendar.HOUR_OF_DAY)
    private val minute = currentTime.get(Calendar.MINUTE)
    private val appSharedPrefs by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            requireContext()
        )
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_new_profile, container, false)
        _binding = FragmentNewProfileBinding.inflate(inflater, container, false)

        binding.toolBar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.vibSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.vibSwitch.text = if (isChecked) {
                "Vibrate"
            } else {
                "Silent"
            }
        }

        binding.NameInput.requestFocus()

        binding.StartTime.setOnClickListener {
            requireContext().showTimePicker(
                onTimeSelected = { hour, min ->
                    binding.StartTime.setStringFormat(
                        Utils.setTimeString(hour),
                        Utils.setTimeString(min)
                    )
                    shr = Utils.setTimeString(hour).toInt()
                    smin = Utils.setTimeString(min).toInt()
                }, hour, minute, appSharedPrefs.getBoolean("time format", false)
            )
        }


        binding.EndTime.setOnClickListener {
            requireContext().showTimePicker(
                onTimeSelected = { hour, min ->
                    binding.EndTime.setStringFormat(
                        Utils.setTimeString(hour),
                        Utils.setTimeString(min)
                    )
                    ehr = Utils.setTimeString(hour).toInt()
                    emin = Utils.setTimeString(min).toInt()
                }, hour, minute, appSharedPrefs.getBoolean("time format", false)
            )
        }
        binding.makeProfileFab.setOnClickListener {
            validateProfileData(it)
        }

        val args = arguments?.getParcelable<Profile>("Profile")
        if (args != null) {
            daysSelected = Utils.daysList(args.d)
//            selectDays(binding, daysSelected)
            binding.NameInput.setText(args.name)

            binding.StartTime.setStringFormat(
                Utils.setTimeString(args.shr),
                Utils.setTimeString(args.smin)
            )

            checkDays(binding,gson.fromJson(args.d, type))

            shr = args.shr
            smin = args.smin
            ehr = args.ehr
            emin = args.emin
            binding.EndTime.setStringFormat(
                Utils.setTimeString(args.ehr),
                Utils.setTimeString(args.emin)
            )
            binding.vibSwitch.isChecked = args.vibSwitch
            binding.repeatWeeklySwitch.isChecked = args.repeatWeekly
            binding.makeProfileFab.text = "UPDATE"
        }
        return binding.root
    }


    private fun validateProfileData(view: View) {
//        setDaysSelectedValue(binding.dayPicker.selectedDays)
        if (binding.NameInput.text?.isEmpty() == true) {
            Utils.showSnackBar(view, "Please enter the Profile name", Snackbar.LENGTH_LONG)
        } else if ((shr == ehr) && (smin == emin)) {
            Utils.showSnackBar(
                view,
                "Please enter different start and end time",
                Snackbar.LENGTH_LONG
            )
        } else if (selectDays(binding, daysSelected).all { false }) {
            Utils.showSnackBar(view, "Please select the day(s)", Snackbar.LENGTH_LONG)
        } else if ((shr > ehr) && (shr - ehr <= 12)) {
            Utils.showSnackBar(
                view,
                "Please enter a valid time.(Within 12 hour limit)",
                Snackbar.LENGTH_LONG
            )
        } else {
            addProfile()
        }
    }

    private fun addProfile() {
        val currentTime =
            SimpleDateFormat("EEE, d MMM yyyy hh:mm", Locale.getDefault()).format(Date())
        val profile = Profile(
            name = binding.NameInput.text.toString(),
            timeInstance = currentTime,
            shr = shr,
            smin = smin,
            ehr = ehr,
            emin = emin,
            d = gson.toJson(daysSelected),
            pauseSwitch = true,
            repeatWeekly = binding.repeatWeeklySwitch.isChecked,
            vibSwitch = binding.vibSwitch.isChecked,
        )

        if (binding.makeProfileFab.text == "Submit") {
            profile.profileId = System.currentTimeMillis()
            viewModel.insert(profile)
        } else {
//            viewModel.cancelAllWorkByTag(id.toString())
//            profile.profileId = id
            viewModel.update(profile)
        }
        viewModel.setAlarms(profile)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_newProfileFragment_to_mainFragment)
    }

}
