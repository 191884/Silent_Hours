package com.yo.silent_hours.database;

import java.lang.System;

@androidx.room.Entity(tableName = "profile_table")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0007H\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\fH\u00c6\u0003Jm\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u00c6\u0001J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\u0007H\u00d6\u0001J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001e\u00a8\u0006<"}, d2 = {"Lcom/yo/silent_hours/database/Profile;", "", "profileId", "", "name", "", "shr", "", "smin", "ehr", "emin", "vibSwitch", "", "timeInstance", "repeatWeekly", "pauseSwitch", "(JLjava/lang/String;IIIIZLjava/lang/String;ZZ)V", "getEhr", "()I", "setEhr", "(I)V", "getEmin", "setEmin", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPauseSwitch", "()Z", "setPauseSwitch", "(Z)V", "getProfileId", "()J", "setProfileId", "(J)V", "getRepeatWeekly", "setRepeatWeekly", "getShr", "setShr", "getSmin", "setSmin", "getTimeInstance", "setTimeInstance", "getVibSwitch", "setVibSwitch", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Profile {
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
    private java.lang.String timeInstance;
    private boolean repeatWeekly;
    private boolean pauseSwitch;
    
    @org.jetbrains.annotations.NotNull()
    public final com.yo.silent_hours.database.Profile copy(long profileId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int shr, int smin, int ehr, int emin, boolean vibSwitch, @org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getTimeInstance() {
        return null;
    }
    
    public final void setTimeInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getRepeatWeekly() {
        return false;
    }
    
    public final void setRepeatWeekly(boolean p0) {
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getPauseSwitch() {
        return false;
    }
    
    public final void setPauseSwitch(boolean p0) {
    }
}