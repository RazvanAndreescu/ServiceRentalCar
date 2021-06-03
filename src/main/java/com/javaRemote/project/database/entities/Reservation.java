package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Proxy(lazy = false)
@Table(name = "reservation")
public class Reservation {

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
    @JsonIgnore
    @JoinColumn(name="branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "carid")
    private Car car;
}
