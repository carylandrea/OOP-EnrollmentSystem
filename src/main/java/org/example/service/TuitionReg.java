package org.example.service;

import org.example.model.Section;
import org.example.model.Student;

public interface TuitionReg {
    void calculateTuition(Student student, Section section, double discountRate);
    void makePayment(Student student, double amount);
    double getRemainingBalance(Student student);

}