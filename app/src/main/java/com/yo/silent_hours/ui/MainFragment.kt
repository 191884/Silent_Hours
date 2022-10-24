package com.yo.silent_hours.ui

import android.app.NotificationManager
import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.yo.silent_hours.R
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication
import com.yo.silent_hours.ui.adapter.AdapterCallback
import com.yo.silent_hours.ui.adapter.ProfileListAdapter
import com.yo.silent_hours.utils.SwipeToDeleteCallback
import com.yo.silent_hours.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject lateinit var audioManager: AudioManager
    @Inject lateinit var notificationManager: NotificationManager

    private val profilesListData: ArrayList<Profile> = ArrayList()
    private lateinit var profileListAdapter: ProfileListAdapter
    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((activity?.application as QuiteApplication).repository)
    }
    private lateinit var coordLayout : ConstraintLayout

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
        coordLayout = view.findViewById(R.id.coord_Layout)

        val rv: RecyclerView = view.findViewById(R.id.rv)
        profileListAdapter = ProfileListAdapter(adapterCallback)
        rv.adapter = profileListAdapter
        rv.layoutManager = LinearLayoutManager(context)

        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(rv)

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

    private val swipeToDeleteCallback by lazy {
        object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                val position = viewHolder.adapterPosition
                removeItem(position)
                val item = profilesListData[position]
                AlertDialog.Builder(requireContext())
                    .setTitle("Delete Profile")
                    .setMessage("Are you sure you want to delete this profile?")
                    .setPositiveButton("Yes") { _, dialogInterface ->
                        deleteItem(item)
                    }
                    .setNegativeButton("No") { _, dialogInterface ->
                        restoreItem(item, position)
                    }
                    .setCancelable(false)
                    .show()
            }
        }
    }

    private fun removeItem(position: Int) {
        viewModel.delete(profilesListData[position])
        profileListAdapter.notifyItemRemoved(position)
    }

    private fun deleteItem(profile: Profile) {
        viewModel.cancelAllWorkByTag(profile.profileId.toString())
        Utils.showSnackBar(
            coordLayout,
            "Profile is removed from the list.",
            Snackbar.LENGTH_LONG
        )
    }

    private fun restoreItem(profile: Profile, position: Int) {
        profilesListData.add(position, profile)
        profileListAdapter.notifyItemChanged(position)
        viewModel.insert(profile)
    }

}