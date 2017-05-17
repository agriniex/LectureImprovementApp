package com.example.dators.lectureimprovementapp.helpers;

public class LecturersTable {

    public static final String TABLE_NAME = "Pasniedzeji";
    public static final String UID = "_id";
    public static final String NAME = "vards";
    public static final String SURNAME = "uzvards";
    public static final String BIRTH_DATE = "dzimsanas_gads";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( " + UID +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " VARCHAR(255), "
            + SURNAME + "  VARCHAR(255), "
            + BIRTH_DATE + " DATETIME"
            + ");";
}
