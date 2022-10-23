package com.yo.silent_hours.ui

import android.app.NotificationManager
import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yo.silent_hours.R
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication
import com.yo.silent_hours.ui.adapter.AdapterCallback
import com.yo.silent_hours.ui.adapter.ProfileListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject lateinit var audioManager: AudioManager
    @Inject lateinit var notificationManager: NotificationManager

    private val profilesListData: ArrayList<Profile> = ArrayList()
    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((activity?.application as QuiteApplication).repository)
    }

    private val adapterCallback = object : AdapterCallback {
        override fun updateItem(profile: Profile) {
            viewModel.update(profile)
        }

        override fun openProfileDetails(profile: Profile) {
            val args = Bundle()
            args.putParcelable("Profile", profile)
            val dialog = DetailsFragment.newInstance(args)
            dialog.show(
                requireActivity().supportFragmentManager,
                "DialogFragment"
            )
        }

        override fun setAlarms(profile: Profile, startHour: Int, startMinute: Int) {
//            viewModel.setAlarms(profile, startHour, startMinute)
        }

        override fun cancelWorkByTag(tag: String) {
//            viewModel.cancelAllWorkByTag(tag)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val rv: RecyclerView = view.findViewById(R.id.rv)
        val profileListAdapter = ProfileListAdapter(adapterCallback)
        rv.adapter = profileListAdapter
        rv.layoutManager = LinearLayoutManager(context)

        viewModel.allProfiles.observe(viewLifecycleOwner, Observer { profilesList ->
            profilesListData.clear()
            profilesListData.addAll(profilesList)
            profileListAdapter.submitList(profilesList)
            profileListAdapter.profiles = profilesList as ArrayList<Profile>
        })

        val button:FloatingActionButton = view.findViewById(R.id.add_button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newProfileFragment)
        }
        return view
    }
}