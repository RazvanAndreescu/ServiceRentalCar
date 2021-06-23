package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.*;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertorService {

    private final BranchRepository branchRepository;
    private final RentalRepository rentalRepository;
    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public ConvertorService(BranchRepository branchRepository,
                            RentalRepository rentalRepository,
                            EmployeeRepository employeeRepository,
                            CarRepository carRepository,
                            ReservationRepository reservationRepository,
                            CustomerRepository customerRepository) {
        this.branchRepository = branchRepository;
        this.rentalRepository = rentalRepository;
        this.employeeRepository = employeeRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    public Branch convertToBranchEntity(@NotNull BranchDto branchDto){
        Branch branch = new Branch();
        return branch
                .setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                // gaseste rentalul dupa id-ul rentaluluiDto din BranchDto
                .setRental(rentalRepository.getById(branchDto.getBranchId()));

    }

    public BranchDto convertToBranchDto(Branch branch){
        BranchDto branchDto = new BranchDto();
        return branchDto
                .setBranchId(branch.getBranchId())
                .setAddress(branch.getAddress())
                .setRentalId(branch.getRental().getRentalId());
    }

    public Rental convertToRentalEntity(RentalDto rentalDto){
        Rental rental = new Rental();
        rental
                .setRentalId(rentalDto.getRentalId())
                .setNameRental(rentalDto.getNameRental())
                .setInternetDomain(rentalDto.getInternetDomain())
                .setContactAddress(rentalDto.getContactAddress())
                .setOwner(rentalDto.getOwner())
                .setBranches(branchRepository.findAll());
        return rental;
    }

    public RentalDto convertToRentalDTO(Rental rental){
        RentalDto rentalDTO = new RentalDto();
        BranchDto branchDto;
        List<BranchDto> branchDtoList = new ArrayList<>();
        for (Branch localBranch: rental.getBranches()){
            branchDto = convertToBranchDto(localBranch);
            branchDtoList.add(branchDto);
        }
        rentalDTO.setRentalId(rental.getRentalId())
                .setNameRental(rental.getNameRental())
                .setInternetDomain(rental.getInternetDomain())
                .setContactAddress(rental.getContactAddress())
                .setOwner(rental.getOwner())
                .setBranches(branchDtoList);
        return rentalDTO;
    }
}
