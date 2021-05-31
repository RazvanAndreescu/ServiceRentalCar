package com.javaRemote.project.database.populator;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.database.service.CustomerService;
import org.springframework.boot.CommandLineRunner;

public class CustomerPopulator implements CommandLineRunner {

    private Customer customer = new Customer(



    );

    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
//        customerService.createCustomer(customer);
    }
}
