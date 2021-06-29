package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private BranchRepository branchRepository;
    private RentalRepository rentalRepository;

    public BranchService(BranchRepository branchRepository, RentalRepository rentalRepository) {
        this.branchRepository = branchRepository;
        this.rentalRepository = rentalRepository;
    }

    public Branch createBranch(BranchDto branchDto) {
        return branchRepository.save(convertBranchDtoToBranch(branchDto));
    }

    public List<BranchDto> getAllBranches() {
        List<BranchDto> branchDtoList = new ArrayList<>();

        for (Branch branch : branchRepository.findAll()) {
            branchDtoList.add(convertBranchToBranchDto(branch));
        }

        return branchDtoList;
    }

    public Branch getBranchById(Integer branchId) {
        return branchRepository.getById(branchId);
    }

    public Branch updateBranch(int branchId, BranchDto branchDto) {
        Branch branchToUpdate = branchRepository.getById(branchId);
        Branch inputBranch = convertBranchDtoToBranch(branchDto);

        branchToUpdate.setAddress(inputBranch.getAddress() != null ? inputBranch.getAddress() : branchToUpdate.getAddress())
                .setRental(inputBranch.getRental() != null ? inputBranch.getRental() : branchToUpdate.getRental());

        return branchRepository.save(branchToUpdate);
    }

    public void deleteBranchById(Integer branchId) {
        branchRepository.deleteById(branchId);
    }

    private Branch convertBranchDtoToBranch(BranchDto branchDto) {
        Branch branch = new Branch();

        branch.setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                .setRental(getRentalFromDto(branchDto));

        return branch;
    }

    private BranchDto convertBranchToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto();

        branchDto.setBranchId(branch.getBranchId())
                .setAddress(branch.getAddress())
                .setRentalId(branch.getRental() != null ? branch.getRental().getRentalId() : 0);

        return branchDto;
    }

    private Rental getRentalFromDto(BranchDto branchDto) {
        Rental rental = null;

        try {
            Optional<Rental> rentalFromDto = rentalRepository.findById(branchDto.getRentalId());
            rental = rentalFromDto.orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return rental;
    }
}


