package com.uthm.gradetracker.model;

import java.util.ArrayList;
import java.util.List;

public class TrackerForm {
    private double totalCredits;
    private double currentCGPA;
    private List<CourseInput> courseList = new ArrayList<>();

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public double getCurrentCGPA() {
        return currentCGPA;
    }

    public void setCurrentCGPA(double currentCGPA) {
        this.currentCGPA = currentCGPA;
    }

    public List<CourseInput> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInput> courseList) {
        this.courseList = courseList;
    }
}