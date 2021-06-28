package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer customerId;
    private String nameCustomer;
    private String email;
    private Integer drivingExperience;

    public CustomerDto setCustomerId(Integer customerId) {
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

    public CustomerDto setDrivingExperience(Integer drivingExperience) {
        this.drivingExperience = drivingExperience;
        return this;
    }
}
