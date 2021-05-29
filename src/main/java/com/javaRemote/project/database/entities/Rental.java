package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rental_ID")
    private int rentalId;

    @Column(name = "Rental_Name")
    private String nameRental;

    @Column(name = "URL")
    private String internetDomain;

    @Column(name = "Address")
    private String contactAddress;

    @Column(name = "Owner")
    private String owner;

    @OneToMany(mappedBy = "rental")
    private List<Branch> branches;

    public Rental(int rentalId, String nameRental, String internetDomain, String contactAddress, String owner) {
        this.rentalId = rentalId;
        this.nameRental = nameRental;
        this.internetDomain = internetDomain;
        this.contactAddress = contactAddress;
        this.owner = owner;
    }
}
