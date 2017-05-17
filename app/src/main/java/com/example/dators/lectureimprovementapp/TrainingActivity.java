package com.example.dators.lectureimprovementapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;


public class TrainingActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.app_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.content_training, contentLayout);

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
