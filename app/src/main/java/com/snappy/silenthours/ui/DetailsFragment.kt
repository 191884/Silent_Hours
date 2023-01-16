package com.snappy.silenthours.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.snappy.silenthours.R
import com.snappy.silenthours.database.Profile
import com.snappy.silenthours.databinding.FragmentDetailsBinding
import com.snappy.silenthours.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : BottomSheetDialogFragment() {

    @Inject lateinit var gson: Gson

    private lateinit var profile: Profile
    private var _binding: FragmentDetailsBinding? = null
    private var days: MutableList<Boolean> = ArrayList()
    private val type = object : TypeToken<List<Boolean>>() {}.type
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(args: Bundle) = DetailsFragment().apply {
            arguments = args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false)
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        profile = requireArguments().getParcelable("Profile")!!
        setupUI(profile)

        binding.editButton.setOnClickListener {
            editProfile()
        }
        return binding.root
    }

    private fun setupUI(profile: Profile) {
        days = gson.fromJson(profile.d, type)
//        Utils.detailFragmentChipsBinder(binding,days)
        Utils.setupChip(binding,days,layoutInflater)
        binding.profileTxt.text = profile.name
        binding.str.text = "${setTimeString(profile.shr)}:${setTimeString(profile.smin)}"
        binding.end.text = "${setTimeString(profile.ehr)}:${setTimeString(profile.emin)}"
        if (profile.vibSwitch) binding.audioMode.setImageResource(R.drawable.vibration_img)
        else binding.audioMode.setImageResource(R.drawable.muted_img)
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