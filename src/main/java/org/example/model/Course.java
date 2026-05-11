package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private double price;
    private int units;


    public Course(String courseID, String courseName, double price, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.price = price;
        this.units = units;
    }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public double getPrice() { return price; }

    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }

    public void display() {
        System.out.println("Course ID   : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Course Price : " + price);

        System.out.println("-----------------------");
    }
}