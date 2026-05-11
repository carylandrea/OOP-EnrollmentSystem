package org.example.service;

import org.example.model.Course;

public interface CourseReg {
    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(Course course);
    void getAllCourses();
    Course findCourseByID(String courseID);
}