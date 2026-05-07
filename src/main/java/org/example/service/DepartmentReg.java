package org.example.service;

import org.example.model.Department;

public interface DepartmentReg {

    public interface DepartmentRegistration{
        void saveDepartment(Department department);
    }
}
