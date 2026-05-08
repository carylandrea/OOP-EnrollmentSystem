package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionLists;

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;

        this.instructorList = new ArrayList<>();
        this.sectionLists = new ArrayList<>();
    }

    public String getDepartmentID() { return departmentID; }
    public void setDepartmentID(String departmentID) { this.departmentID = departmentID; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public List<Instructor> getInstructorList() { return instructorList; }
    public void setInstructorList(List<Instructor> instructorList) { this.instructorList = instructorList; }

    public List<Section> getSectionLists() { return sectionLists; }
    public void setSectionLists(List<Section> sectionLists) { this.sectionLists = sectionLists; }
}