package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerDto {
    private int customerId;
    private String nameCustomer;
    private String email;
    private int drivingExperience;
    private List<ReservationDto> reservationDtoList;

    public CustomerDto setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerDto setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
        return this;
    }

    public CustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerDto setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
        return this;
    }

    public CustomerDto setReservationDtoList(List<ReservationDto> reservationDtoList) {
        this.reservationDtoList = reservationDtoList;
        return this;
    }
}
