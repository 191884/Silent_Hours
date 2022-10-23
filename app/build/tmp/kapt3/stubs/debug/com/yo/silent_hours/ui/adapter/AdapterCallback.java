package com.yo.silent_hours.ui.adapter;

import com.yo.silent_hours.database.Profile;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/yo/silent_hours/ui/adapter/AdapterCallback;", "", "cancelWorkByTag", "", "tag", "", "openProfileDetails", "profile", "Lcom/yo/silent_hours/database/Profile;", "setAlarms", "startHour", "", "startMinute", "updateItem", "app_debug"})
public abstract interface AdapterCallback {
    
    public abstract void updateItem(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile);
    
    public abstract void openProfileDetails(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile);
    
    public abstract void setAlarms(@org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, int startHour, int startMinute);
    
    public abstract void cancelWorkByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}