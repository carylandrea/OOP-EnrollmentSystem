package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataIntegrityTest {
    private StudentRegistration studentService;

    @BeforeEach
    void setup() {
        studentService = new StudentRegistration();
    }

    @Test
    @DisplayName("Justice for Data Integrity: Prevent Duplicate Student IDs")
    void shouldPreventDuplicateStudentIDs() {
        // ARRANGE
        Student student1 = new Student("S101", "Caryl Andrea", "BSIT");
        studentService.addStudent(student1);

        Student duplicateStudent = new Student("S101", "Ghost Student", "BSCS");

        // ACT
        studentService.addStudent(duplicateStudent);

        // ASSERT
        int actualCount = 0;
        for (Student s : studentService.findStudentByID("S101") != null ? new Student[]{studentService.findStudentByID("S101")} : new Student[0]) {
            actualCount++;
        }

        Student registered = studentService.findStudentByID("S101");

        assertEquals("Caryl Andrea", registered.getPersonName(), "System should retain the original student data and reject duplicates.");
        System.out.println("\n>>> [ DATA INTEGRITY TEST ]");
        System.out.println(">>> Attempted Duplicate ID: S101");
        System.out.println(">>> Result: Duplicate Rejected. Original data preserved.");
    }
}