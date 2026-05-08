package org.example.service;
import org.example.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration implements CourseReg {
    private List<Course> courses = new ArrayList<Course>();

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(course.getCourseID())) {
                courses.set(i, course);
                break;
            }
        }
    }

    @Override
    public void removeCourse(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                courses.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}