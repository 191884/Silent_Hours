package com.yo.silent_hours.database;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.database.ProfileDAO;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/yo/silent_hours/database/ProfileRepository;", "", "profileDAO", "Lcom/yo/silent_hours/database/ProfileDAO;", "(Lcom/yo/silent_hours/database/ProfileDAO;)V", "allProfiles", "Landroidx/lifecycle/LiveData;", "", "Lcom/yo/silent_hours/database/Profile;", "getAllProfiles", "()Landroidx/lifecycle/LiveData;", "delete", "", "profile", "(Lcom/yo/silent_hours/database/Profile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "update", "app_debug"})
public final class ProfileRepository {
    private final com.yo.silent_hours.database.ProfileDAO profileDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.yo.silent_hours.database.Profile>> allProfiles = null;
    
    public ProfileRepository(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.ProfileDAO profileDAO) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yo.silent_hours.database.Profile>> getAllProfiles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}