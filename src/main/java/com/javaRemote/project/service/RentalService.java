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

    public Rental createRental(RentalDto rentalDto) {
        return rentalRepository.save(convertToRental(rentalDto));
    }

    public List<RentalDto> getAllRentals() {
        List<RentalDto> rentalDtoList = new ArrayList<>();

        for (Rental rental : rentalRepository.findAll()) {
            rentalDtoList.add(convertToRentalDto(rental));
        }

        return rentalDtoList;
    }

    public Rental getRentalBy(int rentalId) {
        return rentalRepository.getById(rentalId);
    }

    public Rental updateRental(int rentalId, RentalDto rentalDto) {
        Rental rentalToUpdate = rentalRepository.getById(rentalId);

        rentalToUpdate.setNameRental(rentalDto.getNameRental() != null ? rentalDto.getNameRental() : rentalToUpdate.getNameRental())
                .setContactAddress(rentalDto.getContactAddress() != null ? rentalDto.getContactAddress() : rentalToUpdate.getContactAddress())
                .setInternetDomain(rentalDto.getInternetDomain() != null ? rentalDto.getInternetDomain() : rentalToUpdate.getInternetDomain())
                .setOwner(rentalDto.getOwner() != null ? rentalDto.getOwner() : rentalToUpdate.getOwner());

        return rentalRepository.save(rentalToUpdate);
    }

    public void deleteRentalById(int rentalId) {
            rentalRepository.deleteById(rentalId);
    }

    private Rental convertToRental(RentalDto rentalDto) {
        Rental rental = new Rental();

        rental.setRentalId(rentalDto.getRentalId())
                .setNameRental(rentalDto.getNameRental())
                .setInternetDomain(rentalDto.getInternetDomain())
                .setContactAddress(rentalDto.getContactAddress())
                .setOwner(rentalDto.getOwner());

        return rental;
    }

    private RentalDto convertToRentalDto(Rental rental) {
        RentalDto rentalDto = new RentalDto();

        rentalDto.setRentalId(rental.getRentalId())
                .setNameRental(rental.getNameRental())
                .setInternetDomain(rental.getInternetDomain())
                .setContactAddress(rental.getContactAddress())
                .setOwner(rental.getOwner());

        return rentalDto;
    }
}
