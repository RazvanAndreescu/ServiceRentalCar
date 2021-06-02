package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;


import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "employee")
@Proxy(lazy = false)

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
    @JoinColumn(name = "branchid")
    private Branch branch;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", roleEmployee='" + roleEmployee + '\'' +
                '}';
    }
}
