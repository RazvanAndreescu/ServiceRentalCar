package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.repository.BranchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BranchService {
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public Branch createBranch(Branch branch){
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }

    public List<Branch> getBranchById(int branchId){
        return branchRepository.getBranchByBranchId(branchId);
    }

    // TODO: 10.06.2021 validation for rentalId;
    public Branch updateBranchAddress(int branchId, Branch branch){
        Branch branchToUpdate = branchRepository.getById(branchId);
        branchToUpdate
                .setAddress(branch.getAddress() != null? branch.getAddress():branchToUpdate.getAddress())
                .setRental(branch.getRental() != null? branch.getRental():branchToUpdate.getRental());
        return branchRepository.save(branchToUpdate);
    }

    public void deleteBranchById(int branchId){
        branchRepository.deleteById(branchId);
    }
}
