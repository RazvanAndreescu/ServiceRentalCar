package com.javaRemote.project.database.service;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.repository.BranchRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }

    public Branch createBranch(Branch branch){
        return branchRepository.save(branch);
    }
}
