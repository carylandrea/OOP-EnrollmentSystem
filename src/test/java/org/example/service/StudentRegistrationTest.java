package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {
    private StudentRegistration studentService;
    private Student testStudent;

    @BeforeEach
    void setup() {
        studentService = new StudentRegistration();
        // ARRANGE
        testStudent = new Student("S2026-001", "Caryl Andrea", "BSIT");
    }

    @Test
    @DisplayName("6. Student Registration - Add Student Test")
    void shouldAddStudentSuccessfully() {
        System.out.println("\n>>> [ TEST: STUDENT REGISTRATION ]");

        // ACT
        studentService.addStudent(testStudent);

        // ASSERT
        Student found = studentService.findStudentByID("S2026-001");

        assertNotNull(found, "Student should be found in the records after adding.");
        assertEquals("Caryl Andrea", found.getPersonName(), "Enrolled student name must match.");

        System.out.println(">>> Registered Student: " + found.getPersonName());
        System.out.println(">>> Test Result: addStudent() works perfectly!");
    }

    @Test
    @DisplayName("7. Student Removal - Delete Student Test")
    void shouldRemoveStudentSuccessfully() {
        System.out.println("\n>>> [ TEST: STUDENT REMOVAL ]");

        // ARRANGE
        studentService.addStudent(testStudent);

        // ACT
        studentService.removeStudent(testStudent);

        // ASSERT
        Student found = studentService.findStudentByID("S2026-001");
        assertNull(found, "Student should no longer exist in the records.");

        System.out.println(">>> Search Result for S2026-001: " + (found == null ? "Not Found" : "Exists"));
        System.out.println(">>> Test Result: removeStudent() logic is correct!");
    }
}