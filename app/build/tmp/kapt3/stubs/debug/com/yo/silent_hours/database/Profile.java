package com.yo.silent_hours.database;

import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlinx.parcelize.Parcelize;

@androidx.room.Entity(tableName = "profile_table")
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\fH\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\t\u00106\u001a\u00020\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003Jw\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fH\u00c6\u0001J\t\u0010<\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010?H\u00d6\u0003J\t\u0010@\u001a\u00020\u0007H\u00d6\u0001J\t\u0010A\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b\'\u0010!R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!\u00a8\u0006G"}, d2 = {"Lcom/yo/silent_hours/database/Profile;", "Landroid/os/Parcelable;", "profileId", "", "name", "", "shr", "", "smin", "ehr", "emin", "vibSwitch", "", "d", "timeInstance", "repeatWeekly", "pauseSwitch", "(JLjava/lang/String;IIIIZLjava/lang/String;Ljava/lang/String;ZZ)V", "getD", "()Ljava/lang/String;", "setD", "(Ljava/lang/String;)V", "getEhr", "()I", "setEhr", "(I)V", "getEmin", "setEmin", "getName", "setName", "getPauseSwitch", "()Z", "setPauseSwitch", "(Z)V", "getProfileId", "()J", "setProfileId", "(J)V", "getRepeatWeekly", "setRepeatWeekly", "getShr", "setShr", "getSmin", "setSmin", "getTimeInstance", "setTimeInstance", "getVibSwitch", "setVibSwitch", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Profile implements android.os.Parcelable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private long profileId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    private int shr;
    private int smin;
    private int ehr;
    private int emin;
    private boolean vibSwitch;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String d;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String timeInstance;
    private boolean repeatWeekly;
    private boolean pauseSwitch;
    public static final android.os.Parcelable.Creator<com.yo.silent_hours.database.Profile> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.yo.silent_hours.database.Profile copy(long profileId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int shr, int smin, int ehr, int emin, boolean vibSwitch, @org.jetbrains.annotations.NotNull()
    java.lang.String d, @org.jetbrains.annotations.NotNull()
    java.lang.String timeInstance, boolean repeatWeekly, boolean pauseSwitch) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Profile(long profileId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int shr, int smin, int ehr, int emin, boolean vibSwitch, @org.jetbrains.annotations.NotNull()
    java.lang.String d, @org.jetbrains.annotations.NotNull()
    java.lang.String timeInstance, boolean repeatWeekly, boolean pauseSwitch) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getProfileId() {
        return 0L;
    }
    
    public final void setProfileId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getShr() {
        return 0;
    }
    
    public final void setShr(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getSmin() {
        return 0;
    }
    
    public final void setSmin(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getEhr() {
        return 0;
    }
    
    public final void setEhr(int p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getEmin() {
        return 0;
    }
    
    public final void setEmin(int p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getVibSwitch() {
        return false;
    }
    
    public final void setVibSwitch(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getD() {
        return null;
    }
    
    public final void setD(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeInstance() {
        return null;
    }
    
    public final void setTimeInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getRepeatWeekly() {
        return false;
    }
    
    public final void setRepeatWeekly(boolean p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getPauseSwitch() {
        return false;
    }
    
    public final void setPauseSwitch(boolean p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.yo.silent_hours.database.Profile> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.yo.silent_hours.database.Profile createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.yo.silent_hours.database.Profile[] newArray(int size) {
            return null;
        }
    }
}