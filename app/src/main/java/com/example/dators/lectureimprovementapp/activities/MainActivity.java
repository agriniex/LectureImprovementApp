package com.example.dators.lectureimprovementapp.activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import android.widget.CalendarView;
import android.widget.RelativeLayout;

import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.helpers.SQLiteHelper;

public class MainActivity extends BaseActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.content_main, contentLayout);

        calendarView = (CalendarView) findViewById(R.id.lecture_calendar);
        calendarView.setFirstDayOfWeek(2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Snackbar.make(view, year + "gada " + dayOfMonth + ". " +  month + " Mēnesis", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        super.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Monkeyd", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SQLiteHelper sqh = new SQLiteHelper(this);

        SQLiteDatabase sqdb = sqh.getReadableDatabase();


    }
}
