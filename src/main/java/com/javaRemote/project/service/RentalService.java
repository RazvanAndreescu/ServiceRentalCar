package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.repository.RentalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository){
        this.rentalRepository=rentalRepository;
    }

    //CREATE
    public Rental createRental(Rental rental){
        return rentalRepository.save(rental);
    }


    //READ
    public List<Rental> getRentals(){
        return rentalRepository.findAll();
    }

    public List<Rental> getRentalsByNameRental(String nameRental){
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

    //UPDATE
    public Rental updateNameRental(int id, String nameRental){
        Rental rental = rentalRepository.getById(id);
        rental.setNameRental(nameRental);
        return rentalRepository.save(rental);
    }

    public Rental updateInternetDomain(int id, String internetDomain){
        Rental rental = rentalRepository.getById(id);
        rental.setInternetDomain(internetDomain);
        return rentalRepository.save(rental);
    }

    public Rental updateOwnerRental(int id, String owner){
        Rental rental = rentalRepository.getById(id);
        rental.setOwner(owner);
        return rentalRepository.save(rental);
    }

    public Rental updateAddressRental(int id, String contactAddress){
        Rental rental = rentalRepository.getById(id);
        rental.setContactAddress(contactAddress);
        return rentalRepository.save(rental);
    }

    //DELETE
    public void deleteRental(Rental rental){
        rentalRepository.delete(rental);
    }

    public void deleteRentalById(int id){
        rentalRepository.deleteById(id);
    }





}
