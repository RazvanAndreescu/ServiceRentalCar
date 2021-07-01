package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "rental")
@Valid
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalid")
    private Integer rentalId;

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

    public Rental(Rental rental) {
        this.rentalId = rental.getRentalId();
        this.nameRental = rental.getNameRental();
        this.internetDomain = rental.getInternetDomain();
        this.contactAddress = rental.getContactAddress();
        this.owner = rental.getOwner();
    }

    public Rental setRentalId(Integer rentalId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalId, rental.rentalId) &&
                Objects.equals(nameRental, rental.nameRental) &&
                Objects.equals(internetDomain, rental.internetDomain) &&
                Objects.equals(contactAddress, rental.contactAddress) &&
                Objects.equals(owner, rental.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, nameRental, internetDomain, contactAddress, owner);
    }
}
