package com.javaRemote.project.database.dto;

import com.javaRemote.project.database.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RentalDto {
    private int rentalId;
    private String nameRental;
    private String internetDomain;
    private String contactAddress;
    private String owner;

    public Rental convertToRental(){
        Rental rental = new Rental();
        rental.setRentalId(rentalId)
                .setNameRental(nameRental)
                .setInternetDomain(internetDomain)
                .setContactAddress(contactAddress)
                .setOwner(owner);
        return rental;
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getNameRental() {
        return nameRental;
    }

    public String getInternetDomain() {
        return internetDomain;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getOwner() {
        return owner;
    }

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
