package com.yo.silent_hours.utils

import android.app.TimePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yo.silent_hours.R
import com.yo.silent_hours.databinding.ChipBinding
import com.yo.silent_hours.databinding.FragmentDetailsBinding
import com.yo.silent_hours.databinding.FragmentNewProfileBinding

object Utils {

    fun setTimeString(i: Int): String {
        return if (i < 10) {
            "0$i"
        } else {
            "$i"
        }
    }

    fun Context.showTimePicker(
        onTimeSelected: (hour: Int, min: Int) -> Unit,
        hourOfDay: Int,
        minute: Int,
        is24HourViewEnabled: Boolean
    ) = TimePickerDialog(
        this,
        { _, hour, min ->
            onTimeSelected(hour, min)
        }, hourOfDay, minute, is24HourViewEnabled
    ).show()

    fun EditText.setStringFormat(hourText: String, minText: String) {
        setText(
            String.format(
                resources.getString(R.string.Time),
                hourText,
                minText
            )
        )
    }

    fun daysList(profileDays: String): MutableList<Boolean> {
        val type by lazy { object : TypeToken<List<Boolean>>() {}.type }
        val selectedDays by lazy { Gson() }
        return selectedDays.fromJson(profileDays, type)
    }

    fun showSnackBar(it: View, message: String, length: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(it, message, length).show()
    }

    fun selectDays(binding: FragmentNewProfileBinding, daySelected : MutableList<Boolean>): MutableList<Boolean> {
        if(binding.chip1.isChecked) daySelected[0] = true
        if(binding.chip2.isChecked) daySelected[1] = true
        if(binding.chip3.isChecked) daySelected[2] = true
        if(binding.chip4.isChecked) daySelected[3] = true
        if(binding.chip5.isChecked) daySelected[4] = true
        if(binding.chip6.isChecked) daySelected[5] = true
        if(binding.chip7.isChecked) daySelected[6] = true
        return daySelected
    }
    fun checkDays(binding: FragmentNewProfileBinding, daySelected: List<Boolean>){
        if(daySelected[0]) binding.chip1.isChecked = true
        if(daySelected[1]) binding.chip2.isChecked = true
        if(daySelected[2]) binding.chip3.isChecked = true
        if(daySelected[3]) binding.chip4.isChecked = true
        if(daySelected[4]) binding.chip5.isChecked = true
        if(daySelected[5]) binding.chip6.isChecked = true
        if(daySelected[6]) binding.chip7.isChecked = true
    }


    fun setupChip(binding: FragmentDetailsBinding,days: List<Boolean>, layoutInflater: LayoutInflater) {
        if(days[0]) {
            val chip = createChip("Sun", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[1]) {
            val chip = createChip("Mon", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[2]) {
            val chip = createChip("Tues", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[3]) {
            val chip = createChip("Wed", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[4]) {
            val chip = createChip("Thr", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[5]) {
            val chip = createChip("Fri", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }
        if(days[6]) {
            val chip = createChip("Sat", layoutInflater)
            binding.dayPicker.addView(chip)
            binding.dayPicker.addView(chip)
        }

    }

    private fun createChip(label: String, layoutInflater: LayoutInflater): Chip {
        val chip = ChipBinding.inflate(layoutInflater).root
        chip.text = label
        return chip
    }

}