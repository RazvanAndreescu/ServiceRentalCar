package com.javaRemote.project.database.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
public class ReservationDto {
    private Integer reservationId;

    @NotNull(message = "startDate is required")
    private String startDate;

    @NotNull(message = "endDate is required")
    private String endDate;

    @NotNull(message = "price is required")
    private Integer price;

    private Integer branchId;
    private Integer customerId;
    private Integer carId;

    public ReservationDto setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public ReservationDto setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public ReservationDto setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public ReservationDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ReservationDto setBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    public ReservationDto setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public ReservationDto setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public Date getStartDate() {
        if (startDate != null) {
            return Date.valueOf(startDate);
        }
        return null;
    }

    public Date getEndDate() {
        if (endDate != null) {
            return Date.valueOf(endDate);
        }
        return null;
    }
}
