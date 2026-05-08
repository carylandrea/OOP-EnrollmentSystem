package org.example.service;

public class TuitionRegistration implements TuitionReg {
    private double balance = 0;

    @Override
    public double calculateFee(int units) {
        return units * 1000.0;
    }

    @Override
    public void makePayment(double amount) {
        this.balance -= amount;
    }

    @Override
    public double getRemainingBalance() {
        return balance;
    }
}