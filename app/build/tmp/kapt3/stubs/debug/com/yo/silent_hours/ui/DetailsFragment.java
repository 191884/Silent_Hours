package com.yo.silent_hours.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yo.silent_hours.R;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.databinding.FragmentDetailsBinding;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/yo/silent_hours/ui/DetailsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/yo/silent_hours/databinding/FragmentDetailsBinding;", "binding", "getBinding", "()Lcom/yo/silent_hours/databinding/FragmentDetailsBinding;", "profile", "Lcom/yo/silent_hours/database/Profile;", "editProfile", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setTimeString", "", "i", "", "setupUI", "Companion", "app_debug"})
public final class DetailsFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private com.yo.silent_hours.database.Profile profile;
    private com.yo.silent_hours.databinding.FragmentDetailsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.yo.silent_hours.ui.DetailsFragment.Companion Companion = null;
    
    public DetailsFragment() {
        super();
    }
    
    private final com.yo.silent_hours.databinding.FragmentDetailsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.TIRAMISU)
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupUI(com.yo.silent_hours.database.Profile profile) {
    }
    
    private final java.lang.String setTimeString(int i) {
        return null;
    }
    
    private final void editProfile() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/yo/silent_hours/ui/DetailsFragment$Companion;", "", "()V", "newInstance", "Lcom/yo/silent_hours/ui/DetailsFragment;", "args", "Landroid/os/Bundle;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.yo.silent_hours.ui.DetailsFragment newInstance(@org.jetbrains.annotations.NotNull()
        android.os.Bundle args) {
            return null;
        }
    }
}