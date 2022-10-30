package com.yo.silent_hours.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yo.silent_hours.R;
import com.yo.silent_hours.databinding.ChipBinding;
import com.yo.silent_hours.databinding.FragmentDetailsBinding;
import com.yo.silent_hours.databinding.FragmentNewProfileBinding;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\rJ\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\'\u001a\u00020(J\u001a\u0010)\u001a\u00020\u0004*\u00020*2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJZ\u0010-\u001a\u00020\u0004*\u00020\u001626\u0010.\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00040/2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\t\u00a8\u00067"}, d2 = {"Lcom/yo/silent_hours/utils/Utils;", "", "()V", "checkDays", "", "binding", "Lcom/yo/silent_hours/databinding/FragmentNewProfileBinding;", "daySelected", "", "", "createChip", "Lcom/google/android/material/chip/Chip;", "label", "", "layoutInflater", "Landroid/view/LayoutInflater;", "daysList", "", "profileDays", "selectDays", "sendNotification", "applicationContext", "Landroid/content/Context;", "profileName", "state", "pi", "Landroid/app/PendingIntent;", "setTimeString", "i", "", "setupChip", "Lcom/yo/silent_hours/databinding/FragmentDetailsBinding;", "days", "showSnackBar", "it", "Landroid/view/View;", "message", "length", "timeCheck", "calender", "Ljava/util/Calendar;", "setStringFormat", "Landroid/widget/EditText;", "hourText", "minText", "showTimePicker", "onTimeSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "hour", "min", "hourOfDay", "minute", "is24HourViewEnabled", "app_debug"})
public final class Utils {
    @org.jetbrains.annotations.NotNull()
    public static final com.yo.silent_hours.utils.Utils INSTANCE = null;
    
    private Utils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String setTimeString(int i) {
        return null;
    }
    
    public final void showTimePicker(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showTimePicker, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onTimeSelected, int hourOfDay, int minute, boolean is24HourViewEnabled) {
    }
    
    public final void setStringFormat(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setStringFormat, @org.jetbrains.annotations.NotNull()
    java.lang.String hourText, @org.jetbrains.annotations.NotNull()
    java.lang.String minText) {
    }
    
    public final void sendNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext, @org.jetbrains.annotations.NotNull()
    java.lang.String profileName, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    android.app.PendingIntent pi) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Boolean> daysList(@org.jetbrains.annotations.NotNull()
    java.lang.String profileDays) {
        return null;
    }
    
    public final void showSnackBar(@org.jetbrains.annotations.NotNull()
    android.view.View it, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int length) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Boolean> selectDays(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.databinding.FragmentNewProfileBinding binding, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Boolean> daySelected) {
        return null;
    }
    
    public final void checkDays(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.databinding.FragmentNewProfileBinding binding, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Boolean> daySelected) {
    }
    
    public final void setupChip(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.databinding.FragmentDetailsBinding binding, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Boolean> days, @org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater layoutInflater) {
    }
    
    private final com.google.android.material.chip.Chip createChip(java.lang.String label, android.view.LayoutInflater layoutInflater) {
        return null;
    }
    
    public final void timeCheck(@org.jetbrains.annotations.NotNull()
    java.util.Calendar calender) {
    }
}