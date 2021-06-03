package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
@Proxy(lazy = false)
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", email='" + email + '\'' +
                ", drivingExperience=" + drivingExperience +
                '}';
    }
}
