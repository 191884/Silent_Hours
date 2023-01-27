package com.snappy.silenthours.ui

import android.app.NotificationManager
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.snappy.silenthours.R
import com.snappy.silenthours.database.Profile
import com.snappy.silenthours.database.ProfileViewModel
import com.snappy.silenthours.databinding.FragmentMainBinding
import com.snappy.silenthours.ui.adapter.AdapterCallback
import com.snappy.silenthours.ui.adapter.ProfileListAdapter
import com.snappy.silenthours.utils.SwipeToDeleteCallback
import com.snappy.silenthours.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {


    @Inject
    lateinit var audioManager: AudioManager
    @Inject
    lateinit var notificationManager: NotificationManager

    private val handler = Handler()
    private val profilesListData: ArrayList<Profile> = ArrayList()
    private lateinit var profileListAdapter: ProfileListAdapter
    private val viewModel: ProfileViewModel by viewModels()
    //    { ProfileViewModelFactory((activity?.application as QuiteApplication).repository) }
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
            viewModel.setAlarms(profile, startHour, startMinute)
        }

        override fun cancelWorkByTag(tag: String) {
            viewModel.cancelAllWorkByTag(tag)
        }
    }

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)
        setHasOptionsMenu(true)

        inflater.inflate(R.layout.persistent_bottom_sheet, container, false)
        coordLayout = binding.constraintLayout
        blink()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerView)
        profileListAdapter = ProfileListAdapter(adapterCallback)
        recyclerview.adapter = profileListAdapter
        recyclerview.layoutManager = LinearLayoutManager(context)
        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(recyclerview)

        binding.title.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_notiMainFragment)
        }
        val timeTableButton: Button = view.findViewById(R.id.timeTable)
        timeTableButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_timeTableFragment)
        }
        viewModel.allProfiles.observe(viewLifecycleOwner) { profilesList ->
            profilesListData.clear()
            profilesListData.addAll(profilesList)
            profileListAdapter.submitList(profilesList)
            profileListAdapter.profiles = profilesList as ArrayList<Profile>
        }

        val button = view.findViewById<Button>(R.id.add_Button)
        button.setOnClickListener {
            if (doNotDisturbPermissionCheck()) {
                permissionDialog()
            } else {
                findNavController().navigate(R.id.action_mainFragment_to_newProfileFragment)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.settings, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.timeTableView -> {
                Log.i("optionMenu", "Reached")
                findNavController().navigate(R.id.action_mainFragment_to_timeTableFragment)
                return true
            }
            R.id.reminderView -> {
                Log.i("optionMenu", "Reached")
                findNavController().navigate(R.id.action_mainFragment_to_notiMainFragment)
                return true
            }
            else -> {super.onOptionsItemSelected(item)}
        }

    }
    private fun doNotDisturbPermissionCheck(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted
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

    private fun blink() {

        GlobalScope.launch {
            delay(1000)
            GlobalScope.launch(Dispatchers.Main) {
                //Action on UI thread
                val hourFormat = SimpleDateFormat("HH", Locale.getDefault())
                val minuteFormat = SimpleDateFormat("mm", Locale.getDefault())
                val secondFormat = SimpleDateFormat("ss", Locale.getDefault())
                var hour = hourFormat.format(Date())
                var minute = minuteFormat.format(Date())
                var second = secondFormat.format(Date()).toString()
                if(second =="00") binding.MinView.startAnimation(AnimationUtils.loadAnimation(activity,
                    R.anim.flip_point_from_middle
                ))
                binding.HourView.text = hour
                binding.MinView.text = minute
                if(hour> 12.toString()) binding.AmPmView.text = "PM"
                blink()
            }
        }
//
//        Thread {
//            try {
//                Thread.sleep(1000)
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//            handler.post {
//                val hourFormat = SimpleDateFormat("HH", Locale.getDefault())
//                val minuteFormat = SimpleDateFormat("mm", Locale.getDefault())
//                val secondFormat = SimpleDateFormat("ss", Locale.getDefault())
//                var hour = hourFormat.format(Date())
//                var minute = minuteFormat.format(Date())
//                var second = secondFormat.format(Date()).toString()
//                if(second =="00") binding.MinView.startAnimation(AnimationUtils.loadAnimation(activity,
//                    R.anim.flip_point_from_middle
//                ))
//                binding.HourView.text = hour
//                binding.MinView.text = minute
//                binding.SecView.text = second
//                if(hour> 12.toString()) binding.AmPmView.text = "PM"
//                binding.SecView.startAnimation(AnimationUtils.loadAnimation(activity,
//                    R.anim.flip_point_from_middle
//                ))
//                blink()
//            }
//        }.start()
    }

}