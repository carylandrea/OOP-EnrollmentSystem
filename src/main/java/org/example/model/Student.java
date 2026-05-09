package org.example.model;

public class Student extends Person {
    private String studentProgram;
    private double tuitionBalance;

    public Student(String PersonID, String PersonName, String studentProgram) {
        super(PersonID, PersonName);
        this.studentProgram = studentProgram;
        this.tuitionBalance = 0.0;
    }

    public String getStudentProgram() { return studentProgram; }
    public void setStudentProgram(String studentProgram) { this.studentProgram = studentProgram; }

    public double getTuitionBalance() { return tuitionBalance; }
    public void setTuitionBalance(double tuitionBalance) { this.tuitionBalance = tuitionBalance; }

    public void display() {
        System.out.println("Student ID: " + getPersonID());
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Program: " + getStudentProgram());
        System.out.println("Balance: P" + getTuitionBalance() + "\n");
    }

    @Override
    public void mainTask() {
        System.out.println("Student " + getPersonName() + " is studying.");
    }
}