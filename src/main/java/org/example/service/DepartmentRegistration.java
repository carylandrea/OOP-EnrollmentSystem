package org.example.service;

import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;
import java.util.ArrayList; // [!] Added for the list

public class DepartmentRegistration implements DepartmentReg {

    private ArrayList<Department> departmentList = new ArrayList<>();

    @Override
    public void addDepartment(Department dept) {
        departmentList.add(dept);
        System.out.println(">>> [SUCCESS] Department '" + dept.getDepartmentName() + "' has been created.");
    }

    @Override
    public void enrollStudentInSection(Student student, Section section) {
        if (section.getEnrolledStudents() == null) {
            section.setEnrolledStudents(new ArrayList<>());
        }
        if (section.getEnrolledStudents().contains(student)) {
            System.out.println(">>> [ERROR] Student " + student.getPersonName() + " is ALREADY enrolled in " + section.getSectionName() + "!");
            return;
        }

        if (section.getEnrolledStudents().size() < section.getMaxCapacity()) {
            section.getEnrolledStudents().add(student);
            System.out.println(">>> [SUCCESS] Student " + student.getPersonName() + " has been successfully enrolled in " + section.getSectionName() + "!");
        } else {
            System.out.println(">>> [ERROR] Cannot enroll. Section " + section.getSectionName() + " is already FULL!");
        }
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Department d : departmentList) {
            if (d.getDepartmentName() != null && d.getDepartmentName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }
    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        if (section.getAssignedInstructor() != null) {
            System.out.println(">>> [ERROR] Section " + section.getSectionName() + " already has a teacher!");
            return;
        }
        section.setAssignedInstructor(instructor);
        System.out.println(">>> [SUCCESS] Instructor " + instructor.getPersonName() + " assigned!");
    }
}