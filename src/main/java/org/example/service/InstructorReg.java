package org.example.service;
import org.example.model.Instructor;
import java.util.List;

public interface InstructorReg {
    void addInstructor(Instructor instructor);
    void getInstructorDetails();
    void updateInstructor(Instructor instructor);
    void removeInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
}