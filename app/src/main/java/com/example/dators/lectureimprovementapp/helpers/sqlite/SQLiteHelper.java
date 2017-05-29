package com.example.dators.lectureimprovementapp.helpers.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "training";
    private static final int DATABASE_VERSION = 1;


    public SQLiteHelper(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentsTable.TABLE_CREATE_QUERY);
        db.execSQL(CoursesTable.TABLE_CREATE_QUERY);
        db.execSQL(MarksTable.TABLE_CREATE_QUERY);
        db.execSQL(StudiesTable.TABLE_CREATE_QUERY);

        db.execSQL(StudentsTable.DATA_INSERT_QUERY);
        db.execSQL(CoursesTable.DATA_INSERT_QUERY);
        db.execSQL(MarksTable.DATA_INSERT_QUERY);
        db.execSQL(StudiesTable.DATA_INSERT_QUERY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DATABASE", "Upgrading database from version " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + CoursesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + StudentsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MarksTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + StudiesTable.TABLE_NAME);
        onCreate(db);
    }
}
