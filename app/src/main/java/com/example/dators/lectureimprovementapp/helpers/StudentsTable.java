package com.example.dators.lectureimprovementapp.helpers;

/**
 * Created by Dators on 2017.05.17..
 */

public class StudentsTable {
    public static final String TABLE_NAME = "Studenti";
    public static final String UID = "_id";
    public static final String NAME = "vards";
    public static final String SURNAME = "uzvards";
    public static final String COURSE = "kurss";
    public static final String GROUP = "grupa";

    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + StudentsTable.TABLE_NAME + " ( " + StudentsTable.UID +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + StudentsTable.NAME + " VARCHAR(255), "
            + StudentsTable.SURNAME + " VARCHAR(255), "
            + StudentsTable.COURSE + " INTEGER, "
            + StudentsTable.GROUP + " INTEGER"
            + ");";

    public static final String DATA_INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (" +
             UID + ", " + NAME + ", " + SURNAME + ", " + COURSE + ", " + GROUP + ") " +
            "VALUES " +
            "";

}
