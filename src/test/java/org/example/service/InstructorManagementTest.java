package org.example.service;

import org.example.model.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {
    private InstructorRegistration instructorService;
    private Instructor testInstructor;

    @BeforeEach
    void setup() {
        instructorService = new InstructorRegistration();
        testInstructor = new Instructor("INS-001", "Prof. Alexander", "Java Specialist");
    }

    @Test
    @DisplayName("4. Add Instructor - Verify List Size Increases")
    void shouldAddInstructorSuccessfully() {
        System.out.println("\n>>> [ TEST: ADD INSTRUCTOR ]");

        // ACT
        instructorService.addInstructor(testInstructor);

        // ASSERT
        int listSize = instructorService.getAllInstructors().size();
        assertEquals(1, listSize, "Instructor list should contain 1 instructor.");

        System.out.println(">>> List Size: " + listSize);
        System.out.println(">>> Test Result: Instructor Registration Working!");
    }

    @Test
    @DisplayName("5. Remove Instructor - Verify List Size Decreases")
    void shouldRemoveInstructorSuccessfully() {
        System.out.println("\n>>> [ TEST: REMOVE INSTRUCTOR ]");

        // ARRANGE
        instructorService.addInstructor(testInstructor);

        // ACT
        instructorService.removeInstructor(testInstructor);

        // ASSERT
        int listSize = instructorService.getAllInstructors().size();
        assertEquals(0, listSize, "Instructor list should be empty after removal.");

        System.out.println(">>> Final List Size: " + listSize);
        System.out.println(">>> Test Result: Instructor Removal Working!");
    }
}