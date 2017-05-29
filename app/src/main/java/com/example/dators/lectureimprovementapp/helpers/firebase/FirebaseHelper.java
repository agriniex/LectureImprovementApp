package com.example.dators.lectureimprovementapp.helpers.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FirebaseHelper {

    private DatabaseReference mDatabase;

    public FirebaseHelper(){
        mDatabase = FirebaseDatabase.getInstance().getReference("feedback");
    }

    public List<String> getAllFeedback(){
        final List<String> feedbackValues = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot itemsSnapshot: dataSnapshot.getChildren()){
                    String feedback = itemsSnapshot.getValue(String.class);
                    feedbackValues.add(feedback);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return feedbackValues;
    }

}
