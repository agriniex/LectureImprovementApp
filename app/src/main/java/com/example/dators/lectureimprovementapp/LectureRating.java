package com.example.dators.lectureimprovementapp;

import java.util.Date;


public class LectureRating {

    private float rating;
    private String details;
    private Date ratedDate;


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getRatedDate() {
        return ratedDate;
    }

    public void setRatedDate(Date ratedDate) {
        this.ratedDate = ratedDate;
    }
}
