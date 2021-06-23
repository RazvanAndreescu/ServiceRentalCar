package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private int carId;
    private String model;
    private String transmission;
    private String yearCar;
    private String status;
    private int price;
    private int branchId;
    private List<ReservationDto> reservationDtoList;

    public CarDto setCarId(int carId) {
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

    public CarDto setYearCar(String yearCar) {
        this.yearCar = yearCar;
        return this;
    }

    public CarDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public CarDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public CarDto setBranchId(int branchId) {
        this.branchId = branchId;
        return this;
    }

    public CarDto setReservationDtoList(List<ReservationDto> reservationDtoList) {
        this.reservationDtoList = reservationDtoList;
        return this;
    }
}
