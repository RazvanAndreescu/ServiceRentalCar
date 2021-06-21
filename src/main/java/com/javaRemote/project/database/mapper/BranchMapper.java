package com.javaRemote.project.database.mapper;

import com.javaRemote.project.service.RentalService;
import org.springframework.stereotype.Service;

@Service
public class BranchMapper {
    private RentalService rentalService;

    public BranchMapper(RentalService rentalService) {
        this.rentalService = rentalService;
    }
}
