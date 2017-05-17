package com.example.dators.lectureimprovementapp.helpers;


public class CoursesTable {
    public static final String TABLE_NAME = "Prieksmeti";
    public static final String UID = "_id";
    public static final String NAME = "nosaukums";
    public static final String CREDIT_POINTS = "kreditpunkti";
    public static final String LECTURE_HOURS = "macibstundas";
    public static final String LECTURER_ID = "lektors_id";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( " + UID +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " VARCHAR(255), "
            + CREDIT_POINTS + " INTEGER, "
            + LECTURE_HOURS + " INTEGER, "
            + LECTURER_ID + " INTEGER"
            + ");";
}
