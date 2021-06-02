package com.javaRemote.project.database.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "car")
@Proxy(lazy = false)
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
    @JoinColumn(name = "branchid")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", transmission='" + transmission + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearCar='" + yearCar + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
