package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TuitionFeePaymentTest {
    //Arrange
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    @DisplayName("Calculate Tuition Fee")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount(){
        //assert
        assertEquals(5000, tuitionFeePayment.calculateTuitionFee(5,0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount(){
        assertEquals(4500, tuitionFeePayment.calculateTuitionFee(5,0.10));
    }

    @Test
    void shouldMakePaymentOf500(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(500);

        assertEquals(4500, tuitionFeePayment.getBalance());
    }

    @Test
    void shouldBeFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(5000);
        assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void shouldNotBeFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(500);
        assertFalse(tuitionFeePayment.isFullyPaid());
    }
}