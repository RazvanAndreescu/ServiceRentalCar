package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private int reservationId;
    private Date startDate;
    private Date endDate;
    private int price;
    private int branchId;
    private int customerId;
    private int carId;

    public ReservationDto setReservationId(int reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public ReservationDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public ReservationDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public ReservationDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public ReservationDto setBranchId(int branchId) {
        this.branchId = branchId;
        return this;
    }

    public ReservationDto setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public ReservationDto setCarId(int carId) {
        this.carId = carId;
        return this;
    }
}
