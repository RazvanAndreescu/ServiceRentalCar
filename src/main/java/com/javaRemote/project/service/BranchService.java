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
        return branchRepository.save(convertToBranch(branchDto));
    }

    public List<BranchDto> getAllBranches() {
        List<BranchDto> branchDtoList = new ArrayList<>();

        for (Branch branch : branchRepository.findAll()) {
            branchDtoList.add(convertToBranchDto(branch));
        }

        return branchDtoList;
    }

    public Branch getBranchById(Integer branchId) {
        return branchRepository.getById(branchId);
    }

    public Branch updateBranchAddress(int branchId, BranchDto branchDto) {
        Branch branchToUpdate = branchRepository.getById(branchId);
        Optional<Rental> rentalFromDto = rentalRepository.findById(branchDto.getRentalId());
        Rental rentalToUpdate = rentalFromDto.orElse(null);

        branchToUpdate.setAddress(branchDto.getAddress() != null ? branchDto.getAddress() : branchToUpdate.getAddress())
                .setRental(rentalToUpdate != null ? rentalToUpdate : branchToUpdate.getRental());

        return branchRepository.save(branchToUpdate);
    }

    public void deleteBranchById(Integer branchId) {
        branchRepository.deleteById(branchId);
    }

    private Branch convertToBranch(BranchDto branchDto) {
        Branch branch = new Branch();

        Optional<Rental> rentalFromDto = rentalRepository.findById(branchDto.getRentalId());
        branch.setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                .setRental(rentalFromDto.orElse(null));

        return branch;
    }

    private BranchDto convertToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto();

        branchDto.setBranchId(branch.getBranchId())
                .setAddress(branch.getAddress())
                .setRentalId(branch.getRental() != null ? branch.getRental().getRentalId() : 0);

        return branchDto;
    }
}
