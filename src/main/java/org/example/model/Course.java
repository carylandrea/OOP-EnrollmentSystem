package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private double price;


    public Course(String courseID, String courseName, double price) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.price = price;
    }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public double getPrice() { return price; }

    public void display() {
        System.out.println("Course ID   : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Course Price : " + price);

        System.out.println("-----------------------");
    }
}