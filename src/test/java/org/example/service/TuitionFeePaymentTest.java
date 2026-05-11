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
        testStudent = new Student("S101", "Caryl Andrea", "BSIT");

        // ARRANGE: 1000 per unit * 3 units = 3000.0 Total Base Price
        testCourse = new Course("IT101", "Java Programming", 1000.0, 3);
        testSection = new Section("BSIT-1A", 40);
        testSection.setAssignedCourse(testCourse);
    }

    @Test
    @DisplayName("Calculate Tuition Fee - No Discount")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount() {
        // ACT
        tuitionService.calculateTuition(testStudent, testSection, 0.0);

        // ASSERT: Expected is 3000.0 (1000 * 3)
        assertEquals(3000.0, testStudent.getTuitionDetails().getBalance(), "Balance should be 3000 for 3 units at 1000/unit");
    }

    @Test
    @DisplayName("Calculate Tuition Fee - 10% Discount")
    void shouldCalculateCorrectTuitionFeeWithDiscount() {
        // ACT: 3000 - (3000 * 0.10) = 2700
        tuitionService.calculateTuition(testStudent, testSection, 0.10);

        // ASSERT
        assertEquals(2700.0, testStudent.getTuitionDetails().getBalance(), "Balance should be 2700 after 10% discount");
    }

    @Test
    @DisplayName("Process Partial Payment")
    void shouldUpdateBalanceAfterPayment() {
        // ARRANGE & ACT
        tuitionService.calculateTuition(testStudent, testSection, 0.0); // 3000 balance
        tuitionService.makePayment(testStudent, 500.0);

        // ASSERT: 3000 - 500 = 2500
        assertEquals(2500.0, testStudent.getTuitionDetails().getBalance(), "Balance should decrease to 2500 after 500 payment");
    }

    @Test
    @DisplayName("Check if Fully Paid")
    void shouldBeFullyPaid() {
        // ARRANGE & ACT
        tuitionService.calculateTuition(testStudent, testSection, 0.0); // 3000 balance
        tuitionService.makePayment(testStudent, 3000.0); // Pay all

        // ASSERT
        assertTrue(testStudent.getTuitionDetails().getBalance() <= 0, "Balance should be zero or less after full payment");
    }
}