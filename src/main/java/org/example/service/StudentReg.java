package org.example.service;
import org.example.model.Student;
import java.util.List;

public interface StudentReg {
    void addStudent(Student student);
    void updateStudent(Student student);
    void removeStudent(String studentId);
    List<Student> getAllStudents();
}