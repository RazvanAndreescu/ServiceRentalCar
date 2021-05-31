package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;


}
