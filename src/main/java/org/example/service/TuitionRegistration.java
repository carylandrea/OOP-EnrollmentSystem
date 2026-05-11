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
            double discountedTotal = basePrice - (basePrice * discountRate);

            student.getTuitionDetails().setTotalTuitionFee(discountedTotal);
            student.getTuitionDetails().setBalance(discountedTotal);

            System.out.println(">>> Assessment done for " + student.getPersonName());
            System.out.println(">>> Course: " + course.getCourseName() + " | Price: PHP " + basePrice);
        } else {
            System.out.println(">>> [ERROR] No course assigned to section: " + section.getSectionName());
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