package org.example.service;

import org.example.model.Instructor;

public interface InstructorReg {
    void addInstructor(Instructor instructor);
    void getInstructorDetails();
    void updateInstructor(Instructor instructor);
    void removeInstructor(Instructor instructor);
}