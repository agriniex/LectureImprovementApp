package com.example.dators.lectureimprovementapp;

public class Course {

    private int id;
    private String name;
    private int creditPoints;
    private int lectureHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }
}
