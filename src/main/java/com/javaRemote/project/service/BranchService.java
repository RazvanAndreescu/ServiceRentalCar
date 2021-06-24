package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.service.convertor.ConvertorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final ConvertorService convertorService;

    public BranchService(BranchRepository branchRepository, ConvertorService convertorService) {
        this.branchRepository = branchRepository;
        this.convertorService = convertorService;
    }

    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public List<Branch> getBranchById(int branchId) {
        return branchRepository.getBranchByBranchId(branchId);
    }

    public List<BranchDto> getAllBranchesDto() {
        List<BranchDto> branchDtoList = new ArrayList<>();
        for (Branch branch : branchRepository.findAll()) {
            branchDtoList.add(convertorService.convertToBranchDto(branch));
        }
        return branchDtoList;
    }

    // TODO: 10.06.2021 validation for rentalId;
    public Branch updateBranchAddress(int branchId, Branch branch) {
        Branch branchToUpdate = branchRepository.getById(branchId);
        branchToUpdate
                .setAddress(branch.getAddress() != null ? branch.getAddress() : branchToUpdate.getAddress())
                .setRental(branch.getRental() != null ? branch.getRental() : branchToUpdate.getRental());
        return branchRepository.save(branchToUpdate);
    }

    public void deleteBranchById(int branchId) {
        branchRepository.deleteById(branchId);
    }
}
