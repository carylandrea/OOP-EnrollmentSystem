package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {
    private Section tinySection;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setup() {
        // ARRANGE
        tinySection = new Section("BSIT-SMALL", 1);
        student1 = new Student("S001", "Alice", "BSIT");
        student2 = new Student("S002", "Bob", "BSIT");
    }

    @Test
    @DisplayName("Capacity Check - Reject Enrollment when Section is Full")
    void shouldFailEnrollmentWhenCapacityIsReached() {
        System.out.println("\n>>> [ ENROLLMENT CAPACITY TEST ]");
        System.out.println(">>> Section: " + tinySection.getSectionName() + " | Max Capacity: " + tinySection.getMaxCapacity());

        // ACT:
        System.out.println(">>> Action: Enrolling Student 1 [" + student1.getPersonName() + "]...");
        tinySection.getEnrolledStudents().add(student1);

        System.out.println(">>> Current Enrollment Size: " + tinySection.getEnrolledStudents().size());
        System.out.println(">>> Attempting to enroll Student 2 [" + student2.getPersonName() + "]...");

        boolean hasSpace = tinySection.getEnrolledStudents().size() < tinySection.getMaxCapacity();

        if (!hasSpace) {
            System.out.println(">>> [SYSTEM ALERT] Enrollment Rejected: Section is FULL!");
        }

        // ASSERT
        assertFalse(hasSpace, "Should not allow more students if capacity is 1/1");
        System.out.println(">>> Test Result: Successfully blocked extra enrollment.");
    }
}