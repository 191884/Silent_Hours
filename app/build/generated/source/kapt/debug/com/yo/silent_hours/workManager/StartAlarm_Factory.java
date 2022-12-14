// Generated by Dagger (https://dagger.dev).
package com.yo.silent_hours.workManager;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class StartAlarm_Factory {
  public StartAlarm_Factory() {
  }

  public StartAlarm get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams);
  }

  public static StartAlarm_Factory create() {
    return new StartAlarm_Factory();
  }

  public static StartAlarm newInstance(Context appContext, WorkerParameters workerParams) {
    return new StartAlarm(appContext, workerParams);
  }
}
