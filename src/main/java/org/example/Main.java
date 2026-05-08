package org.example;

import org.example.model.Student;
import org.example.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pag-initialize ng Services
        CampusRegistrar campusRegistrar = new CampusRegistrar(
                new StudentRegistration(),
                new CourseRegistration(),
                new DepartmentRegistration());

        int choice = 0;

        do {
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("[1] Save Student");
            System.out.println("[2] Display All Students");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");
            System.out.println("[5] Exit"); // Ginawa nating 5 ang Exit
            System.out.print("Enter Choice: ");

            // Check muna kung integer ang input para hindi mag-crash
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Buffer clear
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Program: ");
                    String prog = scanner.nextLine();

                    Student student = new Student(id, name, prog);
                    campusRegistrar.addStudent(student);
                    break;

                case 2:
                    campusRegistrar.getAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    String upId = scanner.nextLine();
                    System.out.print("Enter New Student Name: ");
                    String upName = scanner.nextLine();
                    System.out.print("Enter New Program: ");
                    String upProg = scanner.nextLine();

                    Student updateStudent = new Student(upId, upName, upProg);
                    campusRegistrar.updateStudent(updateStudent);
                    break;

                case 4:
                    System.out.print("Enter Student ID to remove: ");
                    String remId = scanner.nextLine();
                    // Gagawa ng temp object para sa ID match
                    Student studentToRemove = new Student(remId, "", "");
                    campusRegistrar.removeStudent(studentToRemove);
                    break;

                case 5:
                    System.out.println("Exiting System... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5); // Dito ang fix! Hanggang hindi 5 ang choice, tuloy ang loop.

        scanner.close();
    }
}