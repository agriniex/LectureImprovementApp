package com.example.dators.lectureimprovementapp.helpers.sqlite;


public class StudentsTable {
    public static final String TABLE_NAME = "Studenti";
    public static final String UID = "_id";
    public static final String NAME = "vards";
    public static final String SURNAME = "uzvards";
    public static final String COURSE = "kurss";
    public static final String GROUP = "grupa";

    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + StudentsTable.TABLE_NAME + " ( " + StudentsTable.UID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + StudentsTable.NAME + " VARCHAR(255), "
            + StudentsTable.SURNAME + " VARCHAR(255), "
            + StudentsTable.COURSE + " INTEGER, "
            + StudentsTable.GROUP + " INTEGER"
            + ");";

    public static final String DATA_INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (" +
             NAME + ", " + SURNAME + ", " + COURSE + ", " + GROUP + ") " +
            "VALUES ('Jānis', 'Koks', '1', '3')," +
            " ('Juris', 'Pētersons', '1', '2')," +
            " ('Zane', 'Bērziņa', '2', '1')," +
            " ('Pēteris', 'Liepnieks', '1', '3')," +
            " ('Viktors', 'Korpačovs', '1', '1')," +
            " ('Didzis', 'Kuzmans', '2', '1')," +
            " ('Kristīne', 'Zarina', '2', '2')" +
            ";";

}
