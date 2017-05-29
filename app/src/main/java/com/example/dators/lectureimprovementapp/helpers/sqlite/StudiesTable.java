package com.example.dators.lectureimprovementapp.helpers.sqlite;


public class StudiesTable {

    public static final String TABLE_NAME = "Apgust";
    public static final String UID = "_id";
    public static final String STUDENT_ID = "students_id";
    public static final String COURSE_ID = "prieksmets_id";
    public static final String START_DATE = "sakuma_datums";
    public static final String END_DATE = "beigu_datums";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( " + UID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + STUDENT_ID + " INTEGER, "
            + COURSE_ID + "  INTEGER, "
            + START_DATE + " INTEGER , "
            + END_DATE + " VARCHAR(255)"
            + ");";


    public static final String DATA_INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (" +
            STUDENT_ID + ", " + COURSE_ID + ", " + START_DATE  + ") " +
            "VALUES (1, 1, datetime())," +
            " (1, 1, datetime())," +
            " (2, 1, datetime())," +
            " (2, 3, datetime()-365)," +
            " (1, 4, datetime()-365)," +
            " (3, 5, datetime()-365)," +
            " (4, 4, datetime()-365)," +
            " (4, 6, datetime())," +
            " (6, 2, datetime()-365)," +
            " (5, 1, datetime())" +
            ";";
}
