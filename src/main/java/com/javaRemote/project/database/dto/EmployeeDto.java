package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String nameEmployee;
    private String roleEmployee;
    private int branchId;

    public EmployeeDto setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeDto setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
        return this;
    }

    public EmployeeDto setRoleEmployee(String roleEmployee) {
        this.roleEmployee = roleEmployee;
        return this;
    }

    public EmployeeDto setBranchId(int branchId) {
        this.branchId = branchId;
        return this;
    }
}
