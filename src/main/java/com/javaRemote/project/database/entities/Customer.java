package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private int customerId;

    @Column(name = "Customer_Name")
    private String nameCustomer;

    @Column(name = "Customer_Email")
    private String email;

    @Column(name = "Customer_DrivingExperience")
    private int drivingExperience;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    public Customer(int customerId, String nameCustomer, String email, int drivingExperience) {
        this.customerId = customerId;
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.drivingExperience = drivingExperience;
    }
}
