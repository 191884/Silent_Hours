package com.yo.silent_hours.ui.adapter;

import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.yo.silent_hours.R;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.utils.Utils;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/yo/silent_hours/database/Profile;", "Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter$ViewHolder;", "adapterCallback", "Lcom/yo/silent_hours/ui/adapter/AdapterCallback;", "(Lcom/yo/silent_hours/ui/adapter/AdapterCallback;)V", "profiles", "Ljava/util/ArrayList;", "getProfiles", "()Ljava/util/ArrayList;", "setProfiles", "(Ljava/util/ArrayList;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_debug"})
public final class ProfileListAdapter extends androidx.recyclerview.widget.ListAdapter<com.yo.silent_hours.database.Profile, com.yo.silent_hours.ui.adapter.ProfileListAdapter.ViewHolder> {
    private final com.yo.silent_hours.ui.adapter.AdapterCallback adapterCallback = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.yo.silent_hours.database.Profile> profiles;
    @org.jetbrains.annotations.NotNull()
    public static final com.yo.silent_hours.ui.adapter.ProfileListAdapter.Companion Companion = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.yo.silent_hours.database.Profile> PROFILE_COMPARATOR = null;
    
    public ProfileListAdapter(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.ui.adapter.AdapterCallback adapterCallback) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.yo.silent_hours.database.Profile> getProfiles() {
        return null;
    }
    
    public final void setProfiles(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.yo.silent_hours.database.Profile> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.yo.silent_hours.ui.adapter.ProfileListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.ui.adapter.ProfileListAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "pauseSwitch", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "profileCard", "Landroid/widget/RelativeLayout;", "profileName", "Landroid/widget/TextView;", "timeStamp", "bind", "", "item", "Lcom/yo/silent_hours/database/Profile;", "adapterCallback", "Lcom/yo/silent_hours/ui/adapter/AdapterCallback;", "Companion", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView profileName = null;
        private final android.widget.TextView timeStamp = null;
        private final android.widget.RelativeLayout profileCard = null;
        private final com.google.android.material.switchmaterial.SwitchMaterial pauseSwitch = null;
        private final androidx.cardview.widget.CardView card = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.yo.silent_hours.ui.adapter.ProfileListAdapter.ViewHolder.Companion Companion = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.yo.silent_hours.database.Profile item, @org.jetbrains.annotations.NotNull()
        com.yo.silent_hours.ui.adapter.AdapterCallback adapterCallback) {
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter$ViewHolder$Companion;", "", "()V", "create", "Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.yo.silent_hours.ui.adapter.ProfileListAdapter.ViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter$Companion;", "", "()V", "PROFILE_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/yo/silent_hours/database/Profile;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}