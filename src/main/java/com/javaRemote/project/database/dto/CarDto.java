package com.javaRemote.project.database.dto;

import lombok.Getter;

@Getter
public class CarDto {
    private Integer carId;
    private String model;
    private String transmission;
    private String bodyType;
    private String yearCar;
    private String status;
    private Integer price;
    private Integer branchId;

    public CarDto setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public CarDto setModel(String model) {
        this.model = model;
        return this;
    }

    public CarDto setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarDto setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public CarDto setYearCar(String yearCar) {
        this.yearCar = yearCar;
        return this;
    }

    public CarDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public CarDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public CarDto setBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }
}
