package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.service.BranchService;
import com.javaRemote.project.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/")
    public List<Branch> printAllBranches() {
        return branchService.getAllBranches();
    }

    @PostMapping("/")
    @ResponseBody
    public Branch createBranch(@RequestBody Branch branch) {
        branchService.createBranch(branch);
        return branch;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateBranch(@PathVariable int id, @RequestBody Branch branch){
        if (branchService.getBranchById(id) != null) {
            branchService.updateBranchAddress(id, branch);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteBranchById(@PathVariable int id) {
        if (branchService.getBranchById(id) != null) {
            branchService.deleteBranchById(id);
            return true;
        }
        return false;
    }
}
