package com.yo.silent_hours.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProfileDAO_Impl implements ProfileDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Profile> __insertionAdapterOfProfile;

  private final EntityDeletionOrUpdateAdapter<Profile> __deletionAdapterOfProfile;

  private final EntityDeletionOrUpdateAdapter<Profile> __updateAdapterOfProfile;

  public ProfileDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProfile = new EntityInsertionAdapter<Profile>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `profile_table` (`profileId`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Profile value) {
        stmt.bindLong(1, value.getProfileId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__deletionAdapterOfProfile = new EntityDeletionOrUpdateAdapter<Profile>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `profile_table` WHERE `profileId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Profile value) {
        stmt.bindLong(1, value.getProfileId());
      }
    };
    this.__updateAdapterOfProfile = new EntityDeletionOrUpdateAdapter<Profile>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `profile_table` SET `profileId` = ?,`name` = ? WHERE `profileId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Profile value) {
        stmt.bindLong(1, value.getProfileId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getProfileId());
      }
    };
  }

  @Override
  public Object insertProfile(final Profile profiles,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProfile.insert(profiles);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteProfile(final Profile profiles,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfProfile.handle(profiles);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateProfile(final Profile profiles,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfProfile.handle(profiles);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Profile>> getAllProfile() {
    final String _sql = "SELECT * FROM profile_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"profile_table"}, false, new Callable<List<Profile>>() {
      @Override
      public List<Profile> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProfileId = CursorUtil.getColumnIndexOrThrow(_cursor, "profileId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final List<Profile> _result = new ArrayList<Profile>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Profile _item;
            final long _tmpProfileId;
            _tmpProfileId = _cursor.getLong(_cursorIndexOfProfileId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item = new Profile(_tmpProfileId,_tmpName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}