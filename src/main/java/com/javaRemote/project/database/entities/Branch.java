package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private int branchId;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="rentalid")
    private Rental rental;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Car> cars;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Reservation> reservations;

    public Branch setBranchId(int branchId) {
        this.branchId = branchId;
        return this;
    }

    public Branch setAddress(String address) {
        this.address = address;
        return this;
    }

    public Branch setRental(Rental rental) {
        this.rental = rental;
        return this;
    }

    public Branch setCars(List<Car> cars) {
        this.cars = cars;
        return this;
    }

    public Branch setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public Branch setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }
}
