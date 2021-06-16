package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.database.mapper.RentalMapper;
import com.javaRemote.project.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private RentalService rentalService;

    private RentalMapper rentalMapper;

    public RentalController(RentalService rentalService, RentalMapper rentalMapper) {
        this.rentalService = rentalService;
        this.rentalMapper = rentalMapper;
    }

    @GetMapping("/")
    public List<Rental> printAllRental(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/dtoRentals")
    public List<RentalDto> printAllDtoRentals(){
        return rentalMapper.getRentals();
    }

    @PostMapping("/")
    @ResponseBody
    public Rental createRental(@RequestBody Rental rental){
        rentalService.createRental(rental);
        return rental;
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
