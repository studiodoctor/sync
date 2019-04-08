package com.sevafoundation.syncapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import static com.sevafoundation.syncapp.sqlite.SqliteTable.COLUMN_NAME;
import static com.sevafoundation.syncapp.sqlite.SqliteTable.COLUMN_STATUS;
import static com.sevafoundation.syncapp.sqlite.SqliteTable.TABLE_NAME;

public class SqliteController {

    private SqliteHelper sqliteHelper;
    Context context;

    public SqliteController(Context mContext) {
        this.context = mContext;
        sqliteHelper = new SqliteHelper(context);
    }

    public boolean addName(String name, int status) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_STATUS, status);

        return sqliteHelper.addName(TABLE_NAME, contentValues);
    }

    public boolean updateNameStatus(int id, int status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, status);
        return sqliteHelper.updateNameStatus(id, TABLE_NAME, contentValues);
    }

    public Cursor getNames() {
        return sqliteHelper.getNames();
    }

    public Cursor getUnsyncedNames() {
        return sqliteHelper.getUnsyncedNames();
    }

}
