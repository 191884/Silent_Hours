package com.snappy.silenthours.ui.adapter

import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.switchmaterial.SwitchMaterial
import com.snappy.silenthours.R
import com.snappy.silenthours.database.Profile
import com.snappy.silenthours.utils.Utils
import soup.neumorphism.NeumorphCardView

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
        private val timeInstance : TextView = itemView.findViewById(R.id.timeInstance)
        private val profileCard: RelativeLayout = itemView.findViewById(R.id.profile_card)
        private val pauseSwitch: SwitchMaterial = itemView.findViewById(R.id.pauseSwitch)
        private val card: NeumorphCardView = itemView.findViewById(R.id.card)
        fun bind(item: Profile, adapterCallback: AdapterCallback){
            profileName.text = item.name
            timeStamp.text = item.shr.toString()+":"+item.smin.toString()+" - "+item.ehr.toString()+":"+item.emin.toString()
            pauseSwitch.isChecked = item.pauseSwitch
            timeInstance.text = item.timeInstance

            profileCard.setOnClickListener {
                adapterCallback.openProfileDetails(item)
//                Navigation.findNavController(itemView).navigate(R.id.action_mainFragment_to_detailsFragment)
            }

//            pauseSwitch.setOnClickListener {
//                item.pauseSwitch = false
//                pauseSwitch.isChecked = false
//                adapterCallback.cancelWorkByTag(item.profileId.toString())
//                if (!pauseSwitch.isChecked) {
//                    Utils.showSnackBar(card, "${item.name} is Paused")
////                    if (StoreSession.readLong(AppConstants.ACTIVE_PROFILE_ID) == item.profileId)
////                        audioManager.ringerMode =
////                            StoreSession.readInt(AppConstants.RINGTONE_MODE)
//                } else {
//                    Utils.showSnackBar(card, "${item.name} is Resumed")
////                    if ((StoreSession.readLong(AppConstants.ACTIVE_PROFILE_ID) == item.profileId) &&
////                        ((item.shr == item.ehr && (currentHour == item.ehr && currentMinute > item.emin) || (currentHour > item.ehr)) ||
////                                (item.shr < item.ehr && (currentHour >= item.ehr)) || (item.shr > item.ehr && (currentHour <= item.ehr)))
////                    ) {
////                        StoreSession.writeInt(AppConstants.BEGIN_STATUS, 0)
////                        StoreSession.writeLong(AppConstants.ACTIVE_PROFILE_ID, 0)
////                    } else {
////                        setNewAlarms(item)
////                    }
//                }
//                adapterCallback.updateItem(item)
//            }
            pauseSwitch.setOnClickListener{
                item.pauseSwitch = false
                adapterCallback.cancelWorkByTag(item.profileId.toString())
                if(!pauseSwitch.isChecked){
                    Utils.showSnackBar(card,"${item.name} is paused.")
                }
                else{
                    Utils.showSnackBar(card, "${item.name} is Resumed")
                    item.pauseSwitch = true
                    adapterCallback.setAlarms(item)
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