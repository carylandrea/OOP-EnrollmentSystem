package org.example.service;
import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;

public interface DepartmentReg {
    void enrollStudentInSection(Student student, Section section);
    void addDepartment(Department dept);
    Department findDepartmentByName(String name);
}