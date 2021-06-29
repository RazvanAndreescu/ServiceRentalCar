package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Proxy(lazy = false)
@Table(name = "car")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid")
    private Integer carId;

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
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Reservation> reservations;

    public Car(Car car) {
        this.carId = car.getCarId();
        this.model = car.getModel();
        this.transmission = car.getTransmission();
        this.bodyType = car.getBodyType();
        this.yearCar = car.getYearCar();
        this.status = car.getStatus();
        this.price = car.getPrice();
        this.branch = car.getBranch();
    }

    public Car setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Car setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public Car setYearCar(String yearCar) {
        this.yearCar = yearCar;
        return this;
    }

    public Car setStatus(String status) {
        this.status = status;
        return this;
    }

    public Car setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public Car setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carId, car.carId) &&
                Objects.equals(model, car.model) &&
                Objects.equals(transmission, car.transmission) &&
                Objects.equals(bodyType, car.bodyType) &&
                Objects.equals(yearCar, car.yearCar) &&
                Objects.equals(status, car.status) &&
                Objects.equals(price, car.price) &&
                Objects.equals(branch, car.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, model, transmission, bodyType, yearCar, status, price, branch);
    }
}
