package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public class CourseRegistration implements CourseReg {
    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
        System.out.println(">>> Course added.");
    }

    @Override
    public void getAllCourses() {
        if (courseList.isEmpty()) {
            System.out.println(">>> No courses registered.");
            return;
        }
        for (Course c : courseList) {
            c.display();
        }
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equalsIgnoreCase(course.getCourseID())) {
                courseList.set(i, course);
                System.out.println(">>> Course updated.");
                return;
            }
        }
        System.out.println(">>> Course not found.");
    }

    @Override
    public void removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equalsIgnoreCase(course.getCourseID())) {
                courseList.remove(i);
                System.out.println(">>> Course removed.");
                return;
            }
        }
        System.out.println(">>> Course not found.");
    }
    @Override
    public Course findCourseByID(String courseID) {
        for (Course c : courseList) {
            if (c.getCourseID().equalsIgnoreCase(courseID)) {
                return c;
            }
        }
        return null;
    }
}