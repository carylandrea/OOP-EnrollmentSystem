package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import java.util.ArrayList;

public class InstructorRegistration implements InstructorReg {

    private ArrayList<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
        System.out.println("Instructor added.");
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setAssignedInstructor(instructor);
        System.out.println("Instructor assigned to section.");
    }

    @Override
    public void getInstructorDetails(String instructorId) {
        for (Instructor ins : instructorList) {
            if (ins.getPersonID().equalsIgnoreCase(instructorId)) {
                System.out.println("Name: " + ins.getPersonName());
                System.out.println("Specialization: " + ins.getSpecialization());
                return;
            }
        }
        System.out.println("Instructor not found.");
    }
}