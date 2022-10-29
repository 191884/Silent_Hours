package com.yo.silent_hours.ui;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yo.silent_hours.R;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.database.ProfileViewModel;
import com.yo.silent_hours.databinding.FragmentNewProfileBinding;
import com.yo.silent_hours.utils.Utils;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0017J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020+H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u0007*\u0004\u0018\u00010\"0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\u000b\u001a\u0004\b%\u0010&\u00a8\u00064"}, d2 = {"Lcom/yo/silent_hours/ui/NewProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/yo/silent_hours/databinding/FragmentNewProfileBinding;", "appSharedPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getAppSharedPrefs", "()Landroid/content/SharedPreferences;", "appSharedPrefs$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/yo/silent_hours/databinding/FragmentNewProfileBinding;", "currentTime", "Ljava/util/Calendar;", "daysSelected", "", "", "ehr", "", "emin", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "hour", "minute", "shr", "smin", "type", "Ljava/lang/reflect/Type;", "viewModel", "Lcom/yo/silent_hours/database/ProfileViewModel;", "getViewModel", "()Lcom/yo/silent_hours/database/ProfileViewModel;", "viewModel$delegate", "addProfile", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "validateProfileData", "view", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewProfileFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.google.gson.Gson gson;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.yo.silent_hours.databinding.FragmentNewProfileBinding _binding;
    private final java.lang.reflect.Type type = null;
    private int shr = 0;
    private int smin = 0;
    private int ehr = 0;
    private int emin = 0;
    private java.util.List<java.lang.Boolean> daysSelected;
    private java.util.Calendar currentTime;
    private final int hour = 0;
    private final int minute = 0;
    private final kotlin.Lazy appSharedPrefs$delegate = null;
    
    public NewProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    public final void setGson(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson p0) {
    }
    
    private final com.yo.silent_hours.database.ProfileViewModel getViewModel() {
        return null;
    }
    
    private final com.yo.silent_hours.databinding.FragmentNewProfileBinding getBinding() {
        return null;
    }
    
    private final android.content.SharedPreferences getAppSharedPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.TIRAMISU)
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void validateProfileData(android.view.View view) {
    }
    
    private final void addProfile() {
    }
}