// Generated by view binder compiler. Do not edit!
package com.yo.silent_hours.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.yo.silent_hours.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityNewProfileBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final EditText EndTime;

  @NonNull
  public final TextInputEditText StartTime;

  @NonNull
  public final Chip chip1;

  @NonNull
  public final Chip chip2;

  @NonNull
  public final Chip chip3;

  @NonNull
  public final Chip chip4;

  @NonNull
  public final Chip chip5;

  @NonNull
  public final Chip chip6;

  @NonNull
  public final Chip chip7;

  @NonNull
  public final ChipGroup chipGroup;

  @NonNull
  public final LinearLayout dayLayout;

  @NonNull
  public final Button makeProfileFab;

  @NonNull
  public final SwitchMaterial repeatWeeklySwitch;

  @NonNull
  public final LinearLayout timeLayout;

  @NonNull
  public final TextInputLayout toDoCustomTextInput;

  @NonNull
  public final Toolbar toolBar;

  @NonNull
  public final TextInputEditText userToDoEditText;

  @NonNull
  public final SwitchMaterial vibSwitch;

  private ActivityNewProfileBinding(@NonNull ScrollView rootView, @NonNull EditText EndTime,
      @NonNull TextInputEditText StartTime, @NonNull Chip chip1, @NonNull Chip chip2,
      @NonNull Chip chip3, @NonNull Chip chip4, @NonNull Chip chip5, @NonNull Chip chip6,
      @NonNull Chip chip7, @NonNull ChipGroup chipGroup, @NonNull LinearLayout dayLayout,
      @NonNull Button makeProfileFab, @NonNull SwitchMaterial repeatWeeklySwitch,
      @NonNull LinearLayout timeLayout, @NonNull TextInputLayout toDoCustomTextInput,
      @NonNull Toolbar toolBar, @NonNull TextInputEditText userToDoEditText,
      @NonNull SwitchMaterial vibSwitch) {
    this.rootView = rootView;
    this.EndTime = EndTime;
    this.StartTime = StartTime;
    this.chip1 = chip1;
    this.chip2 = chip2;
    this.chip3 = chip3;
    this.chip4 = chip4;
    this.chip5 = chip5;
    this.chip6 = chip6;
    this.chip7 = chip7;
    this.chipGroup = chipGroup;
    this.dayLayout = dayLayout;
    this.makeProfileFab = makeProfileFab;
    this.repeatWeeklySwitch = repeatWeeklySwitch;
    this.timeLayout = timeLayout;
    this.toDoCustomTextInput = toDoCustomTextInput;
    this.toolBar = toolBar;
    this.userToDoEditText = userToDoEditText;
    this.vibSwitch = vibSwitch;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EndTime;
      EditText EndTime = ViewBindings.findChildViewById(rootView, id);
      if (EndTime == null) {
        break missingId;
      }

      id = R.id.StartTime;
      TextInputEditText StartTime = ViewBindings.findChildViewById(rootView, id);
      if (StartTime == null) {
        break missingId;
      }

      id = R.id.chip1;
      Chip chip1 = ViewBindings.findChildViewById(rootView, id);
      if (chip1 == null) {
        break missingId;
      }

      id = R.id.chip2;
      Chip chip2 = ViewBindings.findChildViewById(rootView, id);
      if (chip2 == null) {
        break missingId;
      }

      id = R.id.chip3;
      Chip chip3 = ViewBindings.findChildViewById(rootView, id);
      if (chip3 == null) {
        break missingId;
      }

      id = R.id.chip4;
      Chip chip4 = ViewBindings.findChildViewById(rootView, id);
      if (chip4 == null) {
        break missingId;
      }

      id = R.id.chip5;
      Chip chip5 = ViewBindings.findChildViewById(rootView, id);
      if (chip5 == null) {
        break missingId;
      }

      id = R.id.chip6;
      Chip chip6 = ViewBindings.findChildViewById(rootView, id);
      if (chip6 == null) {
        break missingId;
      }

      id = R.id.chip7;
      Chip chip7 = ViewBindings.findChildViewById(rootView, id);
      if (chip7 == null) {
        break missingId;
      }

      id = R.id.chipGroup;
      ChipGroup chipGroup = ViewBindings.findChildViewById(rootView, id);
      if (chipGroup == null) {
        break missingId;
      }

      id = R.id.dayLayout;
      LinearLayout dayLayout = ViewBindings.findChildViewById(rootView, id);
      if (dayLayout == null) {
        break missingId;
      }

      id = R.id.makeProfileFab;
      Button makeProfileFab = ViewBindings.findChildViewById(rootView, id);
      if (makeProfileFab == null) {
        break missingId;
      }

      id = R.id.repeatWeeklySwitch;
      SwitchMaterial repeatWeeklySwitch = ViewBindings.findChildViewById(rootView, id);
      if (repeatWeeklySwitch == null) {
        break missingId;
      }

      id = R.id.timeLayout;
      LinearLayout timeLayout = ViewBindings.findChildViewById(rootView, id);
      if (timeLayout == null) {
        break missingId;
      }

      id = R.id.toDoCustomTextInput;
      TextInputLayout toDoCustomTextInput = ViewBindings.findChildViewById(rootView, id);
      if (toDoCustomTextInput == null) {
        break missingId;
      }

      id = R.id.toolBar;
      Toolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      id = R.id.userToDoEditText;
      TextInputEditText userToDoEditText = ViewBindings.findChildViewById(rootView, id);
      if (userToDoEditText == null) {
        break missingId;
      }

      id = R.id.vibSwitch;
      SwitchMaterial vibSwitch = ViewBindings.findChildViewById(rootView, id);
      if (vibSwitch == null) {
        break missingId;
      }

      return new ActivityNewProfileBinding((ScrollView) rootView, EndTime, StartTime, chip1, chip2,
          chip3, chip4, chip5, chip6, chip7, chipGroup, dayLayout, makeProfileFab,
          repeatWeeklySwitch, timeLayout, toDoCustomTextInput, toolBar, userToDoEditText,
          vibSwitch);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
