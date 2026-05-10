package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.service.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CampusRegistrar registrar;

    public static void main(String[] args) {
        StudentReg studentService = new StudentRegistration();
        InstructorReg instructorService = new InstructorRegistration();
        CourseReg courseService = new CourseRegistration();
        DepartmentReg departmentService = new DepartmentRegistration();
        TuitionReg tuitionService = new TuitionRegistration();

        registrar = new CampusRegistrar(studentService, courseService, departmentService, instructorService, tuitionService);

        while (true) {
            System.out.println("\n--- CAMPUS SYSTEM MENU ---");
            System.out.println("1. Student Management");
            System.out.println("2. Instructor Management");
            System.out.println("3. Course Management");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) studentMenu();
            else if (choice.equals("2")) instructorMenu();
            else if (choice.equals("3")) courseMenu();
            else if (choice.equals("4")) {
                System.out.println("System Closed.");
                break;
            } else System.out.println("Invalid option.");
        }
    }

    public static void courseMenu() {
        while (true) {
            System.out.println("\n[ COURSE MANAGEMENT ]");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Back");
            System.out.print("Choice: ");
            String action = scanner.nextLine();

            if (action.equals("5")) return;

            switch (action) {
                case "1":
                    System.out.print("Enter Code: "); String code = scanner.nextLine();
                    System.out.print("Enter Description: "); String desc = scanner.nextLine();
                    registrar.addCourse(new Course(code, desc));
                    break;
                case "2":
                    registrar.getAllCourses();
                    break;
                case "3":
                    System.out.print("Enter Code to update: "); String uCode = scanner.nextLine();
                    System.out.print("New Description: "); String uDesc = scanner.nextLine();
                    registrar.updateCourse(new Course(uCode, uDesc));
                    break;
                case "4":
                    System.out.print("Enter Code to delete: "); String rCode = scanner.nextLine();
                     registrar.removeCourse(new Course(rCode, ""));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void studentMenu() {
        while (true) {
            System.out.println("\n[ STUDENT MANAGEMENT ]");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Calculate Tuition ");
            System.out.println("6. Pay Tuition");
            System.out.println("7. Check Balance");
            System.out.println("8. Back to Main");
            System.out.print("Choice: ");
            String action = scanner.nextLine();

            if (action.equals("8")) return;

            switch (action) {
                case "1":
                    System.out.print("Enter ID: "); String id = scanner.nextLine();
                    System.out.print("Enter Name: "); String name = scanner.nextLine();
                    System.out.print("Enter Program: "); String prog = scanner.nextLine();
                    registrar.addStudent(new Student(id, name, prog));
                    break;
                case "2":
                    registrar.getAllStudents();
                    break;
                case "3":
                    System.out.print("Enter ID to update: "); String uId = scanner.nextLine();
                    System.out.print("Enter New Name: "); String uName = scanner.nextLine();
                    System.out.print("Enter New Program: "); String uProg = scanner.nextLine();
                    registrar.updateStudent(new Student(uId, uName, uProg));
                    break;
                case "4":
                    System.out.print("Enter ID to delete: "); String dId = scanner.nextLine();
                    registrar.removeStudent(new Student(dId, "", ""));
                    break;

                // PHASE 2: TUITION FEE MANAGEMENT
                case "5":
                    System.out.print("Enter Student ID to assess: ");
                    String assessId = scanner.nextLine();
                    System.out.print("Enter units enrolled: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter discount rate: ");
                    double discount = Double.parseDouble(scanner.nextLine());

                    registrar.calculateAndSetTuition(assessId, units, discount);
                    break;
                case "6":
                    System.out.print("Enter Student ID to pay: ");
                    String payId = scanner.nextLine();
                    System.out.print("Enter amount to pay: PHP ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    registrar.processStudentPayment(payId, amount);
                    break;
                case "7":
                    System.out.print("Enter Student ID to check balance: ");
                    String checkId = scanner.nextLine();

                    registrar.checkStudentBalance(checkId);
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public static void instructorMenu() {
        while (true) {
            System.out.println("\n[ INSTRUCTOR MANAGEMENT ]");
            System.out.println("1. Add Instructor");
            System.out.println("2. View All Instructors");
            System.out.println("3. Update Instructor");
            System.out.println("4. Delete Instructor");
            System.out.println("5. Back to Main");
            System.out.print("Choice: ");
            String action = scanner.nextLine();

            if (action.equals("5")) return;

            switch (action) {
                case "1":
                    System.out.print("Enter ID: "); String id = scanner.nextLine();
                    System.out.print("Enter Name: "); String name = scanner.nextLine();
                    System.out.print("Enter Course: "); String course = scanner.nextLine();
                    registrar.addInstructor(new Instructor(id, name, course));
                    break;
                case "2":
                    registrar.getAllInstructors();
                    break;
                case "3":
                    System.out.print("Enter ID to update: "); String uId = scanner.nextLine();
                    System.out.print("Enter New Name: "); String uName = scanner.nextLine();
                    System.out.print("Enter New Course: "); String uCourse = scanner.nextLine();
                    registrar.updateInstructor(new Instructor(uId, uName, uCourse));
                    break;
                case "4":
                    System.out.print("Enter ID to delete: "); String dId = scanner.nextLine();
                    registrar.removeInstructor(new Instructor(dId, "", ""));
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}