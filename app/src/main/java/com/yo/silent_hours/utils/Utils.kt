package com.yo.silent_hours.utils

import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.yo.silent_hours.R
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

    fun showSnackBar(it: View, message: String, length: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(it, message, length).show()
    }

    fun selectDays(binding: FragmentNewProfileBinding, daySelected : MutableList<String>): MutableList<String> {
        if(binding.chip1.isChecked)
            daySelected.add("SUNDAY")
        if(binding.chip2.isChecked)
            daySelected.add("MONDAY")
        if(binding.chip3.isChecked)
            daySelected.add("TUESDAY")
        if(binding.chip4.isChecked)
            daySelected.add("WEDNESDAY")
        if(binding.chip5.isChecked)
            daySelected.add("THURSDAY")
        if(binding.chip6.isChecked)
            daySelected.add("FRIDAY")
        if(binding.chip7.isChecked)
            daySelected.add("SATURDAY")

        return daySelected
    }

}