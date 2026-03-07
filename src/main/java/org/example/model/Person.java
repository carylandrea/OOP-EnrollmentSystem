package org.example.model;

public class Person {
    private String personID;
    private String personName;

    public Person(){

    }

    public Person(String personID, String personName){
        this.personID = personID;
        this.personName = personName;
    }
    public String getpersonID(){
        return personID;
    }
    public void setpersonID(String personID){
        this.personID = personID;
    }

    public void personID(String personID){
        this.personID = personID;
    }
    public String getpersonName(){
        return personName;
    }
    public void setpersonName(String personName){
        this.personName = personName;
    }

}
