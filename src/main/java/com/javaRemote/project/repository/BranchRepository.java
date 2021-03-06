package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    List<Branch> getBranchByAddress(String address);
    List<Branch> getBranchByBranchId(int branchId);
}
