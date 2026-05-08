package org.example.service;

public interface TuitionReg {
    double calculateFee(int units);
    void makePayment(double amount);
    double getRemainingBalance();
}