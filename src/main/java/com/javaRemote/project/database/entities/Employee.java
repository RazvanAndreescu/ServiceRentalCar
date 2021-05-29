package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
    private int employeeId;

    @Column(name = "Employee_Name")
    private String nameEmployee;

    @Column(name = "Employee_Role")
    private String roleEmployee;

    @ManyToOne
    @JoinColumn(name="branchId")
    private Branch branch;


    public Employee(int employeeId, String nameEmployee, String roleEmployee) {
        this.employeeId = employeeId;
        this.nameEmployee = nameEmployee;
        this.roleEmployee = roleEmployee;
    }
}
