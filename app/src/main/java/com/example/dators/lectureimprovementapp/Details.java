package com.example.dators.lectureimprovementapp;


public class Details {

    public Details(String text, boolean positive){
        this.text = text;
        this.positive = positive;
    }

    public Details(){
    }

    private String text;
    private boolean positive;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }
}
