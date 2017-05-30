package com.example.dators.lectureimprovementapp.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.dators.lectureimprovementapp.LectureRating;
import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.helpers.adapters.FeedbackAdapter;
import com.example.dators.lectureimprovementapp.helpers.firebase.FirebaseHelper;

import java.util.List;

public class FeedbackResultsActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.feedback_resuts, contentLayout);

        List<LectureRating> allFeedback = new FirebaseHelper().getAllFeedback();
        ListView feedbackList = (ListView) findViewById(R.id.feedback_list);
        ArrayAdapter<LectureRating> adapter = new FeedbackAdapter(this, allFeedback);
        feedbackList.setAdapter(adapter);
    }
}
