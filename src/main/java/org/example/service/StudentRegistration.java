package org.example.service;
import org.example.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRegistration implements StudentReg {
    private List<Student> students = new ArrayList<Student>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonID().equals(student.getPersonID())) {
                students.set(i, student);
                break;
            }
        }
    }

    @Override
    public void removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonID().equals(studentId)) {
                students.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}