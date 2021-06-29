package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "namecustomer")
    private String nameCustomer;

    @Column(name = "email")
    private String email;

    @Column(name = "drivingexperience")
    private Integer drivingExperience;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Reservation> reservations;

    public Customer(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.nameCustomer = customer.getNameCustomer();
        this.email = customer.getEmail();
        this.drivingExperience = customer.getDrivingExperience();
    }

    public Customer setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
        return this;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer setDrivingExperience(Integer drivingExperience) {
        this.drivingExperience = drivingExperience;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(nameCustomer, customer.nameCustomer) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(drivingExperience, customer.drivingExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, nameCustomer, email, drivingExperience);
    }
}
