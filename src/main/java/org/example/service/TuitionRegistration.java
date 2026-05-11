package org.example.service;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Course;

public class TuitionRegistration implements TuitionReg {

    @Override
    public void calculateTuition(Student student, Section section, double discountRate) {
        Course course = section.getAssignedCourse();

        if (course != null) {
            double ratePerUnit = course.getPrice();
            int units = course.getUnits();
            double basePrice = ratePerUnit * units;

            double discountAmount = basePrice * discountRate;
            double discountedTotal = basePrice - discountAmount;

            student.getTuitionDetails().setTotalTuitionFee(discountedTotal);
            student.getTuitionDetails().setBalance(discountedTotal);

            System.out.println("\n>>> [ ADVANCED TUITION ASSESSMENT ]");
            System.out.println(">>> Course: " + course.getCourseName());
            System.out.println(">>> Load: " + units + " Units @ PHP " + ratePerUnit + "/unit");
            System.out.println(">>> Total Base Fee: PHP " + basePrice);

            if(discountRate > 0) {
                System.out.println(">>> Scholarship Applied: " + (discountRate * 100) + "%");
                System.out.println(">>> Amount Saved: PHP " + discountAmount);

            }
            System.out.println(">>> FINAL AMOUNT TO PAY: PHP " + discountedTotal);
        } else {
            System.out.println(">>> [ERROR] No course assigned to section!");
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