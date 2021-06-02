package com.javaRemote.project;

import com.javaRemote.project.database.repository.CustomerRepository;
import com.javaRemote.project.service.CustomerService;
import com.javaRemote.project.service.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test implements CommandLineRunner {

    public RentalService rentalService;
    public CustomerService customerService;
    public CustomerRepository customerRepository;

    public Test(RentalService rentalService, CustomerService customerService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
//        rentalService.updateOwnerRental(1, "Andrew");
//        rentalService.deleteRentalById(2);
//        rentalService.getRentals();
//        log.info(rentalService.getRentals());

//        customerService.createCustomer(new Customer("Laurentiu Laurentiu", "laurentiu@email.com", 44,null));
//        System.out.println(customerService.getAllCustomers());
//        System.out.println(customerService.getCustomersByName("Stan"));
//        System.out.println(customerService.getCustomersByEmail("tms"));
//        System.out.println(customerService.getCustomerByEmail("tms"));
//        System.out.println(customerService.getCustomersByDrivingExperience(7));
//        customerService.updateCustomerName(26,"Dragos");
//        customerService.updateCustomerEmail(26,"dragos@email.com");
//        customerService.updateCustomerDrivingExperience(26, 4);
//        System.out.println(customerService.getCustomerById(3));
//        customerService.deleteCustomer(customerService.getCustomerById(24));
//        customerService.deleteCustomerById(23);


    }
}
