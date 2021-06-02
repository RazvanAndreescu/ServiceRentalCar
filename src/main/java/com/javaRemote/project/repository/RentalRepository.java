package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> getRentalByNameRental(String nameRental);
    List<Rental> getRentalByInternetDomain(String internetDomain);
    List<Rental> getRentalByContactAddress(String contactAddress);
    List<Rental> getRentalByOwner(String owner);
}
