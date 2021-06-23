package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final ConvertorService convertorService;

    public RentalService(RentalRepository rentalRepository, ConvertorService convertorService) {
        this.rentalRepository = rentalRepository;
        this.convertorService = convertorService;
    }

    public Rental createRental(Rental rental){
        return rentalRepository.save(rental);
    }

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }

    public Rental getRentalsById(int id){
        return rentalRepository.getById(id);
    }

    public List<RentalDto> getRentals(){
        List<Rental> rentalEntityList = getAllRentals();
        List<RentalDto> rentals = new ArrayList<>();
        for(Rental rental: rentalEntityList){
            rentals.add(convertorService.convertToRentalDTO(rental));
        }
        return rentals;
    }

    public Rental updateRental(int id, Rental rental){
        Rental rentalToUpdate = rentalRepository.getById(id);
        rentalToUpdate
                .setNameRental(rental.getNameRental() != null? rental.getNameRental() : rentalToUpdate.getNameRental())
                .setContactAddress(rental.getContactAddress() != null? rental.getContactAddress() : rentalToUpdate.getContactAddress())
                .setInternetDomain(rental.getInternetDomain() != null? rental.getInternetDomain() : rentalToUpdate.getInternetDomain())
                .setOwner(rental.getOwner() != null? rental.getOwner() : rentalToUpdate.getOwner());
        return rentalRepository.save(rentalToUpdate);
    }

    public void deleteRentalById(int id){
        rentalRepository.deleteById(id);
    }
}
