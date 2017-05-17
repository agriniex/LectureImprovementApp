package com.example.dators.lectureimprovementapp.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "training";
    private static final int DATABASE_VERSION = 1;


    SQLiteHelper(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentsTable.TABLE_CREATE_QUERY);
        db.execSQL(CoursesTable.TABLE_CREATE_QUERY);
        db.execSQL(LecturersTable.TABLE_CREATE_QUERY);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DATABASE", "Upgrading database from version " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + CoursesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + StudentsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LecturersTable.TABLE_NAME);
        onCreate(db);
    }
}
