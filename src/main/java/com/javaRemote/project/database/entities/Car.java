package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid")
    private int carId;

    @Column(name = "model")
    private String model;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "bodytype")
    private String bodyType;

    @Column(name = "yearcar")
    private String yearCar;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name="branchId")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="reservationId")
    private Reservation reservation;


}
