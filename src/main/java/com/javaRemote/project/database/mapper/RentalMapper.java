package com.javaRemote.project.database.mapper;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.service.BranchService;
import com.javaRemote.project.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalMapper {

    private final RentalService rentalService;
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    public RentalMapper(RentalService rentalService, BranchService branchService, BranchMapper branchMapper) {
        this.rentalService = rentalService;
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    public List<RentalDto> getRentals(){
        List<Rental> rentalEntityList = rentalService.getAllRentals();
        List<RentalDto> rentals = new ArrayList<>();
        for(Rental rental: rentalEntityList){
            rentals.add(convertToRentalDTO(rental));
        }
        return rentals;
    }

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

    public RentalDto convertToRentalDTO(Rental rental){
        RentalDto rentalDTO = new RentalDto();
        BranchDto branchDto = new BranchDto();
        List <BranchDto> branchDtoList = new ArrayList<>();
        for (Branch localBranch: rental.getBranches()){
            branchDto = branchMapper.convertToBranchDto(localBranch);
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
