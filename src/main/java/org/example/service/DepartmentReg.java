package org.example.service;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;

public interface DepartmentReg {
    void enrollStudentInSection(Student student, Section section);
    void addDepartment(Department dept);
    void assignInstructorToSection(Instructor instructor, Section section);
    Department findDepartmentByName(String name);


}