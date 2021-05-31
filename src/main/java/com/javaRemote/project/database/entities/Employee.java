package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
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


}
