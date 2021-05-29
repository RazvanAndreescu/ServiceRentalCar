package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation_ID")
    private int reservationId;

    @Column(name = "Reservation_startDate")
    private Date startDate;

    @Column(name = "Reservation_endDate")
    private Date endDate;

    @Column(name = "Reservation_Price")
    private int price;

    @OneToOne
    @JoinColumn(name="branchId")
    private Branch branch;

    @OneToMany(mappedBy = "reservation")
    private List<Customer> customers;

    @OneToMany(mappedBy = "reservation")
    private List<Car> cars;

    public Reservation(int reservationId, Date startDate, Date endDate, int price) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
}
