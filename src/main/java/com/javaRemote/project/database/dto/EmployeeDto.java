package com.javaRemote.project.database.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class EmployeeDto {
    private Integer employeeId;

    @NotNull (message = "nameEmployee is required")
    @Size(min=2, max=30)
    private String nameEmployee;

    @NotNull(message = "roleEmployee is required")
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
