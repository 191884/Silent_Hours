package com.yo.silent_hours.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yo.silent_hours.R;

public class NewProfileFragmentDirections {
  private NewProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionNewProfileFragmentToMainFragment() {
    return new ActionOnlyNavDirections(R.id.action_newProfileFragment_to_mainFragment);
  }
}
