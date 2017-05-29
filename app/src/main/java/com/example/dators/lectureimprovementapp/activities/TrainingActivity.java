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
        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.content_training, contentLayout);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new SubmitQueryListener(this));

//        RelativeLayout contentFrameLayout = (RelativeLayout) findViewById(R.id.content_main);
//        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);
        super.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Monkeyd in training", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
