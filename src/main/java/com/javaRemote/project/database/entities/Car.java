package com.javaRemote.project.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name="branchid")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;


}
