package com.yo.silent_hours

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.databinding.ItemRowBinding

class ProfileListAdapter: ListAdapter<Profile, ProfileListAdapter.ViewHolder>(PROFILE_COMPARATOR) {

    inner class ViewHolder(private val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Profile){
            binding.ProfileName.text = item.name
//            binding.timeStamp.text = item.timeInstance
//            binding.pauseSwitch.isChecked = item.pauseSwitch
//            val days: MutableList<Boolean>
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


companion object {
    private val PROFILE_COMPARATOR = object : DiffUtil.ItemCallback<Profile>() {
        override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem == newItem
        }
    }
}
}