package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionRegistrationTest {
    private TuitionRegistration tuitionService;
    private Student testStudent;

    @BeforeEach
    void setup() {
        tuitionService = new TuitionRegistration();
        testStudent = new Student("S101", "Test Student", "BSIT");
    }

    @Test
    @DisplayName("Calculate Tuition Fee - No Discount")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount() {
        tuitionService.calculateTuition(testStudent, 5, 0.0);

        assertEquals(5000.0, testStudent.getTuitionBalance());
    }

    @Test
    @DisplayName("Calculate Tuition Fee - 10% Discount")
    void shouldCalculateCorrectTuitionFeeWithDiscount() {
        tuitionService.calculateTuition(testStudent, 5, 0.10);

        assertEquals(4500.0, testStudent.getTuitionBalance());
    }

    @Test
    @DisplayName("Process Partial Payment")
    void shouldUpdateBalanceAfterPayment() {
        tuitionService.calculateTuition(testStudent, 5, 0.0); // 5000 utang
        tuitionService.makePayment(testStudent, 500.0); // nagbayad 500

        assertEquals(4500.0, testStudent.getTuitionBalance());
    }

    @Test
    @DisplayName("Check if Fully Paid")
    void shouldBeFullyPaid() {
        tuitionService.calculateTuition(testStudent, 5, 0.0);
        tuitionService.makePayment(testStudent, 5000.0);

        assertTrue(testStudent.getTuitionBalance() <= 0);
    }
}