package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.service.RentalService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Rental createRental(@RequestBody @Valid RentalDto rentalDto) {
        return rentalService.createRental(rentalDto);
    }

    @PutMapping("/{rentalId}")
    @ResponseBody
    public boolean updateRental(@PathVariable Integer rentalId, @RequestBody RentalDto rentalDto) {
        Rental rentalBeforeUpdate = new Rental(rentalService.getRentalById(rentalId));

        if (rentalService.getRentalById(rentalId) == null) {
            return false;
        }

        return !rentalService.updateRental(rentalId, rentalDto).equals(rentalBeforeUpdate);
    }

    @DeleteMapping("/{rentalId}")
    public boolean deleteRental(@PathVariable Integer rentalId) {
        if (rentalService.getRentalById(rentalId) != null) {
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
