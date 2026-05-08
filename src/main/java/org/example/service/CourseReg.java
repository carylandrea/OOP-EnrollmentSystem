package org.example.service;
import org.example.model.Course;
import java.util.List;

public interface CourseReg {
    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(String courseId);
    List<Course> getAllCourses();
}