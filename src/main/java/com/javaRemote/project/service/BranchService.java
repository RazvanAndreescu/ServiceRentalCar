package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    //Create
    public Branch create(Branch branch){
        return branchRepository.save(branch);
    }

    //Read
    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }

    public List<Branch> getBranchByAddress(String address){
        return branchRepository.getBranchByAddress(address);
    }

    //Update
    public Branch updateBranchAddress(int id, String address){
        Branch branch = branchRepository.getById(id);
        branch.setAddress(address);
        return branchRepository.save(branch);
    }

    //Delete
    public void deleteBranch(Branch branch){
        branchRepository.delete(branch);
    }

    public void deleteBranchById(int id){
        branchRepository.deleteById(id);
    }
}
