package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.Instructor;
import org.example.model.Department;
import org.example.model.Section;

public class CampusRegistrar {
    private StudentReg studentService;
    private CourseReg courseService;
    private DepartmentReg departmentService;
    private InstructorReg instructorService;
    private TuitionReg tuitionService;

    public CampusRegistrar(StudentReg studentService, CourseReg courseService,
                           DepartmentReg departmentService, InstructorReg instructorService,
                           TuitionReg tuitionService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.instructorService = instructorService;
        this.tuitionService = tuitionService;
    }

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



    // 1. Tuition Management
    public void calculateAndSetTuition(String studentId, int units, double discountRate) {
        Student actualStudent = studentService.findStudentByID(studentId);

        if (actualStudent != null) {
            tuitionService.calculateTuition(actualStudent, units, discountRate);
        } else {
            System.out.println("Student ID not found!");
        }
    }

    // Process payment
    public void processStudentPayment(String studentId, double amount) {
        Student actualStudent = studentService.findStudentByID(studentId);

        if (actualStudent != null) {
            tuitionService.makePayment(actualStudent, amount);
        } else {
            System.out.println("Student ID not found!");
        }
    }

    // Check Balance
    public void checkStudentBalance(String studentId) {
        Student actualStudent = studentService.findStudentByID(studentId);

        if (actualStudent != null) {
            double balance = tuitionService.getRemainingBalance(actualStudent);
            System.out.println("\n[ TUITION STATUS ]");
            System.out.println("Student: " + actualStudent.getPersonName());
            System.out.println("Remaining Balance: PHP " + balance);
            System.out.println("Status: " + (balance <= 0 ? "FULLY PAID" : "WITH OUTSTANDING BALANCE"));
        } else {
            System.out.println("Student ID not found!");
        }
    }

    // 3. Institutional Hierarchy Viewing
    public void displayHierarchy(Department dept) {
        System.out.println("\n=== INSTITUTIONAL HIERARCHY ===");
        System.out.println("DEPARTMENT: " + dept.getDepartmentName());

        if (dept.getSectionLists() == null || dept.getSectionLists().isEmpty()) {
            System.out.println("  (No sections available)");
            return;
        }

        for (Section sec : dept.getSectionLists()) {
            System.out.println("   |_ SECTION: " + sec.getSectionName() + " (Capacity: " + sec.getMaxCapacity() + ")");

            Instructor ins = sec.getAssignedInstructor();
            System.out.println("      |_ INSTRUCTOR: " + (ins != null ? ins.getPersonName() : "TBA"));

            System.out.println("      |_ ENROLLED STUDENTS:");
            if (sec.getEnrolledStudents().isEmpty()) {
                System.out.println("         - (No students yet)");
            } else {
                for (Student s : sec.getEnrolledStudents()) {
                    System.out.println("         - [" + s.getPersonID() + "] " + s.getPersonName());
                }
            }
        }
    }

    public Student getStudent(String studentId) {
        return studentService.findStudentByID(studentId);
    }
    public void addDepartment(Department d) {
        departmentService.addDepartment(d);
    }

    public Department getDepartment(String deptName) {
        return departmentService.findDepartmentByName(deptName);
    }
    public void enrollStudentToSection(String enrollId, String enrollDept, String enrollSec) {
        Student student = studentService.findStudentByID(enrollId);
        if (student == null) {
            System.out.println(">>> [ERROR] Student ID '" + enrollId + "' not found! Add student muna.");
            return;
        }
        Department dept = departmentService.findDepartmentByName(enrollDept);
        if (dept == null) {
            System.out.println(">>> [ERROR] Department '" + enrollDept + "' not found!");
            return;
        }
        Section targetSection = null;
        if (dept.getSectionLists() != null) {
            for (Section sec : dept.getSectionLists()) {
                if (sec.getSectionName().equalsIgnoreCase(enrollSec)) {
                    targetSection = sec;
                    break;
                }
            }
        }
        if (targetSection == null) {
            System.out.println(">>> [ERROR] Section '" + enrollSec + "' not found in " + enrollDept + "!");
            return;
        }
        departmentService.enrollStudentInSection(student, targetSection);
    }
}