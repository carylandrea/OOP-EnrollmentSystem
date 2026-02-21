package org.example.model;

import org.example.model.Course;

import java.util.ArrayList;


public class CourseRegistration {
    private ArrayList<Course> courseList = new ArrayList();

    public void saveCourse(Course course) {
        courseList.add(course);

    }

    public void displayAllCourse() {
        for (Course c : courseList) {
            System.out.println(c.getCourseID());
            System.out.println(c.getCourseName());
            System.out.println(c.getCourseProgram());
        }
    }

    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(course.getCourseName())) {
                courseList.set(i, course);
                break;
            }
        }
    }

    public void removeCourse(Course course){
        for(int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(course.getCourseName())) {
                courseList.remove(i);
                break;
            }

        }
    }
}