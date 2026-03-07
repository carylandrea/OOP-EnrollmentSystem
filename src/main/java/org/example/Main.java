package org.example;

import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import org.example.service.StudentRegistration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Student stud = new Student();
        Student stud1 = new Student();

        stud.setStudentID("00123");
        stud.setStudentName("John Doe");
        stud.setProgram("Information Technology");

        stud1.setStudentID("00124");
        stud1.setStudentName("Jane Doe");
        stud1.setProgram("Information Technology");

        Course cour = new Course();

        cour.setCourseID("001");
        cour.setCourseName("Integrative Programming");
        cour.setProgram("Information Technology");

        stud.display();
        stud1.display();
        cour.display();*/
        Scanner scanner = new Scanner(System.in);
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();

        int choice = 0;

        do {
            System.out.println("\n[1] Save Student");
            System.out.println("[2] Display Student");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");
            System.out.print("Enter Student: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    System.out.print("Enter Program: ");
                    String program = scanner.nextLine();

                    Student student = new Student(studentID, studentName, program);
                    StudentRegistration.saveStudent(student);
                    break;

                case 2:
                    StudentRegistration.displayAllStudent();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Student Name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter New Program: ");
                    String updateProgram = scanner.nextLine();

                    Student updateStudent = new Student(updateID, updateName, updateProgram);
                    StudentRegistration.updateStudent(updateStudent);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();

    }
}