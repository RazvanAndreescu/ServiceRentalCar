package com.javaRemote.project.database.dto;


import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RentalDto {

    private Integer rentalId;

    @NotNull (message = "nameRental is required")
    @Size(min=2, max=30)
    private String nameRental;

    @NotNull (message = "internetDomain is required")
    @Size(min = 2, max = 30)
    private String internetDomain;

    @NotNull(message = "contactAddress is required")
    @Size(max = 50, message = "contactAddress is too long")
    private String contactAddress;

    @NotNull(message = "owner is required")
    @Size(min = 2, max = 30)
    private String owner;

    public RentalDto setRentalId(int rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public RentalDto setNameRental(String nameRental) {
        this.nameRental = nameRental;
        return this;
    }

    public RentalDto setInternetDomain(String internetDomain) {
        this.internetDomain = internetDomain;
        return this;
    }

    public RentalDto setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public RentalDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
