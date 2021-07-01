package com.javaRemote.project.database.dto;


import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CustomerDto {
    private Integer customerId;

    @NotNull(message = "nameCustomer is required")
    @Size(min = 2, max = 30)
    private String nameCustomer;

    @NotNull(message = "email is required")
    @Email(message = "the email is invalid")
    private String email;

    @NotNull(message = "drivingExperience is required")
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
