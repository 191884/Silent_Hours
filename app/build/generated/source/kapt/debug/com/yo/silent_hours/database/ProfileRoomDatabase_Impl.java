package com.yo.silent_hours.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProfileRoomDatabase_Impl extends ProfileRoomDatabase {
  private volatile ProfileDAO _profileDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `profile_table` (`profileId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `shr` INTEGER NOT NULL, `smin` INTEGER NOT NULL, `ehr` INTEGER NOT NULL, `emin` INTEGER NOT NULL, `vibSwitch` INTEGER NOT NULL, `d` TEXT NOT NULL, `timeInstance` TEXT NOT NULL, `repeatWeekly` INTEGER NOT NULL, `pauseSwitch` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7ad1bec7f9f2071aa6769f73e05d8f43')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `profile_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProfileTable = new HashMap<String, TableInfo.Column>(11);
        _columnsProfileTable.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("shr", new TableInfo.Column("shr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("smin", new TableInfo.Column("smin", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("ehr", new TableInfo.Column("ehr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("emin", new TableInfo.Column("emin", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("vibSwitch", new TableInfo.Column("vibSwitch", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("d", new TableInfo.Column("d", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("timeInstance", new TableInfo.Column("timeInstance", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("repeatWeekly", new TableInfo.Column("repeatWeekly", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfileTable.put("pauseSwitch", new TableInfo.Column("pauseSwitch", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProfileTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProfileTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProfileTable = new TableInfo("profile_table", _columnsProfileTable, _foreignKeysProfileTable, _indicesProfileTable);
        final TableInfo _existingProfileTable = TableInfo.read(_db, "profile_table");
        if (! _infoProfileTable.equals(_existingProfileTable)) {
          return new RoomOpenHelper.ValidationResult(false, "profile_table(com.yo.silent_hours.database.Profile).\n"
                  + " Expected:\n" + _infoProfileTable + "\n"
                  + " Found:\n" + _existingProfileTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7ad1bec7f9f2071aa6769f73e05d8f43", "9354b422926d571bd6eca1c2c327747c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "profile_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `profile_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProfileDAO.class, ProfileDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ProfileDAO profileDao() {
    if (_profileDAO != null) {
      return _profileDAO;
    } else {
      synchronized(this) {
        if(_profileDAO == null) {
          _profileDAO = new ProfileDAO_Impl(this);
        }
        return _profileDAO;
      }
    }
  }
}
