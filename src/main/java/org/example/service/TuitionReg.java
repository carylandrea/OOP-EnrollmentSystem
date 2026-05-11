package org.example.service;
import org.example.model.Student;

public interface TuitionReg {
    void calculateTuition(Student student, int units, double discountRate);
    void makePayment(Student student, double amount);
    double getRemainingBalance(Student student);
    double tuition = selectedCourse.getPrice();
}