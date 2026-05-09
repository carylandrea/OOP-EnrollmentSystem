package org.example.service;
import org.example.model.Student;

public class TuitionRegistration implements TuitionReg {
    private final double PRICE_PER_UNIT = 1000.0;

    @Override
    public void calculateTuition(Student student, int units, double discountRate) {
        double total = units * PRICE_PER_UNIT;
        double discountedTotal = total - (total * discountRate);
        student.setTuitionBalance(discountedTotal);
        System.out.println("Assessment done for " + student.getPersonName());
    }

    @Override
    public void makePayment(Student student, double amount) {
        double currentBalance = student.getTuitionBalance();
        student.setTuitionBalance(currentBalance - amount);
        System.out.println("Payment processed: P" + amount);
        System.out.println("Remaining Balance: P" + student.getTuitionBalance());
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getTuitionBalance();
    }
}