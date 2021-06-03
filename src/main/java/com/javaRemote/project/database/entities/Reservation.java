package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "reservation")
@Proxy(lazy = false)
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
    @JoinColumn(name = "branchid")
    @JsonIgnore
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid")
    @JsonIgnore
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
