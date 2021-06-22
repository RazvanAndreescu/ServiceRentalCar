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

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental createRental(RentalDto rentalDto){
        return rentalRepository.save(rentalDto.convertToRental());
    }

    public List<RentalDto> getAllRentals() {
        List<RentalDto> rentalDtoList = new ArrayList<>();
        for (Rental rental : rentalRepository.findAll()) {
            rentalDtoList.add(rental.convertToDto());
        }
        return rentalDtoList;
    }

    public Rental getRentalsById(int id) {
        return rentalRepository.getById(id);
    }

    public Rental updateRental(int id, Rental rental) {
        Rental rentalToUpdate = rentalRepository.getById(id);
        rentalToUpdate.setNameRental(rental.getNameRental() != null ? rental.getNameRental() : rentalToUpdate.getNameRental())
                .setContactAddress(rental.getContactAddress() != null ? rental.getContactAddress() : rentalToUpdate.getContactAddress())
                .setInternetDomain(rental.getInternetDomain() != null ? rental.getInternetDomain() : rentalToUpdate.getInternetDomain())
                .setOwner(rental.getOwner() != null ? rental.getOwner() : rentalToUpdate.getOwner());
        return rentalRepository.save(rentalToUpdate);
    }

    public void deleteRentalById(int id) {
        rentalRepository.deleteById(id);
    }
}
