package com.example.dators.lectureimprovementapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.listeners.SubmitFeedbackListener;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content);
        getLayoutInflater().inflate(R.layout.content_feedback, contentLayout);

        Button submitFeedbackButton = (Button) findViewById(R.id.submit_feedback_button);
        submitFeedbackButton.setOnClickListener(new SubmitFeedbackListener(this));

    }
}
