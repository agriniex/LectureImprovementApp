package com.example.dators.lectureimprovementapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.RelativeLayout;

public class FeedbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.content_feedback, contentLayout);

        super.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Monkeyd in Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
