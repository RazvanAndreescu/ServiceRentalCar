package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    /*  public Branch createBranch(Branch branch){
          return branchRepository.save(branch);
      }*/
    public Branch createBranch(BranchDto branchDto) {
        //rentalId
        //validation (check if rental is in the DB)
        return branchRepository.save(branchDto.convertToBranch());
    }

    public List<BranchDto> getAllBranches() {
        List<BranchDto> branchDtoList = new ArrayList<>();
        for (Branch branch : branchRepository.findAll()) {
            branchDtoList.add(branch.convertToDto());
        }
        return branchDtoList;
    }

    public List<Branch> getBranchById(int branchId) {
        return branchRepository.getBranchByBranchId(branchId);
    }

    public Branch updateBranchAddress(int branchId, Branch branch) {
        Branch branchToUpdate = branchRepository.getById(branchId);
        branchToUpdate.setAddress(branch.getAddress() != null ? branch.getAddress() : branchToUpdate.getAddress())
                .setRental(branch.getRental() != null ? branch.getRental() : branchToUpdate.getRental());
        return branchRepository.save(branchToUpdate);
    }

    public void deleteBranch(Branch branch) {
        branchRepository.delete(branch);
    }

    public void deleteBranchById(int branchId) {
        branchRepository.deleteById(branchId);
    }
}
