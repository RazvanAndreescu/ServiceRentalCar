package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.RentalRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental createRental(Rental rental) {
            return rentalRepository.save(rental);
    }

    public List<RentalDto> getAllRentals() {
        List<RentalDto> rentalDtoList = new ArrayList<>();

        for (Rental rental : rentalRepository.findAll()) {
            rentalDtoList.add(convertRentalToRentalDto(rental));
        }

        return rentalDtoList;
    }

    public Rental getRentalById(int rentalId) {
        return rentalRepository.getById(rentalId);
    }

    public Rental updateRental(int rentalId, RentalDto rentalDto) {
        Rental rentalToUpdate = rentalRepository.getById(rentalId);
        Rental inputRental = convertRentalDtoToRental(rentalDto);

        rentalToUpdate.setNameRental(inputRental.getNameRental() != null ? inputRental.getNameRental() : rentalToUpdate.getNameRental())
                .setContactAddress(inputRental.getContactAddress() != null ? inputRental.getContactAddress() : rentalToUpdate.getContactAddress())
                .setInternetDomain(inputRental.getInternetDomain() != null ? inputRental.getInternetDomain() : rentalToUpdate.getInternetDomain())
                .setOwner(inputRental.getOwner() != null ? inputRental.getOwner() : rentalToUpdate.getOwner());

        return rentalRepository.save(rentalToUpdate);
    }

    public void deleteRentalById(int rentalId) {
            rentalRepository.deleteById(rentalId);
    }

    private Rental convertRentalDtoToRental(RentalDto rentalDto) {
        Rental rental = new Rental();

        rental.setRentalId(rentalDto.getRentalId())
                .setNameRental(rentalDto.getNameRental())
                .setInternetDomain(rentalDto.getInternetDomain())
                .setContactAddress(rentalDto.getContactAddress())
                .setOwner(rentalDto.getOwner());

        return rental;
    }

    private RentalDto convertRentalToRentalDto(Rental rental) {
        RentalDto rentalDto = new RentalDto();

        rentalDto.setRentalId(rental.getRentalId())
                .setNameRental(rental.getNameRental())
                .setInternetDomain(rental.getInternetDomain())
                .setContactAddress(rental.getContactAddress())
                .setOwner(rental.getOwner());

        return rentalDto;
    }
}
