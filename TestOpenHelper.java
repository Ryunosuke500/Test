package com.example.test_java; //package name

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TestOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "testDB.db"; //db name
    private static final String TABLE_NAME = "test1_table";
    private static final String _ID = "_id";
    private static final String COLUMN_NAME_TITLE = "foo";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    TestOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(
                SQL_CREATE_ENTRIES
        );

        db.execSQL("insert into " + TABLE_NAME + " (" + COLUMN_NAME_TITLE + ")" + " values ('aaa');");
        db.execSQL("insert into " + TABLE_NAME + " (" + COLUMN_NAME_TITLE + ")" + " values ('bbb');");
        db.execSQL("insert into " + TABLE_NAME + " (" + COLUMN_NAME_TITLE + ")" + " values ('ccc');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}