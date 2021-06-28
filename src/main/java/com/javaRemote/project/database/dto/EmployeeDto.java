package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer employeeId;
    private String nameEmployee;
    private String roleEmployee;
    private Integer branchId;

    public EmployeeDto setEmployeeId(Integer employeeId) {
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

    public EmployeeDto setBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }
}
