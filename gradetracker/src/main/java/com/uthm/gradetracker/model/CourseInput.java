package com.uthm.gradetracker.model;

public class CourseInput {
    private String courseName;
    private String grade;
    private double creditHour;

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public double getCreditHour() { return creditHour; }
    public void setCreditHour(double creditHour) { this.creditHour = creditHour; }
}