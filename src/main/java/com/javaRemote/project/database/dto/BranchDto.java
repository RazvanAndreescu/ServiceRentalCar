package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BranchDto implements Serializable {
    private Integer branchId;
    private String address;
    private Integer rentalId;

    public BranchDto setBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    public BranchDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public BranchDto setRentalId(int rentalId) {
        this.rentalId = rentalId;
        return this;
    }
}
