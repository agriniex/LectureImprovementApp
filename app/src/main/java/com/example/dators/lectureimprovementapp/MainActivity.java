package com.example.dators.lectureimprovementapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RelativeLayout contentFrameLayout = (RelativeLayout) findViewById(R.id.content_main);
//        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);
        super.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Monkeyd", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
