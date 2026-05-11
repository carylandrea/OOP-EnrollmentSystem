package org.example.service;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Course;

public class TuitionRegistration implements TuitionReg {

    @Override
    public void calculateTuition(Student student, Section section, double discountRate) {
        Course course = section.getAssignedCourse();

        if (course != null) {
            double basePrice = course.getPrice();
            double discountAmount = basePrice * discountRate;
            double discountedTotal = basePrice - discountAmount;

            student.getTuitionDetails().setTotalTuitionFee(discountedTotal);
            student.getTuitionDetails().setBalance(discountedTotal);

            System.out.println(">>> Assessment done for " + student.getPersonName());
            System.out.println(">>> Course: " + course.getCourseName());
            System.out.println(">>> Base Price: PHP " + basePrice);
            System.out.println(">>> Discount: " + (discountRate * 100) + "% (-PHP " + discountAmount + ")");
            System.out.println(">>> FINAL TUITION: PHP " + discountedTotal);
        }
    }


    @Override
    public void makePayment(Student student, double amount) {
        double currentBalance = student.getTuitionDetails().getBalance();
        student.getTuitionDetails().setBalance(currentBalance - amount);
        System.out.println("Payment processed: PHP " + amount);
        System.out.println("Remaining Balance: PHP " + student.getTuitionDetails().getBalance());
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getTuitionDetails().getBalance();
    }
}