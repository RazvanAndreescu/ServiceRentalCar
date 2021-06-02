package com.javaRemote.project;

import com.javaRemote.project.database.service.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test implements CommandLineRunner {

    public RentalService rentalService;

    public Test(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void run(String... args) throws Exception {
//        rentalService.updateOwnerRental(1, "Andrew");
//        rentalService.deleteRentalById(2);
//        rentalService.getRentals();
//        log.info(rentalService.getRentals());
    }
}
