package com.example.dators.lectureimprovementapp.listeners;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import com.example.dators.lectureimprovementapp.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmitFeedbackListener implements View.OnClickListener {

    private Activity activity;
    public SubmitFeedbackListener(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        final EditText feedbackText = (EditText) activity.findViewById(R.id.feedback_text);
        final String feedback = feedbackText.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference feedbackRef = firebaseDatabase.getReference("feedback");
        feedbackRef.push().setValue(feedback, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("Kļūda pievienojot datus datu bāzē:" + databaseError.toString());
                    builder.setTitle("Kļūda!");
                    AlertDialog dialog = builder.create();
                } else {
                    feedbackText.setText("");
                    if (activity.getCurrentFocus() != null) {
                        Snackbar.make(activity.getCurrentFocus(), "Jūsu ziņojums tika saglabāts veiksmīgi!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            }
        });


    }
}
