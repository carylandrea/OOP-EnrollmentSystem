package org.example.model;

public class Instructor extends Person {
    private String courseName;

    public Instructor() { super(); }

    public Instructor(String personID, String personName, String courseName) {
        super(personID, personName);
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public void mainTask() {
        System.out.println(">>> Status: Instructor is teaching " + courseName);
    }

    public void display() {
        System.out.println("Instructor ID   : " + getPersonID());
        System.out.println("Instructor Name : " + getPersonName());
        System.out.println("Course Assigned : " + getCourseName() + "\n");
    }
}