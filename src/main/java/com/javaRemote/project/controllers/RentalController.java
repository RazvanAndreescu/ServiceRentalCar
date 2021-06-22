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
    public List<RentalDto> printAllRental(){
        return rentalService.getAllRentals();
    }

    @PostMapping("/")
    @ResponseBody
    public Rental createRental(@RequestBody RentalDto rentalDto){
        return rentalService.createRental(rentalDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateRental(@PathVariable int id, @RequestBody Rental rental){
        if(rentalService.getRentalsById(id) != null){
            rentalService.updateRental(id, rental);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteRental(@PathVariable int id){
        if(rentalService.getRentalsById(id) != null){
            rentalService.deleteRentalById(id);
            return true;
        }
        return false;
    }
}
