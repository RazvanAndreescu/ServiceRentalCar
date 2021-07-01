package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.BranchDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.service.BranchService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/")
    public List<BranchDto> printAllBranches() {
        return branchService.getAllBranches();
    }

    @PostMapping("/")
    @ResponseBody
    public Branch createBranch(@RequestBody @Valid BranchDto branchDto) {
        return branchService.createBranch(branchDto);
    }

    @PutMapping("/{branchId}")
    @ResponseBody
    public boolean updateBranch(@PathVariable Integer branchId, @RequestBody BranchDto branchDto) {
        Branch branchBeforeUpdate = new Branch(branchService.getBranchById(branchId));

        if (branchService.getBranchById(branchId) == null) {
            return false;
        }

        return !branchService.updateBranch(branchId, branchDto).equals(branchBeforeUpdate);
    }

    @DeleteMapping("/{branchId}")
    public boolean deleteBranchById(@PathVariable Integer branchId) {
        if (branchService.getBranchById(branchId) != null) {
            try {
                branchService.deleteBranchById(branchId);
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return false;
    }
}
