package org.example;

import org.example.model.*;
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
            System.out.println("4. Department Management");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) studentMenu();
            else if (choice.equals("2")) instructorMenu();
            else if (choice.equals("3")) courseMenu();
            else if (choice.equals("4")) departmentMenu(); // [!] NEW
            else if (choice.equals("5")) {
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
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    registrar.addCourse(new Course(code, desc, price));
                    break;
                case "2":
                    registrar.getAllCourses();
                    break;
                case "3":
                    System.out.print("Enter Code to update: "); String uCode = scanner.nextLine();
                    System.out.print("New Description: "); String uDesc = scanner.nextLine();

                    System.out.print("New Price: ");
                    double uPrice = scanner.nextDouble();
                    scanner.nextLine();

                    registrar.updateCourse(new Course(uCode, uDesc, uPrice));
                    break;
                case "4":
                    System.out.print("Enter Code to delete: "); String rCode = scanner.nextLine();
                    registrar.removeCourse(new Course(rCode, "", 0.0));
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
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    if (registrar.getStudent(id) != null) {
                        System.out.println(">>> [ERROR] Student ID '" + id + "' already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Program: ");
                    String prog = scanner.nextLine();
                    registrar.addStudent(new Student(id, name, prog));

                    break;
                case "2":
                    registrar.getAllStudents();
                    break;
                case "3":
                    System.out.print("Enter ID to update: ");
                    String uId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String uName = scanner.nextLine();
                    System.out.print("Enter New Program: ");
                    String uProg = scanner.nextLine();
                    registrar.updateStudent(new Student(uId, uName, uProg));
                    break;
                case "4":
                    System.out.print("Enter ID to delete: ");
                    String dId = scanner.nextLine();
                    registrar.removeStudent(new Student(dId, "", ""));
                    break;

                // PHASE 2: TUITION FEE MANAGEMENT
                case "5":
                    System.out.print("Enter Student ID to assess: ");
                    String assessId = scanner.nextLine();
                    Student studentToAssess = registrar.getStudent(assessId);

                    if (studentToAssess == null) {
                        System.out.println(">>> [ERROR] Student ID not found!");
                        break;
                    }

                    Section selectedSection = null;

                    System.out.print("Enter Department Name: ");
                    String dName = scanner.nextLine();
                    Department dept = registrar.getDepartment(dName);

                    if (dept != null) {
                        System.out.print("Enter Section Name (e.g., BSIT-1A): ");
                        String sectName = scanner.nextLine();

                        if (dept.getSectionLists() != null) {
                            for (Section sec : dept.getSectionLists()) {
                                if (sec.getSectionName().equalsIgnoreCase(sectName)) {
                                    selectedSection = sec;
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println(">>> [ERROR] Department not found!");
                        break;
                    }

                    if (selectedSection == null) {
                        System.out.println(">>> [ERROR] Section not found in this department!");
                        break;
                    }

                    System.out.print("Enter discount rate (e.g. 0.10): ");
                    double discount = 0;
                    try {
                        discount = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) { discount = 0; }

                    registrar.calculateAndSetTuition(assessId, selectedSection, discount);

                    break;
                case "6":
                    System.out.print("Enter Student ID to pay: ");
                    String payId = scanner.nextLine();

                    Student studentToPay = registrar.getStudent(payId);
                    if (studentToPay == null) {
                        System.out.println(">>> [ERROR] Student ID not found!");
                        break;
                    }

                    if (studentToPay.getTuitionDetails() == null || studentToPay.getTuitionDetails().getTotalTuitionFee() == 0) {
                        System.out.println(">>> [ERROR] Tuition not assessed yet! Please assess tuition first (Option 5).");
                        break;
                    }

                    double currentBalance = studentToPay.getTuitionDetails().getBalance();
                    if (currentBalance <= 0) {
                        System.out.println(">>> [INFO] Student is already FULLY PAID. No payment needed.");
                        break;
                    }

                    double amount = 0;
                    while (true) {
                        System.out.print("Enter amount to pay (Current Balance: PHP " + currentBalance + "): PHP ");
                        try {
                            amount = Double.parseDouble(scanner.nextLine());

                            if (amount > currentBalance) {
                                System.out.println(">>> [WARNING] Too much! You only need to pay PHP " + currentBalance);
                            } else if (amount <= 0) {
                                System.out.println(">>> [WARNING] Invalid amount. Please enter a value greater than 0.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(">>> [ERROR] Invalid input! Please enter numbers only.");
                        }
                    }

                    registrar.processStudentPayment(payId, amount);
                    break;

                case "7":
                    System.out.print("Enter Student ID to check balance: ");
                    String checkId = scanner.nextLine();

                    Student studentToCheck = registrar.getStudent(checkId);
                    if (studentToCheck == null) {
                        System.out.println(">>> [ERROR] Student ID not found!");
                        break;
                    }

                    if (studentToCheck.getTuitionDetails() == null || studentToCheck.getTuitionDetails().getTotalTuitionFee() == 0) {
                        System.out.println(">>> [ERROR] Tuition not assessed yet! Please assess tuition first (Option 5).");
                        break;
                    }

                    registrar.checkStudentBalance(checkId);
                    break;
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
    public static void departmentMenu() {
        while (true) {
            System.out.println("\n[ DEPARTMENT MANAGEMENT ]");
            System.out.println("1. Add Department");
            System.out.println("2. Add Section to Department");
            System.out.println("3. Assign Instructor to Section");
            System.out.println("4. Assign Course to Section");
            System.out.println("5. Enroll Student to Section");
            System.out.println("6. View Institutional Hierarchy");

            System.out.println("7. Back to Main");
            System.out.print("Choice: ");
            String action = scanner.nextLine();

            if (action.equals("7")) return;

            switch (action) {
                case "1":
                    System.out.print("Enter Department Name: ");
                    String deptName = scanner.nextLine();
                    if (registrar.getDepartment(deptName) != null) {
                        System.out.println(">>> [ERROR] Department '" + deptName + "' already exists!");
                        break;
                    }
                    registrar.addDepartment(new Department(deptName));
                    break;

                case "2":
                    System.out.print("Enter Department Name: ");
                    String targetDeptName = scanner.nextLine();
                    Department targetDept = registrar.getDepartment(targetDeptName);

                    if (targetDept != null) {
                        System.out.print("Enter Section Name: ");
                        String secName = scanner.nextLine();
                        boolean isDuplicate = false;

                        if (targetDept.getSectionLists() != null) {
                            for (Section sec : targetDept.getSectionLists()) {
                                if (sec.getSectionName().equalsIgnoreCase(secName)) {
                                    isDuplicate = true;
                                    break;
                                }
                            }
                        }

                        if (isDuplicate) {
                            System.out.println(">>> [ERROR] Section '" + secName + "' already exists in " + targetDept.getDepartmentName() + "!");
                            break;
                        }

                        int capacity = 0;
                        while (true) {
                            System.out.print("Enter Max Capacity (e.g., 40): ");
                            try {
                                capacity = Integer.parseInt(scanner.nextLine());
                                if (capacity > 0) break;
                                System.out.println(">>> [WARNING] Capacity must be greater than 0.");
                            } catch (NumberFormatException e) {
                                System.out.println(">>> [ERROR] Please enter a valid number.");
                            }
                        }

                        Section newSection = new Section(secName, capacity);
                        targetDept.addSection(newSection);
                    } else {
                        System.out.println(">>> [ERROR] Department '" + targetDeptName + "' not found! Please add it first (Option 1).");
                    }
                    break;

                case "3":
                    System.out.print("Enter Instructor ID: ");
                    String instId = scanner.nextLine();
                    System.out.print("Enter Department Name: ");
                    String instDept = scanner.nextLine();
                    System.out.print("Enter Section Name: ");
                    String instSec = scanner.nextLine();

                    registrar.assignInstructorToSection(instId, instDept, instSec);
                    break;
                case "4":
                    System.out.print("Enter Course Code: ");
                    String cCode = scanner.nextLine();
                    System.out.print("Enter Department Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter Section Name: ");
                    String sName = scanner.nextLine();

                    registrar.assignCourseToSection(cCode, dName, sName);
                    break;

                case "5":
                    System.out.print("Enter Student ID to enroll: ");
                    String enrollId = scanner.nextLine();
                    System.out.print("Enter Department Name: ");
                    String enrollDept = scanner.nextLine();
                    System.out.print("Enter Section Name: ");
                    String enrollSec = scanner.nextLine();

                    registrar.enrollStudentToSection(enrollId, enrollDept, enrollSec);
                    break;

                case "6":
                    System.out.println("\n--- VIEW INSTITUTIONAL HIERARCHY ---");
                    System.out.print("Enter Department Name to view: ");
                    String viewDept = scanner.nextLine();
                    Department deptToView = registrar.getDepartment(viewDept);

                    if (deptToView != null) {
                        registrar.displayHierarchy(deptToView);
                    } else {
                        System.out.println(">>> [ERROR] Department '" + viewDept + "' not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}