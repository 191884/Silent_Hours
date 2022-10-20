// Generated by view binder compiler. Do not edit!
package com.yo.silent_hours.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.yo.silent_hours.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemRowBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView ProfileName;

  @NonNull
  public final CardView card;

  @NonNull
  public final RelativeLayout profileCard;

  private ItemRowBinding(@NonNull CardView rootView, @NonNull TextView ProfileName,
      @NonNull CardView card, @NonNull RelativeLayout profileCard) {
    this.rootView = rootView;
    this.ProfileName = ProfileName;
    this.card = card;
    this.profileCard = profileCard;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRowBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ProfileName;
      TextView ProfileName = ViewBindings.findChildViewById(rootView, id);
      if (ProfileName == null) {
        break missingId;
      }

      CardView card = (CardView) rootView;

      id = R.id.profile_card;
      RelativeLayout profileCard = ViewBindings.findChildViewById(rootView, id);
      if (profileCard == null) {
        break missingId;
      }

      return new ItemRowBinding((CardView) rootView, ProfileName, card, profileCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}