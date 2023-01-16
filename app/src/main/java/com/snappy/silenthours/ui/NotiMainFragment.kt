package com.snappy.silenthours.ui

import android.app.NotificationManager
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.snappy.silenthours.R
import com.snappy.silenthours.notificationDb.NotiProfile
import com.snappy.silenthours.notificationDb.NotiProfileViewModel
import com.snappy.silenthours.ui.adapter.NotiAdapterCallback
import com.snappy.silenthours.ui.adapter.NotiProfileListAdapter
import com.snappy.silenthours.utils.SwipeToDeleteCallback
import com.snappy.silenthours.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NotiMainFragment : Fragment() {

    @Inject
    lateinit var audioManager: AudioManager
    @Inject
    lateinit var notificationManager: NotificationManager

    private val notiProfilesListData: ArrayList<NotiProfile> = ArrayList()
    private val viewModel: NotiProfileViewModel by viewModels()
    private lateinit var notiProfileListAdapter: NotiProfileListAdapter
    private lateinit var notiLayoutMain: FrameLayout
    private val notiAdapterCallback = object : NotiAdapterCallback {
        override fun updateItem(notiProfile: NotiProfile) {
            viewModel.update(notiProfile)
        }

        override fun openProfileDetails(notiProfile: NotiProfile) {
            TODO("Not yet implemented")
        }

        override fun setAlarms(notiProfile: NotiProfile, startHour: Int, startMinute: Int) {
            TODO("Not yet implemented")
        }

        override fun cancelWorkByTag(tag: String) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_noti_main, container, false)
        val rv: RecyclerView = view.findViewById(R.id.notiRV)
        notiLayoutMain = view.findViewById(R.id.layoutNotiMain)
        notiProfileListAdapter = NotiProfileListAdapter(notiAdapterCallback)
        rv.adapter = notiProfileListAdapter
        rv.layoutManager = LinearLayoutManager(context)
        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(rv)

        viewModel.allProfiles.observe(viewLifecycleOwner, Observer { notiProfilesList ->
            notiProfilesListData.clear()
            notiProfilesListData.addAll(notiProfilesList)
            notiProfileListAdapter.submitList(notiProfilesList)
            notiProfileListAdapter.notiProfiles = notiProfilesList as ArrayList<NotiProfile>
        })

        val title = view.findViewById<TextView>(R.id.title)
        title.setOnClickListener {
            findNavController().navigate(R.id.action_notiMainFragment_to_mainFragment)
        }

        val button: FloatingActionButton = view.findViewById(R.id.noti_add_button)
        button.setOnClickListener {
            if (doNotDisturbPermissionCheck()) {
                permissionDialog()
            } else {
                findNavController().navigate(R.id.action_notiMainFragment_to_reminderFragment)
            }
        }
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    activity?.finish()
                }
            }
            )

        return view
    }

    private val swipeToDeleteCallback by lazy {
        object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                val position = viewHolder.adapterPosition
                removeItem(position)
                val item = notiProfilesListData[position]
                AlertDialog.Builder(requireContext())
                    .setTitle("Delete Profile")
                    .setMessage("Are you sure you want to delete this profile?")
                    .setPositiveButton("Yes") { _, _ ->
                        deleteItem(item)
                    }
                    .setNegativeButton("No") { _, _ ->
                        restoreItem(item, position)
                    }
                    .setCancelable(false)
                    .show()
            }
        }
    }


    private fun removeItem(position: Int) {
        viewModel.delete(notiProfilesListData[position])
        notiProfileListAdapter.notifyItemRemoved(position)
    }

    private fun deleteItem(notiProfile: NotiProfile) {
        viewModel.cancelAllWorkByTag(notiProfile.profileId.toString())
        Utils.showSnackBar(
            notiLayoutMain,
            "Profile is removed from the list.",
            Snackbar.LENGTH_LONG
        )
    }

    private fun restoreItem(notiProfile: NotiProfile, position: Int) {
        notiProfilesListData.add(position, notiProfile)
        notiProfileListAdapter.notifyItemChanged(position)
        viewModel.insert(notiProfile)
    }


    private fun doNotDisturbPermissionCheck(): Boolean {
        return !notificationManager.isNotificationPolicyAccessGranted
    }

    private fun permissionDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Permission Required")
            .setMessage("Please give the Do Not Disturb access permission for the app to work` properly. Click OK to continue.")
            .setCancelable(false)
            .setPositiveButton("Ok") { i, dialogInterface ->
                val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent(
                        Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS
                    )
                } else {
                    TODO("VERSION.SDK_INT < M")
                }

                startActivity(intent)
            }
            .show()
    }

}