package com.example.dators.lectureimprovementapp.helpers.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dators.lectureimprovementapp.Course;
import com.example.dators.lectureimprovementapp.Details;
import com.example.dators.lectureimprovementapp.Feedback;
import com.example.dators.lectureimprovementapp.Mark;
import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.Student;
import com.example.dators.lectureimprovementapp.Studies;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "training";
    private static final int DATABASE_VERSION = 1;
    Context context;


    public SQLiteHelper(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
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

    public List<Student> getAllStudentsData(){
        SQLiteDatabase database = getReadableDatabase();
        List<Student> studentsData = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + StudentsTable.TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Student student = new Student();
                    student.setId(cursor.getInt(cursor.getColumnIndex(StudentsTable.UID)));
                    student.setName(cursor.getString(cursor.getColumnIndex(StudentsTable.NAME)));
                    student.setSurname(cursor.getString(cursor.getColumnIndex(StudentsTable.SURNAME)));
                    student.setCourse(cursor.getInt(cursor.getColumnIndex(StudentsTable.COURSE)));
                    student.setGroup(cursor.getInt(cursor.getColumnIndex(StudentsTable.GROUP)));
                    studentsData.add(student);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return studentsData;
    }

    public List<Course> getAllCursesData(){
        SQLiteDatabase database = getReadableDatabase();
        List<Course> courseData = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + CoursesTable.TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Course course = new Course();
                    course.setId(cursor.getInt(cursor.getColumnIndex(CoursesTable.UID)));
                    course.setName(cursor.getString(cursor.getColumnIndex(CoursesTable.NAME)));
                    course.setCreditPoints(cursor.getInt(cursor.getColumnIndex(CoursesTable.CREDIT_POINTS)));
                    course.setLectureHours(cursor.getInt(cursor.getColumnIndex(CoursesTable.LECTURE_HOURS)));
                    courseData.add(course);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return courseData;
    }

    public List<Mark> getAllMarksData(){
        SQLiteDatabase database = getReadableDatabase();
        List<Mark> markData = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + MarksTable.TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Mark mark = new Mark();
                    mark.setId(cursor.getInt(cursor.getColumnIndex(MarksTable.UID)));
                    mark.setStudentId(cursor.getInt(cursor.getColumnIndex(MarksTable.STUDENT_ID)));
                    mark.setCourseId(cursor.getInt(cursor.getColumnIndex(MarksTable.COURSE_ID)));
                    mark.setMark(cursor.getInt(cursor.getColumnIndex(MarksTable.MARK)));
                    mark.setComments(cursor.getString(cursor.getColumnIndex(MarksTable.COMMENTS)));
                    markData.add(mark);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return markData;
    }

    public List<Studies> getAllStudiesData(){
        SQLiteDatabase database = getReadableDatabase();
        List<Studies> studiesData = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + StudiesTable.TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Studies studies = new Studies();
                    studies.setId(cursor.getInt(cursor.getColumnIndex(StudiesTable.UID)));
                    studies.setStudentId(cursor.getInt(cursor.getColumnIndex(StudiesTable.STUDENT_ID)));
                    studies.setCourseId(cursor.getInt(cursor.getColumnIndex(StudiesTable.COURSE_ID)));
                    studiesData.add(studies);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return studiesData;
    }

    public Feedback validateQuery(String query){
        List<Details> details = new ArrayList<>();
        int points = 0;
        if (!query.equals("")) {
            try {
                String lowerCaseQuery = query.toLowerCase();
                Cursor cursor = getReadableDatabase().rawQuery(query, null);
                details.add(new Details(context.getString(R.string.query_successful), true));
                points += 1;
                if (lowerCaseQuery.contains(" group by ")) {
                    details.add(new Details(context.getString(R.string.group_by_included), true));
                    points += 3;
                }
                if (lowerCaseQuery.contains(" order by ")) {
                    details.add(new Details(context.getString(R.string.order_by_included), true));
                    points += 3;
                }
                if (lowerCaseQuery.contains(" where ")) {
                    details.add(new Details(context.getString(R.string.where_included), true));
                    points += 1;
                }

                if (lowerCaseQuery.contains(" and ")) {
                    details.add(new Details(context.getString(R.string.and_included), true));
                    points += 1;
                }

                if (lowerCaseQuery.contains(" count(")) {
                    details.add(new Details(context.getString(R.string.count_included), true));
                    points += 1;
                }

                if (lowerCaseQuery.contains("having ")) {
                    details.add(new Details(context.getString(R.string.having_included), true));
                    points += 1;
                }

                 if (lowerCaseQuery.contains(" or ")) {
                     details.add(new Details(context.getString(R.string.or_included), true));
                     points += 1;
                 }

                if (!(cursor.moveToFirst()) || cursor.getCount() ==0){
                    details.add(new Details(context.getString(R.string.no_value_returned), false));
                    points -=1;
                }

            } catch (SQLException sqle) {
                String message = sqle.getMessage();
                String lowerCaseQuery = query.toLowerCase();
                if (sqle.getMessage().contains("no such table:")) {
                    String comment = String.format(context.getString(R.string.table_does_not_exist),
                            message.substring(message.indexOf("table:") + 7, message.indexOf("(code 1)")-1));
                    details.add(new Details(comment, false));
                }
                if (sqle.getMessage().contains("no such column:")) {
                    String comment = String.format(context.getString(R.string.column_does_not_exist),
                            message.substring(message.indexOf("column:") + 8, message.indexOf("(code 1)")-1));
                    details.add(new Details(comment, false));
                }
                if (sqle.getMessage().contains("syntax error")) {
                    String comment = String.format(context.getString(R.string.syntax_error),
                            message.substring(message.indexOf("near \"") + 6, message.indexOf("\": syntax error")));

                    if (!lowerCaseQuery.contains("select")){
                        comment = comment.concat(context.getString(R.string.select_keyword_missing));
                    }
                    if (!lowerCaseQuery.contains("from")){
                        comment = comment.concat(context.getString(R.string.from_keyword_missing));
                    }
                    details.add(new Details(comment, false));
                }
            }
        } else {
            String comment = context.getString(R.string.query_empty);
            details.add(new Details(comment, false));
        }


        return new Feedback(details, points);
    }

}
