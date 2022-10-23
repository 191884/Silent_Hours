package com.yo.silent_hours.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yo.silent_hours.R;

public class MainFragmentDirections {
  private MainFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMainFragmentToNewProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_mainFragment_to_newProfileFragment);
  }

  @NonNull
  public static NavDirections actionMainFragmentToDetailsFragment() {
    return new ActionOnlyNavDirections(R.id.action_mainFragment_to_detailsFragment);
  }
}
