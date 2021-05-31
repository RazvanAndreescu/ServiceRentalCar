package com.javaRemote.project.database.pop;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.database.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerPopulator implements CommandLineRunner {

    private final Customer customer = new Customer(
            "Laurentiu",
            "laurentiu@email.com",
            1,
            null
    );

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.createCustomer(customer);
    }
}
