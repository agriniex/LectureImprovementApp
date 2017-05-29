package com.example.dators.lectureimprovementapp.listeners;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dators.lectureimprovementapp.Details;
import com.example.dators.lectureimprovementapp.Feedback;
import com.example.dators.lectureimprovementapp.R;
import com.example.dators.lectureimprovementapp.helpers.sqlite.SQLiteHelper;

public class SubmitQueryListener implements View.OnClickListener {

    Activity activity;

    public SubmitQueryListener(Activity activity)
    {
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        EditText submitText = (EditText) activity.findViewById(R.id.input_sql);
        String sql = submitText.getText().toString();

        Feedback feedback = new SQLiteHelper(activity.getApplicationContext()).validateQuery(sql);
        TextView pointsTextView = (TextView) activity.findViewById(R.id.points_label);
        TextView detailsTextView = (TextView) activity.findViewById(R.id.details_label);

        String pointsText = "Iegūtais puktu skaits: ";
        String pointsParsed = Integer.toString(feedback.getScore());
        Spannable spannable = new SpannableString(pointsText  + pointsParsed);
        spannable.setSpan(new ForegroundColorSpan(Color.BLACK), pointsText.length(), pointsText.length() + pointsParsed.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        pointsTextView.setText(spannable);

        SpannableStringBuilder sb = new SpannableStringBuilder();
        sb.append("Komentāri: ");
        for (Details d : feedback.getDetails()
             ) {
            sb.append("\n");
            if (d.isPositive()){
                sb.append(d.getText(), new ForegroundColorSpan(Color.rgb(0, 200, 0)), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            else {
                sb.append(d.getText(), new ForegroundColorSpan(Color.rgb(200, 0, 0)), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }
        detailsTextView.setText(sb);
    }
}
