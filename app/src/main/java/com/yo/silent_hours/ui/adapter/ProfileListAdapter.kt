package com.yo.silent_hours.ui.adapter

import android.media.AudioManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.yo.silent_hours.R
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.utils.Utils

class ProfileListAdapter(private val adapterCallback: AdapterCallback
): ListAdapter<Profile, ProfileListAdapter.ViewHolder>(PROFILE_COMPARATOR) {

    var profiles = ArrayList<Profile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
//        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, adapterCallback)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val profileName: TextView = itemView.findViewById(R.id.ProfileName)
        private val timeStamp : TextView = itemView.findViewById(R.id.timeStamp)
        private val profileCard: RelativeLayout = itemView.findViewById(R.id.profile_card)
        private val pauseSwitch: SwitchMaterial = itemView.findViewById(R.id.pauseSwitch)
        private val card: CardView = itemView.findViewById(R.id.card)
        fun bind(item: Profile, adapterCallback: AdapterCallback){
            profileName.text = item.name
            timeStamp.text = item.timeInstance
            pauseSwitch.isChecked = item.pauseSwitch

            profileCard.setOnClickListener {
                adapterCallback.openProfileDetails(item)
//                Navigation.findNavController(itemView).navigate(R.id.action_mainFragment_to_detailsFragment)
            }

            pauseSwitch.setOnClickListener {
                item.pauseSwitch = false
                adapterCallback.cancelWorkByTag(item.profileId.toString())
                if (!pauseSwitch.isChecked) {
                    Utils.showSnackBar(card, "${item.name} is Paused")
//                    if (StoreSession.readLong(AppConstants.ACTIVE_PROFILE_ID) == item.profileId)
//                        audioManager.ringerMode =
//                            StoreSession.readInt(AppConstants.RINGTONE_MODE)
                } else {
                    Utils.showSnackBar(card, "${item.name} is Resumed")
//                    if ((StoreSession.readLong(AppConstants.ACTIVE_PROFILE_ID) == item.profileId) &&
//                        ((item.shr == item.ehr && (currentHour == item.ehr && currentMinute > item.emin) || (currentHour > item.ehr)) ||
//                                (item.shr < item.ehr && (currentHour >= item.ehr)) || (item.shr > item.ehr && (currentHour <= item.ehr)))
//                    ) {
//                        StoreSession.writeInt(AppConstants.BEGIN_STATUS, 0)
//                        StoreSession.writeLong(AppConstants.ACTIVE_PROFILE_ID, 0)
//                    } else {
//                        setNewAlarms(item)
//                    }
                }
                adapterCallback.updateItem(item)
            }
        }
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row, parent, false)
                return ViewHolder(view)
            }
        }

    }

    companion object {
        private val PROFILE_COMPARATOR = object : DiffUtil.ItemCallback<Profile>() {
            override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}