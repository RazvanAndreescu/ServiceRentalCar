package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/")
    public List<RentalDto> printAllRental() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/")
    @ResponseBody
    public Rental createRental(@RequestBody RentalDto rentalDto) {
        return rentalService.createRental(rentalDto);
    }

    @PutMapping("/{rentalId}")
    @ResponseBody
    public boolean updateRental(@PathVariable Integer rentalId, @RequestBody RentalDto rentalDto) {
        if (rentalService.getRentalBy(rentalId) != null) {
            rentalService.updateRental(rentalId, rentalDto);
            return true;
        }

        return false;
    }

    @DeleteMapping("/{rentalId}")
    public boolean deleteRental(@PathVariable Integer rentalId) {
        if (rentalService.getRentalBy(rentalId) != null) {
            try {
                rentalService.deleteRentalById(rentalId);
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return false;
    }
}
