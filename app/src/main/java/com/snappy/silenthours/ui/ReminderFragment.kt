package com.snappy.silenthours.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.snappy.silenthours.R
import com.snappy.silenthours.databinding.FragmentReminderBinding
import com.snappy.silenthours.notificationDb.NotiProfile
import com.snappy.silenthours.notificationDb.NotiProfileViewModel
import com.snappy.silenthours.utils.Utils
import com.snappy.silenthours.utils.Utils.setStringFormat
import com.snappy.silenthours.utils.Utils.showSnackBar
import com.snappy.silenthours.utils.Utils.showTimePicker
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ReminderFragment : Fragment() {

    private val viewModel: NotiProfileViewModel by viewModels()
    private var _binding: FragmentReminderBinding? = null
    private val binding
        get() = _binding!!
    private var shr = 0
    private var smin = 0
    private var sday =0
    private var smonth = 0
    private var syear = 0
    private var currentTime = Calendar.getInstance()
    private val hour = currentTime.get(Calendar.HOUR_OF_DAY)
    private val minute = currentTime.get(Calendar.MINUTE)
    private val appSharedPrefs by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            requireContext()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReminderBinding.inflate(inflater, container, false)

        val dateView: TextView = binding.StartDate
        dateView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        var cal = Calendar.getInstance()

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
            dateView.performClick()
        }

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            sday = dayOfMonth
            smonth = monthOfYear
            syear = year
            Log.i("Edit Time", "$sday $smonth $syear")

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
            dateView.text = sdf.format(cal.time)
        }

        dateView.setOnClickListener {
            DatePickerDialog(requireActivity(), dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.makeProfileFab.setOnClickListener {
            validate(binding)
        }

        return binding.root
    }

    private fun validate(binding: FragmentReminderBinding){
        if(binding.NameInput.text.isNullOrEmpty()){
            showSnackBar(binding.root,"Enter the Reminder Name.")
            validate(binding)
        }
        else if(binding.StartTime.text.isNullOrEmpty()){
            showSnackBar(binding.root,"Please specify the time.")
        }
        else
            addProfile()
    }

    private fun addProfile() {
        val currentTime =
            SimpleDateFormat("EEE, d MMM yyyy hh:mm", Locale.getDefault()).format(Date())
        val notiProfile = NotiProfile(
            name = binding.NameInput.text.toString(),
            shr = shr,
            smin = smin,
            sday = sday,
            smonth = smonth,
            syear = syear,
            timeInstance = currentTime,
            pauseSwitch = true,
            notes = binding.NoteInput.text.toString()
        )

        if (binding.makeProfileFab.text == "Submit") {
            notiProfile.profileId = System.currentTimeMillis()
            viewModel.insert(notiProfile)
            viewModel.setAlarms(notiProfile)
        }
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_reminderFragment_to_notiMainFragment)
    }

}