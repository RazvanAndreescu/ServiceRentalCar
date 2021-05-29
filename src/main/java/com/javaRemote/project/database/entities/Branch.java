package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Branch_ID")
    private int branchId;

    @Column(name = "Branch_Address")
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


    public Branch(int branchId, String address) {
        this.branchId = branchId;
        this.address = address;
    }
}
