package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaRemote.project.database.dto.RentalDto;
import lombok.Getter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalid")
    private int rentalId;

    @Column(name = "namerental")
    private String nameRental;

    @Column(name = "internetdomain")
    private String internetDomain;

    @Column(name = "contactaddress")
    private String contactAddress;

    @Column(name = "owner")
    private String owner;

    @OneToMany(mappedBy = "rental")
    @JsonIgnore
    private List<Branch> branches;

    public RentalDto convertToDto(){
        RentalDto rentalDto = new RentalDto();
        rentalDto.setRentalId(rentalId)
                .setNameRental(nameRental)
                .setInternetDomain(internetDomain)
                .setContactAddress(contactAddress)
                .setOwner(owner);
        return rentalDto;
    }

    public Rental setRentalId(int rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public Rental setNameRental(String nameRental) {
        this.nameRental = nameRental;
        return this;
    }

    public Rental setInternetDomain(String internetDomain) {
        this.internetDomain = internetDomain;
        return this;
    }

    public Rental setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public Rental setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
