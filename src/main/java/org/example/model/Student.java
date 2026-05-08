package org.example.model;

public class Student extends Person {
    String studentProgram;

    public Student(String PersonID, String PersonName, String studentProgram){
        super(PersonID, PersonName);
        this.studentProgram = studentProgram;
    }

    public String getStudentProgram(){
        return studentProgram;
    }

    public void setStudentProgram(String studentProgram){
        this.studentProgram = studentProgram;
    }

    public void display(){
        System.out.println("Student ID: " + getPersonID());
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Student Program: " + getStudentProgram() + "\n");
    }

    @Override
    public void mainTask() {
        System.out.println("Student Enrolled");
    }

    @Override
    public String getSpecialization() {
        return "";
    }
}