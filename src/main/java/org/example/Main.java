package org.example;

public class Main{
    public static void main(String[] args){

        Student b = new Student();
        Student s = new Student();
        Course c = new Course();

        s.setID(1200014314);
        s.setName("Caryl");
        s.setProgram("Information Technology");

        b.setID(1200);
        b.setName("Andrea ");
        b.setProgram("Computer Programming");

        c.setCourseID(0001);
        c.setCourseName("Intergrative Programming");
        c.setCourseProgram("Information Technology");

        s.display();
        b.display();
        c.display();


    }

}