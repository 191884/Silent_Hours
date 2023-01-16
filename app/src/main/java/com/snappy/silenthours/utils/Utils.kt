package com.snappy.silenthours.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.snappy.silenthours.R
import com.snappy.silenthours.database.Profile
import com.snappy.silenthours.database.ProfileViewModel
import com.snappy.silenthours.databinding.ChipBinding
import com.snappy.silenthours.databinding.FragmentDetailsBinding
import com.snappy.silenthours.databinding.FragmentNewProfileBinding
import com.snappy.silenthours.ui.ReminderFragment
import java.text.SimpleDateFormat
import java.util.*

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

    fun sendNotification(
        applicationContext: Context,
        profileName: String,
        state: String,
        pi: PendingIntent
    ) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(applicationContext, "422")
            .setSmallIcon(R.drawable.app_icon)
            .setColor(Color.rgb(30, 136, 229))
            .setContentTitle("Profile $state")
            .setContentText("$profileName profile has $state")
            .setAutoCancel(true)
            .setContentIntent(pi)
            .build()
        notificationManager.notify(1112, notification)
    }

    fun sendReminder(
        applicationContext: Context,
        profileName: String,
        profileText: String,
        pi: PendingIntent
    ) {
        Log.e("Reminder Function", "Reached")
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(applicationContext, "422")
            .setSmallIcon(R.drawable.ic_notifications_off)
            .setColor(Color.rgb(30, 136, 229))
            .setContentTitle(profileName)
            .setContentText(profileText)
            .setAutoCancel(true)
            .setContentIntent(pi)
            .build()
        notificationManager.notify(1112, notification)
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


    fun setupChip(binding: FragmentDetailsBinding, days: List<Boolean>, layoutInflater: LayoutInflater) {
        if(days[0]) {
            val chip = createChip("Sun", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[1]) {
            val chip = createChip("Mon", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[2]) {
            val chip = createChip("Tues", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[3]) {
            val chip = createChip("Wed", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[4]) {
            val chip = createChip("Thr", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[5]) {
            val chip = createChip("Fri", layoutInflater)
            binding.dayPicker.addView(chip)
        }
        if(days[6]) {
            val chip = createChip("Sat", layoutInflater)
            binding.dayPicker.addView(chip)
        }

    }

    private fun createChip(label: String, layoutInflater: LayoutInflater): Chip {
        val chip = ChipBinding.inflate(layoutInflater).root
        chip.text = label
        return chip
    }

    fun timeCheck(calender: Calendar) {
        if (calender.timeInMillis < System.currentTimeMillis()) {
            calender.add(Calendar.DAY_OF_YEAR, 7)
        }
    }

//    fun timeTableClickHandler(binding: FragmentTimeTableBinding, layoutInflater: LayoutInflater, context: Context){
//
//        binding.Mon910.setOnClickListener {
//            withEditText(binding.Mon910, layoutInflater,context)
//        }
//        binding.Mon910.setOnClickListener {
//            withEditText(binding.Mon910, layoutInflater,context)
//        }
//    }

    fun withEditText(className: TextView, linearLayout: LinearLayout, layoutInflater: LayoutInflater, context: Context, shr: Int, ehr: Int, d: String, viewModel: ProfileViewModel) {
        val builder = AlertDialog.Builder(context)
        val inflater = layoutInflater
        builder.setTitle("Your Class")
        val dialogLayout = inflater.inflate(R.layout.custom_dialog, null)
        val switch = dialogLayout.findViewById<SwitchMaterial>(R.id.switchOnOff)

        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i ->
            if(switch.isChecked)
                className.setBackgroundColor(Color.GREEN)
            else
                className.setBackgroundColor(Color.TRANSPARENT)
            val currentTime =
                SimpleDateFormat("EEE, d MMM yyyy hh:mm", Locale.getDefault()).format(Date())
            val profile = Profile(name = className.text.toString(),
                shr = shr,
                smin = "00".toInt(),
                ehr = ehr,
                emin = "00".toInt(),
                vibSwitch = true,
                d = d,
                repeatWeekly = true,
                pauseSwitch = switch.isChecked,
                timeInstance = currentTime
            )
            if(switch.isChecked){
                profile.profileId = className.id.toLong()
                viewModel.insert(profile)
            }
            else {
                viewModel.delete(profile)
                showSnackBar(
                    linearLayout,
                    "Profile is removed from the list.",
                    Snackbar.LENGTH_LONG
                )
            }
        }
        builder.show()
    }
}