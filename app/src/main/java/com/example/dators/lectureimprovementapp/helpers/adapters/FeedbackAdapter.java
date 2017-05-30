package com.example.dators.lectureimprovementapp.helpers.adapters;

import android.content.Context;
import android.media.Rating;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dators.lectureimprovementapp.LectureRating;
import com.example.dators.lectureimprovementapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class FeedbackAdapter extends ArrayAdapter<LectureRating> {

    public FeedbackAdapter(Context context, List<LectureRating> items){
        super(context, R.layout.feedback_list_item, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.feedback_list_item, parent, false);

        LectureRating ratingItem = getItem(position);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        TextView textView = (TextView) view.findViewById(R.id.feedback_item);
        TextView ratingDate = (TextView) view.findViewById(R.id.rating_date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (ratingItem != null) {
            if (ratingItem.getDetails() != null) {
                textView.setText(ratingItem.getDetails());
            }
            if (ratingItem.getDetails() != null) {
                ratingBar.setRating(ratingItem.getRating());
            }
            if (ratingItem.getDetails() != null) {
                ratingDate.setText(sdf.format(ratingItem.getRatedDate()));
            }
        }

        return view;
    }
}
