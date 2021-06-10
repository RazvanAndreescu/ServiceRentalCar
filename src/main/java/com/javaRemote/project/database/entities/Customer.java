package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Proxy(lazy = false)
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
    @JsonIgnore
    private List<Reservation> reservations;

    public Customer setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
        return this;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
        return this;
    }

    public Customer setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }
}
