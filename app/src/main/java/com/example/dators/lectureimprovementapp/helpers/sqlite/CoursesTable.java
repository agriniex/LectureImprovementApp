package com.example.dators.lectureimprovementapp.helpers.sqlite;


public class CoursesTable {
    public static final String TABLE_NAME = "Prieksmeti";
    public static final String UID = "_id";
    public static final String NAME = "nosaukums";
    public static final String CREDIT_POINTS = "kreditpunkti";
    public static final String LECTURE_HOURS = "macibstundas";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( " + UID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " VARCHAR(255), "
            + CREDIT_POINTS + " INTEGER, "
            + LECTURE_HOURS + " INTEGER "
            + ");";


    public static final String DATA_INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (" +
            NAME + ", " + CREDIT_POINTS + ", " + LECTURE_HOURS +  ") " +
            "VALUES ('Programmēšanas valodas I', '2', '40')," +
            " ('Informācijas sistēmu pārvaldība', '3', '40')," +
            " ('Ievads datoru arhitektūrā', '3', '120')," +
            " ('Datu bāzu pārvaldības sistēmas', '3', '120')," +
            " ('Sistēmu modelēšnas pamati', '2', '80')," +
            " ('Datoru tīkli', '3', '80')" +

            ";";
}
