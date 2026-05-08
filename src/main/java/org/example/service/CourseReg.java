package org.example.service;
import org.example.model.Course;
import java.util.List;

public interface CourseReg {
    void addCourse(Course course);
    void displayAllCourses();

    void saveCourse(Course course);

    void displayAllCourse();

    void updateCourse(Course course);
    void removeCourse(String courseId);
    List<Course> getAllCourses();

    void removeCourse(Course course);

    void displayAll();
}