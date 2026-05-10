package org.example.model;

public class Student extends Person {
    private String studentProgram;
    private TuitionFeePayment tuitionDetails;

    public Student(String PersonID, String PersonName, String studentProgram) {
        super(PersonID, PersonName);
        this.studentProgram = studentProgram;

        this.tuitionDetails = new TuitionFeePayment();
    }

    public String getStudentProgram() { return studentProgram; }
    public void setStudentProgram(String studentProgram) { this.studentProgram = studentProgram; }

    public TuitionFeePayment getTuitionDetails() {
        return tuitionDetails;
    }

    public void display() {
        System.out.println("Student ID: " + getPersonID());
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Program: " + getStudentProgram());

        System.out.println("Balance: P" + tuitionDetails.getBalance() + "\n");

        mainTask();
        System.out.println();
    }

    @Override
    public void mainTask() {
    }
}