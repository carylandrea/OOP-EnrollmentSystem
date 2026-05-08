package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentReg studentService;
    private CourseReg courseService;
    private DepartmentReg departmentService;

    public CampusRegistrar(StudentReg studentService, CourseReg courseService, DepartmentReg departmentService){
        this.studentService = studentService;
        this.courseService = courseService;
        this.departmentService = departmentService;
    }

    public void addStudent(Student student){
        studentService.addStudent(student);
    }

    public void getAllStudents(){
        studentService.getAllStudents();
    }

    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }

    public void removeStudent(Student student){
        studentService.removeStudent(student);
    }

    public void addCourse(Course course){
        courseService.addCourse(course);
    }

    public void getAllCourses(){
        courseService.getAllCourses();
    }

    public void updateCourse(Course course){
        courseService.updateCourse(course);
    }

    public void removeCourse(Course course){
        courseService.removeCourse(course);
    }
}