package com.javaRemote.project.database.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

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
    private List<Branch> branches;


}
