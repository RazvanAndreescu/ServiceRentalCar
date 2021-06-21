package com.javaRemote.project.database.mapper;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalMapper {

    private final RentalService rentalService;

    public RentalMapper(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public List<RentalDto> getRentals(){
        List<Rental> rentalEntityList = rentalService.getAllRentals();
        List<RentalDto> rentals = new ArrayList<>();
        for(Rental rental: rentalEntityList){
            rentals.add(convertToRentalDTO(rental));
        }
        return rentals;
    }

//    public RentalDto convertRentalEntityToDto(Rental rental){
//        RentalDto rentalDto = new RentalDto();
//        return rentalDto
//                .setRentalId(rental.getRentalId())
//                .setNameRental(rental.getNameRental())
//                .setInternetDomain(rental.getInternetDomain())
//                .setContactAddress(rental.getContactAddress())
//                .setOwner(rental.getOwner())
//                .setBranches(rental.getBranches());
//
//    }

    public RentalDto convertToRentalDTO(Rental rental){
        RentalDto rentalDTO = new RentalDto();
        BranchDto branchDto = new BranchDto();
        List <Rental> rentalList = new ArrayList<>();
        List <BranchDto> branchDtoList = new ArrayList<>();
        List<Branch> branchList = new ArrayList<>();
        for (Branch localBranch: rental.getBranches()){
            branchDto = localBranch.convertToBranchDto(localBranch);
            branchDtoList.add(branchDto);
        };
        rentalDTO.setRentalId(rental.getRentalId())
                .setNameRental(rental.getNameRental())
                .setInternetDomain(rental.getInternetDomain())
                .setContactAddress(rental.getContactAddress())
                .setOwner(rental.getOwner())
                .setBranches(branchDtoList);
        return rentalDTO;
    }
}
