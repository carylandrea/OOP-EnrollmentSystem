package org.example.service;
import org.example.model.Student;

public interface StudentReg {
    void addStudent(Student student);
    void getAllStudents();
    void updateStudent(Student student);
    void removeStudent(Student student);
}