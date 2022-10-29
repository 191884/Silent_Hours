// Generated by Dagger (https://dagger.dev).
package com.yo.silent_hours.database;

import androidx.work.WorkManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<ProfileRepository> repositoryProvider;

  private final Provider<WorkManager> workManagerProvider;

  public ProfileViewModel_Factory(Provider<ProfileRepository> repositoryProvider,
      Provider<WorkManager> workManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.workManagerProvider = workManagerProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(repositoryProvider.get(), workManagerProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<ProfileRepository> repositoryProvider,
      Provider<WorkManager> workManagerProvider) {
    return new ProfileViewModel_Factory(repositoryProvider, workManagerProvider);
  }

  public static ProfileViewModel newInstance(ProfileRepository repository,
      WorkManager workManager) {
    return new ProfileViewModel(repository, workManager);
  }
}