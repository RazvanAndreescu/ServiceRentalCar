package com.javaRemote.project.database.dto;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.service.BranchService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RentalDto {

    BranchRepository branchRepository;
    BranchService branchService;

    private int rentalId;
    private String nameRental;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private List<BranchDto> branches;

    public Rental convertToRentalEntity(RentalDto rentalDto){
        Rental rental = new Rental();
        rental
                .setRentalId(rentalDto.getRentalId())
                .setNameRental(rentalDto.getNameRental())
                .setInternetDomain(rentalDto.getInternetDomain())
                .setContactAddress(rentalDto.getContactAddress())
                .setOwner(rentalDto.getOwner())
                .setBranches(branchService.getAllBranches());
        return rental;
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

    public RentalDto setBranches(List<BranchDto> branches) {
        this.branches = branches;
        return this;
    }

    @Override
    public String toString() {
        return "RentalDto{" +
                "rentalId=" + rentalId +
                ", nameRental='" + nameRental + '\'' +
                ", internetDomain='" + internetDomain + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", owner='" + owner + '\'' +
                ", branches=" + branches +
                '}';
    }
}
