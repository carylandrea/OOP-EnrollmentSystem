package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentReg StudentRegistration;
    private CourseReg CourseRegistration;

    public CampusRegistrar(StudentReg StudentRegistration, CourseReg CourseRegistration){
        this.StudentRegistration = StudentRegistration;
        this.CourseRegistration = CourseRegistration;

    }

    public String saveCourse(Course course){
        CourseRegistration.saveCourse(course);
        return "Success";
    }

    public String saveStudent(Student student){
        StudentRegistration.saveStudent(student);
        return "Success";
    }

    public String displayAllCourse(){
        CourseRegistration.displayAllCourse();
        return "Success";
    }

    public String displayAllStudent(){
        StudentRegistration.displayAllStudent();
        return "Success";

    }

    public String updateCourse(Course course){
        CourseRegistration.updateCourse(course);
        return "Success";
    }
    public String updateStudent(Student student){
        StudentRegistration.updateStudent(student);
        return "Success";
    }

    public String removeCourse(Course course){
        CourseRegistration.removeCourse(course);
        return "Success";
    }

    public String removeStudent(Student student){
        StudentRegistration.removeStudent(student);
        return "Success";

    }
}
