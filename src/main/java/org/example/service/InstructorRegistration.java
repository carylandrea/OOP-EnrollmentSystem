package org.example.service;

import org.example.model.Instructor;
import java.util.ArrayList;

public class InstructorRegistration implements InstructorReg {
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
        System.out.println(">>> [SUCCESS] Instructor added successfully.");
    }

    @Override
    public void getInstructorDetails() {
        if (instructorList.isEmpty()) {
            System.out.println(">>> [INFO] No instructor records found.");
            return;
        }
        for (Instructor i : instructorList) {
            i.display();
        }
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getPersonID().equalsIgnoreCase(instructor.getPersonID())) {
                instructorList.set(i, instructor);
                System.out.println(">>> [SUCCESS] Instructor ID " + instructor.getPersonID() + " updated.");
                return;
            }
        }
        System.out.println(">>> [ERROR] Instructor not found.");
    }

    @Override
    public void removeInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getPersonID().equalsIgnoreCase(instructor.getPersonID())) {
                instructorList.remove(i);
                System.out.println(">>> [SUCCESS] Instructor removed.");
                return;
            }
        }
        System.out.println(">>> [ERROR] Instructor not found.");
    }
}