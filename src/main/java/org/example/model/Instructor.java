package org.example.model;

public class Instructor extends Person{
    String CourseName;

    public Instructor(String PersonID, String PersonName, String CourseName){
        super(PersonID, PersonName);
        this.CourseName = CourseName;
    }
    public String CourseName(){
        return CourseName;

    }
    public void CourseName(String CourseName){
        this.CourseName = CourseName;

    }


}

