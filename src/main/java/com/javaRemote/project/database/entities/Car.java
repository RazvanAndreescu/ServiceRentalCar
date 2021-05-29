package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_ID")
    private int carId;

    @Column(name = "Car_Model")
    private String model;

    @Column(name = "Car_Transmission")
    private String transmission;

    @Column(name = "Car_BodyType")
    private String bodyType;

    @Column(name = "Car_ProductionDate")
    private String yearCar;

    @Column(name = "Car_Status")
    private String status;

    @Column(name = "Car_Price")
    private int price;

    @ManyToOne
    @JoinColumn(name="branchId")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="reservationId")
    private Reservation reservation;

    public Car(int carId, String model, String transmission, String bodyType, String yearCar, String status, int price) {
        this.carId = carId;
        this.model = model;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.yearCar = yearCar;
        this.status = status;
        this.price = price;
    }
}
