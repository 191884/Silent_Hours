package com.snappy.silenthours.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.snappy.silenthours.R
import com.snappy.silenthours.notificationDb.NotiProfile
import soup.neumorphism.NeumorphCardView

class NotiProfileListAdapter(private val notiAdapterCallback: NotiAdapterCallback
): ListAdapter<NotiProfile, NotiProfileListAdapter.ViewHolder>(PROFILE_COMPARATOR) {

    var notiProfiles = ArrayList<NotiProfile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
//        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, notiAdapterCallback)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val profileName: TextView = itemView.findViewById(R.id.NotiProfileName)
        private val timeStamp : TextView = itemView.findViewById(R.id.notiTimeStamp)
        private val pauseSwitch: SwitchMaterial = itemView.findViewById(R.id.notiPauseSwitch)
        private val notiNote: TextView = itemView.findViewById(R.id.notiNote)
        private val notificationTime: TextView = itemView.findViewById(R.id.notiTime)
        fun bind(item: NotiProfile, adapterCallback: NotiAdapterCallback){
            profileName.text = item.name
            timeStamp.text = item.timeInstance
            pauseSwitch.isChecked = item.pauseSwitch
            notiNote.text = item.notes
            notificationTime.text= "${item.sday}/${item.smonth}/${item.syear}  ${item.shr}:${item.smin}"
        }
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.noti_item_row, parent, false)
                return ViewHolder(view)
            }
        }

    }

    companion object {
        private val PROFILE_COMPARATOR = object : DiffUtil.ItemCallback<NotiProfile>() {
            override fun areItemsTheSame(oldItem: NotiProfile, newItem: NotiProfile): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NotiProfile, newItem: NotiProfile): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}