package com.yo.silent_hours.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.WorkManager;
import com.yo.silent_hours.workManager.WorkManagerHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nR\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/yo/silent_hours/database/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/yo/silent_hours/database/ProfileRepository;", "workManager", "Landroidx/work/WorkManager;", "(Lcom/yo/silent_hours/database/ProfileRepository;Landroidx/work/WorkManager;)V", "allProfiles", "Landroidx/lifecycle/LiveData;", "", "Lcom/yo/silent_hours/database/Profile;", "getAllProfiles", "()Landroidx/lifecycle/LiveData;", "cancelAllWorkByTag", "", "tag", "", "delete", "Lkotlinx/coroutines/Job;", "profile", "insert", "setAlarms", "startHour", "", "startMinute", "update", "app_debug"})
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    private final com.yo.silent_hours.database.ProfileRepository repository = null;
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.yo.silent_hours.database.Profile>> allProfiles = null;
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.ProfileRepository repository, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yo.silent_hours.database.Profile>> getAllProfiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job update(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile) {
        return null;
    }
    
    public final void setAlarms(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, int startHour, int startMinute) {
    }
    
    public final void cancelAllWorkByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
}