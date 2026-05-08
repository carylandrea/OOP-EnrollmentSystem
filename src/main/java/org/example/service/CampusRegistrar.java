package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.Instructor;
import org.example.model.Department;

public class CampusRegistrar {
    private StudentReg studentService;
    private CourseReg courseService;
    private DepartmentReg departmentService;
    private InstructorReg instructorService;

    public CampusRegistrar(StudentReg studentService, CourseReg courseService,
                           DepartmentReg departmentService, InstructorReg instructorService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.instructorService = instructorService;
    }

    // Course Proxies - Match these to Main.java
    public void addCourse(Course c) { courseService.addCourse(c); }
    public void getAllCourses() { courseService.getAllCourses(); }
    public void updateCourse(Course c) { courseService.updateCourse(c); }
    public void removeCourse(Course c) { courseService.removeCourse(c); }
    public void addStudent(Student s){ studentService.addStudent(s); }
    public void getAllStudents(){ studentService.getAllStudents(); }
    public void updateStudent(Student s){ studentService.updateStudent(s); }
    public void removeStudent(Student s){ studentService.removeStudent(s); }

    public void addInstructor(Instructor i){ instructorService.addInstructor(i); }
    public void getAllInstructors(){ instructorService.getInstructorDetails(); }
    public void updateInstructor(Instructor i){ instructorService.updateInstructor(i); }
    public void removeInstructor(Instructor i){ instructorService.removeInstructor(i); }
}