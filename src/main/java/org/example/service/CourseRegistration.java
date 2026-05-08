package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration implements CourseReg {

    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public void displayAllCourses() {

    }

    // CREATE
    @Override
    public void saveCourse(Course course) {
        courseList.add(course);
        System.out.println("Course added.");
    }

    // READ
    @Override
    public void displayAllCourse() {
        if (courseList.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        for (Course c : courseList) {
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
        }
    }

    // UPDATE
    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            // Dahil String na ang getCourseID(), gamitin ang .equalsIgnoreCase
            if (courseList.get(i).getCourseID().equalsIgnoreCase(course.getCourseID())) {
                courseList.set(i, course);
                System.out.println("Course updated.");
                return;
            }
        }
    }

    @Override
    public void removeCourse(String courseId) {

    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    // DELETE
    @Override
    public void removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            // Same logic dito, String comparison na ulit tayo
            if (courseList.get(i).getCourseID().equalsIgnoreCase(course.getCourseID())) {
                courseList.remove(i);
                System.out.println("Course removed.");
                return;
            }
        }
    }

    @Override
    public void displayAll() {

    }
}