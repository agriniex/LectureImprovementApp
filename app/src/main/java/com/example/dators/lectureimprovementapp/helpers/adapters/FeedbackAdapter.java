package com.example.dators.lectureimprovementapp.helpers.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dators.lectureimprovementapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dators on 2017.05.30..
 */

public class FeedbackAdapter extends ArrayAdapter<String> {

    List<String> feedback;

    public FeedbackAdapter(Context context, List<String> items){
        super(context, R.layout.feedback_list_item, items);
        feedback = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.feedback_list_item, parent, false);

        String feedbackItem = getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.feedback_item);
        textView.setText(feedbackItem);

        return view;
    }
}
