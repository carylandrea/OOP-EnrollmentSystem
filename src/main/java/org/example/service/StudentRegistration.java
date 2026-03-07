package org.example.service;
import org.example.model.Person;
import org.example.model.Student;

import java.util.ArrayList;

public class StudentRegistration extends Person {
    private static ArrayList<Student> studentLists = new ArrayList();

    public static void saveStudent(Student student) {
        studentLists.add(student);

    }

    public static void displayAllStudent() {
        for (Student s : studentLists) {
            System.out.println(s.getpersonID());
            System.out.println(s.getpersonName());
            System.out.println(s.getStudentProgram());

        }
    }

    public static void updateStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getpersonName().equals(student.getpersonName())) {
                studentLists.set(i, student);
                break;
            }
        }
    }

    public static void removeStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            studentLists.remove(i);
            break;
        }
    }
}