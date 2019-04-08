package com.sevafoundation.syncapp.sqlite;

public class SqliteTable {


    public static final String TABLE_NAME = "names";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STATUS = "status";

  public static String sql = "CREATE TABLE " + TABLE_NAME
            + "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME +
            " VARCHAR, " + COLUMN_STATUS +
            " TINYINT);";
}
