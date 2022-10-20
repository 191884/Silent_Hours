package com.yo.silent_hours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.yo.silent_hours.database.Profile
import com.yo.silent_hours.database.ProfileViewModel
import com.yo.silent_hours.database.ProfileViewModelFactory
import com.yo.silent_hours.database.QuiteApplication
import kotlinx.coroutines.NonDisposableHandle.parent

class NewProfileFragment() : Fragment() {

    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((activity?.application as QuiteApplication).repository)
    }
//    private var _binding: FragmentNewProfileBinding? = null
//    private val binding
//        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//         FragmentNewProfileBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_new_profile, container, false)
//        val toolBar : Toolbar = view.findViewById(R.id.toolBar)
//        toolBar.setNavigationOnClickListener { requireActivity().onBackPressed() }

        val makeProfileFab = view.findViewById<Button>(R.id.makeProfileFab)
        val NameInput = view.findViewById<TextInputEditText>(R.id.NameInput)
        makeProfileFab.setOnClickListener{
            val profile = Profile(name = NameInput.text.toString(), timeInstance = "Yo!!")
            Toast.makeText(
                parentFragment?.context,
                "Adding Name",
                Toast.LENGTH_LONG
            ).show()
            viewModel.insert(profile)
            Navigation.findNavController(view)
                .navigate(R.id.action_newProfileFragment_to_mainFragment)
        }

//        return binding.root
        return view

    }
}
