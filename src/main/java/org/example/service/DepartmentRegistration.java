package org.example.service;
import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;

public class DepartmentRegistration implements DepartmentReg {

    @Override
    public void enrollStudentInSection(Student student, Section section) {
        if (section.getEnrolledStudents().size() < section.getMaxCapacity()) {
            section.getEnrolledStudents().add(student);
        } else {
            System.out.println("Full na boi!");
        }
    }

    @Override
    public void viewDepartmentHierarchy(Department dept) {
        System.out.println("Dept: " + dept.getDepartmentName());
        for (int i = 0; i < dept.getSectionLists().size(); i++) {
            System.out.println(" - " + dept.getSectionLists().get(i).getSectionName());
        }
    }
}