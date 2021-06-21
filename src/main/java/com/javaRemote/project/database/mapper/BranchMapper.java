package com.javaRemote.project.database.mapper;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.service.RentalService;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

@Service
public class BranchMapper {
    private final RentalService rentalService;

    public BranchMapper(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public Branch convertToBranchEntity(@NotNull BranchDto branchDto){
        Branch branch = new Branch();
        return branch
                .setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                // gaseste rentalul dupa id-ul rentaluluiDto din BranchDto
                .setRental(rentalService.getRentalsById(branchDto.getBranchId()));

    }

    public BranchDto convertToBranchDto(Branch branch){
        BranchDto branchDto = new BranchDto();
        return branchDto
                .setBranchId(branch.getBranchId())
                .setAddress(branch.getAddress())
                .setRentalId(branch.getRental().getRentalId());
    }
}
