package org.example;

public class Student {
    private int id;
    private String name;
    private String program;

    public Student(){

    }
    public Student(int studentID, String studentName, String studentProgram){
        this.id = studentID;
        this.name = studentName;
        this.program = studentProgram;

    }
    public int getId(){
        return id;

    }
    public void setID(int id){
        this.id = id;

    }
    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name = name;
    }
    public String getProgram(){
        return program;

    }
    public void setProgram(String program){
        this.program = program;
    }

    public void display(){
        System.out.println("Student ID: " + getId());
        System.out.println("Student Name: " + getName());
        System.out.println("Student Program: " + getProgram() + "\n");
    }
}
