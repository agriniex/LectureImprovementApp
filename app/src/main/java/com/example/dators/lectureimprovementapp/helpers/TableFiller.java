package com.example.dators.lectureimprovementapp.helpers;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.dators.lectureimprovementapp.Course;
import com.example.dators.lectureimprovementapp.Mark;
import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.Student;
import com.example.dators.lectureimprovementapp.Studies;
import com.example.dators.lectureimprovementapp.helpers.sqlite.CoursesTable;
import com.example.dators.lectureimprovementapp.helpers.sqlite.MarksTable;
import com.example.dators.lectureimprovementapp.helpers.sqlite.SQLiteHelper;
import com.example.dators.lectureimprovementapp.helpers.sqlite.StudentsTable;
import com.example.dators.lectureimprovementapp.helpers.sqlite.StudiesTable;

import java.util.ArrayList;
import java.util.List;

public class TableFiller {

    View view;

    public TableFiller(View view){
        this.view = view;
    }



    public void fillTable(int section){
        String tableName;
        SQLiteHelper sqLiteHelper = new SQLiteHelper(view.getContext());
        TableLayout layout = (TableLayout) view.findViewById(R.id.table_container);
        List<String> columns = new ArrayList<>();
        TableRow tableRow = new TableRow(view.getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        switch (section) {
            case 1:
                columns.add(StudentsTable.UID);
                columns.add(StudentsTable.NAME);
                columns.add(StudentsTable.SURNAME);
                columns.add(StudentsTable.GROUP);
                columns.add(StudentsTable.COURSE);
                break;
            case 2:
                columns.add(StudiesTable.UID);
                columns.add(StudiesTable.STUDENT_ID);
                columns.add(StudiesTable.COURSE_ID);
                columns.add(StudiesTable.START_DATE);
                columns.add(StudiesTable.END_DATE);
                break;
            case 3:
                columns.add(CoursesTable.UID);
                columns.add(CoursesTable.NAME);
                columns.add(CoursesTable.CREDIT_POINTS);
                columns.add(CoursesTable.LECTURE_HOURS);
                break;
            case 4:
                columns.add(MarksTable.UID);
                columns.add(MarksTable.STUDENT_ID);
                columns.add(MarksTable.COURSE_ID);
                columns.add(MarksTable.MARK);
                columns.add(MarksTable.COMMENTS);
                break;
        }


        for (String column: columns
                ) {
            TextView textView = new TextView(view.getContext());
            textView.setText(column);
            textView.setTextSize(15);
            textView.setPadding(10,5, 10,5);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            tableRow.addView(textView);
        }
        layout.addView(tableRow);

        switch (section) {
            case 1:
                List<Student> students = sqLiteHelper.getAllStudentsData();
                for (Student student: students
                     ) {
                    TableRow contentRow = new TableRow(view.getContext());
                    tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tv1 = new TextView(view.getContext());
                    tv1.setText(Integer.toString(student.getId()));
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv1);

                    TextView tv2 = new TextView(view.getContext());
                    tv2.setText(student.getName());
                    tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv2);

                    TextView tv3 = new TextView(view.getContext());
                    tv3.setText(student.getSurname());
                    tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv3);

                    TextView tv4 = new TextView(view.getContext());
                    tv4.setText(Integer.toString(student.getGroup()));
                    tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv4);

                    TextView tv5 = new TextView(view.getContext());
                    tv5.setText(Integer.toString(student.getCourse()));
                    tv5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv5);

                    layout.addView(contentRow);
                }
                break;
            case 2:
                List<Studies> studies = sqLiteHelper.getAllStudiesData();
                for (Studies study: studies
                        ) {
                    TableRow contentRow = new TableRow(view.getContext());
                    tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tv1 = new TextView(view.getContext());
                    tv1.setText(Integer.toString(study.getId()));
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv1);

                    TextView tv2 = new TextView(view.getContext());
                    tv2.setText(Integer.toString(study.getStudentId()));
                    tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv2);

                    TextView tv3 = new TextView(view.getContext());
                    tv3.setText(Integer.toString(study.getCourseId()));
                    tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv3);

                    TextView tv4 = new TextView(view.getContext());
                    tv4.setText("");
                    tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv4);

                    TextView tv5 = new TextView(view.getContext());
                    tv5.setText("");
                    tv5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv5);

                    layout.addView(contentRow);
                }
                break;
            case 3:
                List<Course> courses = sqLiteHelper.getAllCursesData();
                for (Course course: courses
                        ) {
                    TableRow contentRow = new TableRow(view.getContext());
                    tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tv1 = new TextView(view.getContext());
                    tv1.setText(Integer.toString(course.getId()));
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv1);

                    TextView tv2 = new TextView(view.getContext());
                    tv2.setText(course.getName());
                    tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv2);

                    TextView tv3 = new TextView(view.getContext());
                    tv3.setText(Integer.toString(course.getCreditPoints()));
                    tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv3);

                    TextView tv4 = new TextView(view.getContext());
                    tv4.setText(Integer.toString(course.getLectureHours()));
                    tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    contentRow.addView(tv4);

                    layout.addView(contentRow);
                }
                break;
            case 4:
                List<Mark> marks = sqLiteHelper.getAllMarksData();
                for (Mark mark: marks
                        ) {
                    TableRow contentRow = new TableRow(view.getContext());
                    tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tv1 = new TextView(view.getContext());
                    tv1.setText(Integer.toString(mark.getId()));
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
                    contentRow.addView(tv1);

                    TextView tv2 = new TextView(view.getContext());
                    tv2.setText(Integer.toString(mark.getStudentId()));
                    tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
                    contentRow.addView(tv2);

                    TextView tv3 = new TextView(view.getContext());
                    tv3.setText(Integer.toString(mark.getCourseId()));
                    tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
                    contentRow.addView(tv3);

                    TextView tv4 = new TextView(view.getContext());
                    tv4.setText(Integer.toString(mark.getMark()));
                    tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
                    contentRow.addView(tv4);

                    TextView tv5 = new TextView(view.getContext());
                    tv5.setText(mark.getComments());
                    tv5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
                    contentRow.addView(tv5);

                    layout.addView(contentRow);
                }
                break;
        }
    }

}
