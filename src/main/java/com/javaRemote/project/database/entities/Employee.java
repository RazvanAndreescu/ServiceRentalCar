package com.javaRemote.project.database.entities;

import lombok.Getter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private int employeeId;

    @Column(name = "nameemployee")
    private String nameEmployee;

    @Column(name = "roleemployee")
    private String roleEmployee;

    @ManyToOne
    @JoinColumn(name="branchid")
    private Branch branch;

    public Employee setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
        return this;
    }

    public Employee setRoleEmployee(String roleEmployee) {
        this.roleEmployee = roleEmployee;
        return this;
    }

    public Employee setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }
}
