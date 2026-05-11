package org.example.model;

public class TuitionFeePayment {
    private double totalTuitionFee;
    private double balance;

    public TuitionFeePayment() {
        this.totalTuitionFee = 0.0;
        this.balance = 0.0;
    }

    public double getTotalTuitionFee() {
        return totalTuitionFee;
    }

    public void setTotalTuitionFee(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}