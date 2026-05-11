package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseManagementTest {
    private Section testSection;
    private Instructor testInstructor;

    @BeforeEach
    void setup() {
        // ARRANGE
        testSection = new Section("BSIT-1A", 40);
        testInstructor = new Instructor("INS-2026", "Sir Kevin", "IT Department");
    }

    @Test
    @DisplayName("Instructor Assignment - Verify Correct Association")
    void shouldCorrectlyAssignInstructorToSection() {
        System.out.println("\n>>> [ COURSE MANAGEMENT TEST ]");
        System.out.println(">>> Section: " + testSection.getSectionName());

        // ACT
        System.out.println(">>> Action: Assigning Instructor [" + testInstructor.getPersonName() + "] to Section...");
        testSection.setAssignedInstructor(testInstructor);

        // ASSERT
        assertNotNull(testSection.getAssignedInstructor(), "Instructor should not be null!");
        assertEquals("Sir Kevin", testSection.getAssignedInstructor().getPersonName(), "Name should match!");

        System.out.println(">>> Verification: Instructor successfully linked to " + testSection.getSectionName());
        System.out.println(">>> Assigned Personnel: " + testSection.getAssignedInstructor().getPersonName());
        System.out.println(">>> Test Result: Assignment Verified.");
    }
}