package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration implements StudentReg {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println(">>> [SUCCESS] Student " + student.getPersonName() + " has been enrolled.");
    }

    @Override
    public void getAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println(">>> [INFO] No students found in the records.");
            return;
        }
        System.out.println("\n--- ENROLLED STUDENTS LIST ---");
        for (Student s : studentList) {
            s.display();
        }
    }

    @Override
    public void updateStudent(Student student) {
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            String existingID = studentList.get(i).getPersonID();
            if (existingID != null && existingID.equalsIgnoreCase(student.getPersonID())) {
                studentList.set(i, student);
                System.out.println(">>> [SUCCESS] Student ID " + student.getPersonID() + " updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(">>> [ERROR] Student with ID " + student.getPersonID() + " not found.");
        }
    }

    @Override
    public void removeStudent(Student student) {
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            String currentID = studentList.get(i).getPersonID();
            if (currentID != null && currentID.equalsIgnoreCase(student.getPersonID())) {
                studentList.remove(i);
                found = true;
                System.out.println(">>> [SUCCESS] Student with ID " + student.getPersonID() + " has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println(">>> [ERROR] Student ID not found. No one was removed.");
        }
    }
}