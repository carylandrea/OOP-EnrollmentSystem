package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Student;
import org.example.model.Instructor;

public class CampusRegistrar {
    private StudentReg studentService;
    private CourseReg courseService;
    private DepartmentReg departmentService;
    private InstructorReg instructorService;

    public CampusRegistrar(StudentReg studentService, CourseReg courseService,
                           DepartmentReg departmentService, InstructorReg instructorService){
        this.studentService = studentService;
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.instructorService = instructorService;
    }

    public void addStudent(Student s){ studentService.addStudent(s); }
    public void getAllStudents(){ studentService.getAllStudents(); }
    public void updateStudent(Student s){ studentService.updateStudent(s); }
    public void removeStudent(Student s){ studentService.removeStudent(s); }

    public void addInstructor(Instructor i){ instructorService.addInstructor(i); }
    public void getAllInstructors(){ instructorService.getInstructorDetails(); }
    public void updateInstructor(Instructor i){ instructorService.updateInstructor(i); }
    public void removeInstructor(Instructor i){ instructorService.removeInstructor(i); }
}