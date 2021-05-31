package com.javaRemote.project.database.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
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

    @OneToOne
    @JoinColumn(name="branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;
}
