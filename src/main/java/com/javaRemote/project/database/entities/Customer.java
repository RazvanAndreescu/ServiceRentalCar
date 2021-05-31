package com.javaRemote.project.database.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerId;

    @Column(name = "namecustomer")
    private String nameCustomer;

    @Column(name = "email")
    private String email;

    @Column(name = "drivingexperience")
    private int drivingExperience;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    public Customer() {
    }

    public Customer(String nameCustomer, String email, int drivingExperience, List<Reservation> reservations) {
//        this.customerId = customerId;
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.drivingExperience = drivingExperience;
        this.reservations = reservations;
    }
}
