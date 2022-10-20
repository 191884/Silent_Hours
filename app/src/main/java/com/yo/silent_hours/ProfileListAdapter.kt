package com.yo.silent_hours

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.databinding.ItemRowBinding

class ProfileListAdapter: ListAdapter<Profile, ProfileListAdapter.ViewHolder>(PROFILE_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
//        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item.name)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val profileName: TextView = itemView.findViewById(  R.id.ProfileName)
        fun bind(item: String){
            profileName.text = item
//            binding.timeStamp.text = item.timeInstance
//            binding.pauseSwitch.isChecked = item.pauseSwitch
//            val days: MutableList<Boolean>
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