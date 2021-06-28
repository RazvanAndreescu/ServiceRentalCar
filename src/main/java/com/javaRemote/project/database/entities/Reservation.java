package com.javaRemote.project.database.entities;

import lombok.Getter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "reservation")
public class Reservation {
    // TODO: 6/28/2021 Verify Rental table >>double value 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private int reservationId;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name="branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    public Reservation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Reservation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Reservation setPrice(int price) {
        this.price = price;
        return this;
    }

    public Reservation setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public Reservation setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Reservation setCar(Car car) {
        this.car = car;
        return this;
    }
}
