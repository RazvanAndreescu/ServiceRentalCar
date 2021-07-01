package com.javaRemote.project.database.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CarDto {
    private Integer carId;

    @NotNull (message = "model is required")
    private String model;

    @NotNull(message = "transmission is required")
    private String transmission;

    @NotNull(message = "bodyType is required")
    private String bodyType;

    @NotNull(message = "yearCar is required")
    private String yearCar;

    @NotNull(message = "status is required")
    private String status;

    @NotNull(message = "price is required")
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
