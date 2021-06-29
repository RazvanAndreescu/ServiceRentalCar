package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "employee")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private Integer employeeId;

    @Column(name = "nameemployee")
    private String nameEmployee;

    @Column(name = "roleemployee")
    private String roleEmployee;

    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;

    public Employee(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.nameEmployee = employee.getNameEmployee();
        this.roleEmployee = employee.getRoleEmployee();
        this.branch = employee.getBranch();
    }

    public Employee setEmployeeId(Integer employeeId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(nameEmployee, employee.nameEmployee) &&
                Objects.equals(roleEmployee, employee.roleEmployee) &&
                Objects.equals(branch, employee.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, nameEmployee, roleEmployee, branch);
    }
}
