package org.example.service;
import org.example.model.Instructor;
import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorRegistration implements InstructorReg {
    private List<Instructor> instructors = new ArrayList<Instructor>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setAssignedInstructor(instructor);
    }

    @Override
    public void getInstructorDetails(String instructorId) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getPersonID().equals(instructorId)) {
                Instructor ins = instructors.get(i);
                System.out.println("Instructor: " + ins.getPersonName());
                return;
            }
        }
    }
}