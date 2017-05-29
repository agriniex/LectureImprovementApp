package com.example.dators.lectureimprovementapp;


import java.util.List;

public class Feedback {

    public Feedback(List<Details> details, int score){
        this.details = details;
        this.score = score;

    }

    private int score;
    private List<Details> details;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

}
