package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }


    //Create
    public Rental create(Rental rental) {
        return rentalRepository.save(rental);
    }


    //Read
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public List<Rental> getRentalsByNameRental(String nameRental) {
        return rentalRepository.getRentalByNameRental(nameRental);
    }

    public List<Rental> getRentalsByInternetDomain(String internetDomain){
        return rentalRepository.getRentalByInternetDomain(internetDomain);
    }

    public List<Rental> getRentalsByContactAddress(String contactAddress){
        return rentalRepository.getRentalByContactAddress(contactAddress);
    }

    public List<Rental> getRentalsByOwner(String owner){
        return rentalRepository.getRentalByOwner(owner);
    }


    //Update
    public Rental updatedNameRental(int id, String nameRental) {
        Rental rental = rentalRepository.getById(id);
        rental.setNameRental(nameRental);
        return rentalRepository.save(rental);
    }

    public Rental updateInternetDomain(int id, String internetDomain) {
        Rental rental = rentalRepository.getById(id);
        rental.setInternetDomain(internetDomain);
        return rentalRepository.save(rental);
    }

    public Rental updateContactAddress(int id, String contactAddress) {
        Rental rental = rentalRepository.getById(id);
        rental.setContactAddress(contactAddress);
        return rentalRepository.save(rental);
    }


    public Rental updateOwner(int id, String owner) {
        Rental rental = rentalRepository.getById(id);
        rental.setOwner(owner);
        return rentalRepository.save(rental);
    }


    //Delete
    public void deleteRental(Rental rental) {
        rentalRepository.delete(rental);
    }

    public void deleteRentalById(int id) {
        rentalRepository.deleteById(id);
    }


}
