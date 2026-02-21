package org.example.service;
import org.example.model.Student;

import java.util.ArrayList;

public class StudentRegistration {
    private ArrayList<Student> studentLists = new ArrayList();

    public void saveStudent(Student student) {
        studentLists.add(student);

    }

    public void displayAllStudent() {
        for (Student s : studentLists) {
            System.out.println(s.getStudentID());
            System.out.println(s.getStudentName());
            System.out.println(s.getStudentProgram());

        }
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getStudentName().equals(student.getStudentName())) {
                studentLists.set(i, student);
                break;
            }
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            studentLists.remove(i);
            break;
        }
    }
}