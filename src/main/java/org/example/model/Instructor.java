package org.example.model;

public class Instructor extends Person {
    private String courseName;

    public Instructor() {
        super();

    }

    public Instructor(String personID, String personName, String courseName) {
        super(personID, personName);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void mainTask() {
        System.out.println("Instructor teaches " + courseName);
    }

    @Override
    public String getSpecialization() {
        return "";
    }

    private String specialization;

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}