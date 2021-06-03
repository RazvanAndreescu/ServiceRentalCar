package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
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
    @JoinColumn(name="branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
