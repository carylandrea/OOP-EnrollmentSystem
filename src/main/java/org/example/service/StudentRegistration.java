package org.example.service;
import org.example.model.Person;
import org.example.model.Student;

import java.util.ArrayList;

public class StudentRegistration implements StudentReg {
    private static ArrayList<Student> studentLists = new ArrayList();

    @Override
    public void saveStudent(Student student) {
        studentLists.add(student);

    }

    @Override
    public void displayAllStudent() {
        for (Student s : studentLists) {
            System.out.println(s.getpersonID());
            System.out.println(s.getpersonName());
            System.out.println(s.getStudentProgram());

        }
    }
    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getpersonName().equals(student.getpersonName())) {
                studentLists.set(i, student);
                break;
            }
        }
    }

    @Override
    public void removeStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            studentLists.remove(i);
            break;
        }
    }

    @Override
    public void mainTask() {
        System.out.println("Registers students");

    }
}