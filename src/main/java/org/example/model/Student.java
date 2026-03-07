package org.example.model;

public class Student extends Person {
    String studentProgram;

    public Student(int studentID, String studentName, String program){

    }
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
        System.out.println("Student ID: " + getpersonID());
        System.out.println("Student Name: " + getpersonName());
        System.out.println("Student Program: " + getStudentProgram() + "\n");
    }

}