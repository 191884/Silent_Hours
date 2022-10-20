package com.yo.silent_hours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication

class MainFragment : Fragment() {

//    private lateinit var profileListAdapter: ProfileListAdapter
//    private var _binding: FragmentMainBinding? = null
//    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((activity?.application as QuiteApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val rv: RecyclerView = view.findViewById(R.id.rv)
        val profileListAdapter = ProfileListAdapter()
        rv.adapter = profileListAdapter
        rv.layoutManager = LinearLayoutManager(context)

        viewModel.allProfiles.observe(viewLifecycleOwner, Observer { profileListAdapter.submitList(it) })

        val button:FloatingActionButton = view.findViewById(R.id.add_button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newProfileFragment)
        }
        return view
    }
}