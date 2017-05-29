package com.example.dators.lectureimprovementapp.helpers.sqlite;

public class MarksTable {

    public static final String TABLE_NAME = "Vertejumi";
    public static final String UID = "_id";
    public static final String STUDENT_ID = "students_id";
    public static final String COURSE_ID = "prieksmets_id";
    public static final String MARK = "vertejums";
    public static final String COMMENTS = "komentari";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( " + UID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + STUDENT_ID + " INTEGER, "
            + COURSE_ID + "  INTEGER, "
            + MARK + " INTEGER , "
            + COMMENTS + " VARCHAR(255)"
            + ");";


    public static final String DATA_INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (" +
            STUDENT_ID + ", " + COURSE_ID + ", " + MARK + ", " + COMMENTS + ") " +
            "VALUES (1, 1, 7, 'Labi')," +
            " (1, 1, 7, '')," +
            " (2, 1, 6, '')," +
            " (2, 3, 9, 'Detalizēts un labi strukturēts darbs')," +
            " (1, 4, 6, '')," +
            " (3, 5, 10, 'Apgūtas papildu iemaņas')," +
            " (4, 4, 7, '')," +
            " (4, 6, 9, 'Pilnībā izprot mācību vielu')," +
            " (6, 2, 4, 'Ieteicams atkārtot studiju materiālu')," +
            " (5, 1, 6, '')" +
            ";";
}
