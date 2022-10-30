package com.yo.silent_hours.workManager;

import android.util.Log;
import androidx.work.*;
import com.yo.silent_hours.database.Profile;
import com.yo.silent_hours.utils.Utils;
import java.util.*;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJE\u0010\u000f\u001a\u00020\n\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0018H\u0082\bJ&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ \u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/yo/silent_hours/workManager/WorkManagerHelper;", "", "()V", "calender", "Ljava/util/Calendar;", "getCalender", "()Ljava/util/Calendar;", "calender$delegate", "Lkotlin/Lazy;", "cancelWork", "", "workManager", "Landroidx/work/WorkManager;", "tag", "", "setAlarmRequest", "T", "Landroidx/work/ListenableWorker;", "profile", "Lcom/yo/silent_hours/database/Profile;", "profileData", "Landroidx/work/Data;", "c", "alarmClass", "Ljava/lang/Class;", "setAlarms", "startHour", "", "startMinute", "setEndAlarm", "dayOfWeek", "setStartAlarm", "app_debug"})
public final class WorkManagerHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.yo.silent_hours.workManager.WorkManagerHelper INSTANCE = null;
    private static final kotlin.Lazy calender$delegate = null;
    
    private WorkManagerHelper() {
        super();
    }
    
    private final java.util.Calendar getCalender() {
        return null;
    }
    
    public final void setAlarms(@org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager, @org.jetbrains.annotations.NotNull()
    com.yo.silent_hours.database.Profile profile, int startHour, int startMinute) {
    }
    
    private final void setStartAlarm(androidx.work.WorkManager workManager, int dayOfWeek, com.yo.silent_hours.database.Profile profile, int startHour, int startMinute) {
    }
    
    private final void setEndAlarm(androidx.work.WorkManager workManager, int dayOfWeek, com.yo.silent_hours.database.Profile profile) {
    }
    
    public final void cancelWork(@org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
}