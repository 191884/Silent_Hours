package com.yo.silent_hours.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yo.silent_hours.R
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.databinding.FragmentDetailsBinding

class DetailsFragment : BottomSheetDialogFragment() {

    private lateinit var profile: Profile
    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(args: Bundle) = DetailsFragment().apply {
            arguments = args
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false)
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        profile = requireArguments().getParcelable("Profile")!!
        binding.editButton.setOnClickListener {
            editProfile()
        }
        setupUI(profile)
        return binding.root
    }

    private fun setupUI(profile: Profile) {
//        days = gson.fromJson(profile.d, type)
//        Utils.selectedDays(days, binding.dayPicker)
        binding.profileTxt.text = profile.name
        binding.str.text = "${setTimeString(profile.shr)}:${setTimeString(profile.smin)}"
        binding.end.text = "${setTimeString(profile.ehr)}:${setTimeString(profile.emin)}"
        if (profile.vibSwitch) binding.audioMode.setImageResource(R.drawable.vibration)
        else binding.audioMode.setImageResource(R.drawable.mute)
        binding.repeatWeeklyIcon.visibility = if (profile.repeatWeekly) View.VISIBLE else View.GONE
    }
    private fun setTimeString(i: Int): String {
        return if (i < 10) {
            "0$i"
        } else {
            "$i"
        }
    }

    private fun editProfile() {
        val bundle = Bundle().apply { putParcelable("Profile", profile) }
//        StoreSession.writeLong(AppConstants.PROFILE_ID, profile.profileId)
        findNavController(this).navigate(R.id.newProfileFragment, bundle)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}