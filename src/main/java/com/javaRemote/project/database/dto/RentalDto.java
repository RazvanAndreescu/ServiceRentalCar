package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto implements Serializable {
    private Integer rentalId;
    private String nameRental;
    private String internetDomain;
    private String contactAddress;
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
