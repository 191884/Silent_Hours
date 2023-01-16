package com.snappy.silenthours.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.snappy.silenthours.R
import com.snappy.silenthours.database.ProfileViewModel
import com.snappy.silenthours.databinding.FragmentTimeTableBinding
import com.snappy.silenthours.utils.Utils.showSnackBar
import com.snappy.silenthours.utils.Utils.withEditText
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class TimeTableFragment : Fragment(), View.OnClickListener {

    @Inject
    lateinit var gson: Gson


    private val viewModel: ProfileViewModel by viewModels()
    private val type = object : TypeToken<List<Boolean>>() {}.type
    private var shr = 0
    private var smin = 0
    private var ehr = 0
    private var emin = 0
    private var daysSelected: MutableList<Boolean> = arrayListOf(false, false, false, false, false, false, false)
    private var currentTime = Calendar.getInstance()

    private lateinit var linearLayout: LinearLayout

    private var _binding: FragmentTimeTableBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTimeTableBinding.inflate(inflater, container, false)
//        timeTableClickHandler(binding,layoutInflater,requireContext())
        linearLayout = binding.LinearLayout

        binding.Mon910.setOnClickListener(this)
        binding.Mon1011.setOnClickListener(this)
        binding.Mon1112.setOnClickListener(this)
        binding.Mon121.setOnClickListener(this)
        binding.Mon12.setOnClickListener(this)
        binding.Mon23.setOnClickListener(this)
        binding.Mon34.setOnClickListener(this)
        binding.Mon45.setOnClickListener(this)

        binding.Tues910.setOnClickListener(this)
        binding.Tues1011.setOnClickListener(this)
        binding.Tues1112.setOnClickListener(this)
        binding.Tues121.setOnClickListener(this)
        binding.Tues12.setOnClickListener(this)
        binding.Tues23.setOnClickListener(this)
        binding.Tues34.setOnClickListener(this)
        binding.Tues45.setOnClickListener(this)

        binding.Wed910.setOnClickListener(this)
        binding.Wed1011.setOnClickListener(this)
        binding.Wed1112.setOnClickListener(this)
        binding.Wed121.setOnClickListener(this)
        binding.Wed12.setOnClickListener(this)
        binding.Wed23.setOnClickListener(this)
        binding.Wed34.setOnClickListener(this)
        binding.Wed45.setOnClickListener(this)

        binding.Thu910.setOnClickListener(this)
        binding.Thu1011.setOnClickListener(this)
        binding.Thu1112.setOnClickListener(this)
        binding.Thu121.setOnClickListener(this)
        binding.Thu12.setOnClickListener(this)
        binding.Thu23.setOnClickListener(this)
        binding.Thu34.setOnClickListener(this)
        binding.Thu45.setOnClickListener(this)

        binding.Fri910.setOnClickListener(this)
        binding.Fri1011.setOnClickListener(this)
        binding.Fri1112.setOnClickListener(this)
        binding.Fri121.setOnClickListener(this)
        binding.Fri12.setOnClickListener(this)
        binding.Fri23.setOnClickListener(this)
        binding.Fri34.setOnClickListener(this)
        binding.Fri45.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.Mon9_10 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon910, binding.LinearLayout,layoutInflater,requireContext(),9, 10, d, viewModel)
            }
            R.id.Mon10_11 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Mon11_12 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Mon12_1 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon121, binding.LinearLayout,layoutInflater,requireContext(),12, 13, d, viewModel)
            }
            R.id.Mon1_2 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon12, binding.LinearLayout,layoutInflater,requireContext(),13, 14, d, viewModel)
            }
            R.id.Mon2_3 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon23, binding.LinearLayout,layoutInflater,requireContext(),14, 15, d, viewModel)
            }
            R.id.Mon3_4 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon34, binding.LinearLayout,layoutInflater,requireContext(),15, 16, d, viewModel)
            }
            R.id.Mon4_5 -> {
                daysSelected[1] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Mon45, binding.LinearLayout,layoutInflater,requireContext(),16, 17, d, viewModel)
            }



            R.id.Tues9_10 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues910, binding.LinearLayout,layoutInflater,requireContext(),9, 10, d, viewModel)
            }
            R.id.Tues10_11 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Tues11_12 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Tues12_1 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues121, binding.LinearLayout,layoutInflater,requireContext(),12, 13, d, viewModel)
            }
            R.id.Tues1_2 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues12, binding.LinearLayout,layoutInflater,requireContext(),13, 14, d, viewModel)
            }
            R.id.Tues2_3 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues23, binding.LinearLayout,layoutInflater,requireContext(),14, 15, d, viewModel)
            }
            R.id.Tues3_4 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues34, binding.LinearLayout,layoutInflater,requireContext(),15, 16, d, viewModel)
            }
            R.id.Tues4_5 -> {
                daysSelected[2] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Tues45, binding.LinearLayout,layoutInflater,requireContext(),16, 17, d, viewModel)
            }



            R.id.Wed9_10 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed910, binding.LinearLayout,layoutInflater,requireContext(),9, 10, d, viewModel)
            }
            R.id.Wed10_11 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Wed11_12 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Wed12_1 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed121, binding.LinearLayout,layoutInflater,requireContext(),12, 13, d, viewModel)
            }
            R.id.Wed1_2 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed12, binding.LinearLayout,layoutInflater,requireContext(),13, 14, d, viewModel)
            }
            R.id.Wed2_3 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed23, binding.LinearLayout,layoutInflater,requireContext(),14, 15, d, viewModel)
            }
            R.id.Wed3_4 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed34, binding.LinearLayout,layoutInflater,requireContext(),15, 16, d, viewModel)
            }
            R.id.Wed4_5 -> {
                daysSelected[3] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Wed45, binding.LinearLayout,layoutInflater,requireContext(),16, 17, d, viewModel)
            }


            R.id.Thu9_10 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu910, binding.LinearLayout,layoutInflater,requireContext(),9, 10, d, viewModel)
            }
            R.id.Thu10_11 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Thu11_12 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Thu12_1 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu121, binding.LinearLayout,layoutInflater,requireContext(),12, 13, d, viewModel)
            }
            R.id.Thu1_2 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu12, binding.LinearLayout,layoutInflater,requireContext(),13, 14, d, viewModel)
            }
            R.id.Thu2_3 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu23, binding.LinearLayout,layoutInflater,requireContext(),14, 15, d, viewModel)
            }
            R.id.Thu3_4 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu34, binding.LinearLayout,layoutInflater,requireContext(),15, 16, d, viewModel)
            }
            R.id.Thu4_5 -> {
                daysSelected[4] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Thu45, binding.LinearLayout,layoutInflater,requireContext(),16, 17, d, viewModel)
            }



            R.id.Fri9_10 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri910, binding.LinearLayout,layoutInflater,requireContext(),9, 10, d, viewModel)
            }
            R.id.Fri10_11 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Fri11_12 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri1011, binding.LinearLayout,layoutInflater,requireContext(),10, 11, d, viewModel)
            }
            R.id.Fri12_1 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri121, binding.LinearLayout,layoutInflater,requireContext(),12, 13, d, viewModel)
            }
            R.id.Fri1_2 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri12, binding.LinearLayout,layoutInflater,requireContext(),13, 14, d, viewModel)
            }
            R.id.Fri2_3 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri23, binding.LinearLayout,layoutInflater,requireContext(),14, 15, d, viewModel)
            }
            R.id.Fri3_4 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri34, binding.LinearLayout,layoutInflater,requireContext(),15, 16, d, viewModel)
            }
            R.id.Fri4_5 -> {
                daysSelected[5] =true
                var d: String = gson.toJson(daysSelected)
                withEditText(binding.Fri45, binding.LinearLayout,layoutInflater,requireContext(),16, 17, d, viewModel)
            }
            else ->{
                showSnackBar(linearLayout,
                    "Profile is removed from the list.",
                    Snackbar.LENGTH_LONG)
            }
        }
    }
}