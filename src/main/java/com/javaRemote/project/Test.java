package com.javaRemote.project;

import com.javaRemote.project.database.entities.Rental;
import com.javaRemote.project.service.RentalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    private RentalService rentalService;

    public Test(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void run(String... args) throws Exception {
        rentalService.updatedNameRental(1,"RentalName");
    }
}
