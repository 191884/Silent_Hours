package com.yo.silent_hours.ui;

import android.app.NotificationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yo.silent_hours.R;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.database.ProfileViewModel;
import com.yo.silent_hours.ui.adapter.AdapterCallback;
import com.yo.silent_hours.ui.adapter.ProfileListAdapter;
import com.yo.silent_hours.utils.SwipeToDeleteCallback;
import com.yo.silent_hours.utils.Utils;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017H\u0002J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"\u00a8\u00063"}, d2 = {"Lcom/yo/silent_hours/ui/MainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterCallback", "Lcom/yo/silent_hours/ui/adapter/AdapterCallback;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "coordLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "setNotificationManager", "(Landroid/app/NotificationManager;)V", "profileListAdapter", "Lcom/yo/silent_hours/ui/adapter/ProfileListAdapter;", "profilesListData", "Ljava/util/ArrayList;", "Lcom/yo/silent_hours/database/Profile;", "Lkotlin/collections/ArrayList;", "swipeToDeleteCallback", "Lcom/yo/silent_hours/utils/SwipeToDeleteCallback;", "getSwipeToDeleteCallback", "()Lcom/yo/silent_hours/utils/SwipeToDeleteCallback;", "swipeToDeleteCallback$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yo/silent_hours/database/ProfileViewModel;", "getViewModel", "()Lcom/yo/silent_hours/database/ProfileViewModel;", "viewModel$delegate", "deleteItem", "", "profile", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "removeItem", "position", "", "restoreItem", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public android.media.AudioManager audioManager;
    @javax.inject.Inject()
    public android.app.NotificationManager notificationManager;
    private final java.util.ArrayList<com.yo.silent_hours.database.Profile> profilesListData = null;
    private com.yo.silent_hours.ui.adapter.ProfileListAdapter profileListAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private androidx.constraintlayout.widget.ConstraintLayout coordLayout;
    private final com.yo.silent_hours.ui.adapter.AdapterCallback adapterCallback = null;
    private final kotlin.Lazy swipeToDeleteCallback$delegate = null;
    
    public MainFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.media.AudioManager getAudioManager() {
        return null;
    }
    
    public final void setAudioManager(@org.jetbrains.annotations.NotNull()
    android.media.AudioManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.NotificationManager getNotificationManager() {
        return null;
    }
    
    public final void setNotificationManager(@org.jetbrains.annotations.NotNull()
    android.app.NotificationManager p0) {
    }
    
    private final com.yo.silent_hours.database.ProfileViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final com.yo.silent_hours.utils.SwipeToDeleteCallback getSwipeToDeleteCallback() {
        return null;
    }
    
    private final void removeItem(int position) {
    }
    
    private final void deleteItem(com.yo.silent_hours.database.Profile profile) {
    }
    
    private final void restoreItem(com.yo.silent_hours.database.Profile profile, int position) {
    }
}