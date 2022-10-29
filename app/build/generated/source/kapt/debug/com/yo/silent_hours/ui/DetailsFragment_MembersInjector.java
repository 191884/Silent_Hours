// Generated by Dagger (https://dagger.dev).
package com.yo.silent_hours.ui;

import com.google.gson.Gson;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DetailsFragment_MembersInjector implements MembersInjector<DetailsFragment> {
  private final Provider<Gson> gsonProvider;

  public DetailsFragment_MembersInjector(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  public static MembersInjector<DetailsFragment> create(Provider<Gson> gsonProvider) {
    return new DetailsFragment_MembersInjector(gsonProvider);
  }

  @Override
  public void injectMembers(DetailsFragment instance) {
    injectGson(instance, gsonProvider.get());
  }

  @InjectedFieldSignature("com.yo.silent_hours.ui.DetailsFragment.gson")
  public static void injectGson(DetailsFragment instance, Gson gson) {
    instance.gson = gson;
  }
}
