package com.example.dators.lectureimprovementapp.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.dators.lectureimprovementapp.Course;
import com.example.dators.lectureimprovementapp.Mark;
import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.Student;
import com.example.dators.lectureimprovementapp.Studies;
import com.example.dators.lectureimprovementapp.helpers.sqlite.SQLiteHelper;
import com.example.dators.lectureimprovementapp.listeners.SubmitFeedbackListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends BaseActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

//        SQLiteDatabase database = sqLiteHelper.getReadableDatabase();
//        List<Student> students = sqLiteHelper.getAllStudentsData();
//        List<Course> courses = sqLiteHelper.getAllCursesData();
//        List<Studies> studies = sqLiteHelper.getAllStudiesData();
//        List<Mark> marks = sqLiteHelper.getAllMarksData();

        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.content_feedback, contentLayout);

        Button submitFeedbackButton = (Button) findViewById(R.id.submit_feedback_button);
        submitFeedbackButton.setOnClickListener(new SubmitFeedbackListener(this));

        super.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Monkeyd in Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }
}
