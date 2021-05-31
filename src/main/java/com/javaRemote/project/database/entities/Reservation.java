package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
    @JoinColumn(name="branchId")
    private Branch branch;

    @OneToMany(mappedBy = "reservation")
    private List<Customer> customers;

    @OneToMany(mappedBy = "reservation")
    private List<Car> cars;


}
