package com.javaRemote.project.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.dto.RentalDto;
import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
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

    public Rental setBranches(List<Branch> branches) {
        this.branches = branches;
        return this;
    }

//    public RentalDto convertToRentalDTO(Rental rental){
//        RentalDto rentalDTO = new RentalDto();
//        BranchDto branchDto = new BranchDto();
//        List <Rental> rentalList = new ArrayList<>();
//        List <BranchDto> branchDtoList = new ArrayList<>();
//        List<Branch> branchList = new ArrayList<>();
//        for (Branch localBranch: rental.getBranches()){
//            branchDto = localBranch.convertToBranchDto(localBranch);
//            branchDtoList.add(branchDto);
//        };
//        rentalDTO.setRentalId(rental.getRentalId())
//                .setNameRental(rental.getNameRental())
//                .setInternetDomain(rental.getInternetDomain())
//                .setContactAddress(rental.getContactAddress())
//                .setOwner(rental.getOwner())
//                .setBranches(branchDtoList);
//        return rentalDTO;
//    }

}
