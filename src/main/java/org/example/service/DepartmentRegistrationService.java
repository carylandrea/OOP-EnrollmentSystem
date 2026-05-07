package org.example.service;

import org.example.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRegistrationService implements DepartmentReg {
    private List<Department> departments;
//    private List<Instructor> instructorList;

    public DepartmentRegistrationService(){
        this.departments = new ArrayList<>();
    }
}
