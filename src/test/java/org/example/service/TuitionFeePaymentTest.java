package org.example.service;

import org.example.model.Student;
import org.example.model.Course;
import org.example.model.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionRegistrationTest {
    private TuitionRegistration tuitionService;
    private Student testStudent;
    private Section testSection;
    private Course testCourse;

    @BeforeEach
    void setup() {
        tuitionService = new TuitionRegistration();
        testStudent = new Student("S101", "Test Student", "BSIT");

        testCourse = new Course("IT101", "Java Programming", 5000.0);

        testSection = new Section("BSIT-1A", 40);
        testSection.setAssignedCourse(testCourse);
    }

    @Test
    @DisplayName("Calculate Tuition Fee - No Discount")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount() {
        tuitionService.calculateTuition(testStudent, testSection, 0.0);

        assertEquals(5000.0, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    @DisplayName("Calculate Tuition Fee - 10% Discount")
    void shouldCalculateCorrectTuitionFeeWithDiscount() {
        tuitionService.calculateTuition(testStudent, testSection, 0.10);

        assertEquals(4500.0, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    @DisplayName("Process Partial Payment")
    void shouldUpdateBalanceAfterPayment() {
        tuitionService.calculateTuition(testStudent, testSection, 0.0); // 5000 balance
        tuitionService.makePayment(testStudent, 500.0);

        assertEquals(4500.0, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    @DisplayName("Check if Fully Paid")
    void shouldBeFullyPaid() {
        tuitionService.calculateTuition(testStudent, testSection, 0.0);
        tuitionService.makePayment(testStudent, 5000.0);

        assertTrue(testStudent.getTuitionDetails().getBalance() <= 0);
    }
}