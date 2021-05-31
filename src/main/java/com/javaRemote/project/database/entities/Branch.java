package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private int branchId;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="rentalId")
    private Rental rental;

    @OneToMany(mappedBy = "branch")
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    @OneToOne(mappedBy = "branch")
    private Reservation reservation;



}
