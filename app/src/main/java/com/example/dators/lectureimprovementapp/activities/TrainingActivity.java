package com.example.dators.lectureimprovementapp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.listeners.SubmitQueryListener;


public class TrainingActivity extends BaseActivity{

    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content);
        getLayoutInflater().inflate(R.layout.content_training, contentLayout);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new SubmitQueryListener(this));
    }
}
