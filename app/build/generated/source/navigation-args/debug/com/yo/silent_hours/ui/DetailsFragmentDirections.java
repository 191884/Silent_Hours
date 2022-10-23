package com.yo.silent_hours.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yo.silent_hours.R;

public class DetailsFragmentDirections {
  private DetailsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDetailsFragmentToMainFragment() {
    return new ActionOnlyNavDirections(R.id.action_detailsFragment_to_mainFragment);
  }
}
