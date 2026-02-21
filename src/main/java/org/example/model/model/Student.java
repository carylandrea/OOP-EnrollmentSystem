package org.example.model;

public class Student {
    private int  studentID;
    private String studentName;
    private String studentProgram;

    public Student(){

    }
    public Student(int studentID, String studentName, String studentProgram){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentProgram = studentProgram;
    }
    public int getStudentID(){
        return studentID;

    }
    public void setStudentID(int studentID){
        this.studentID = studentID;

    }

    public String getStudentName(){
        return studentName;

    }
    public void setStudentName(String studentName){
        this.studentName = studentName;

    }
    public String getStudentProgram(){
        return studentProgram;

    }
    public void setStudentProgram(String studentProgram){
        this.studentProgram = studentProgram;
    }

    public void display(){
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Student Program: " + getStudentProgram() + "\n");
    }

}