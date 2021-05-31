package com.javaRemote.project.database.service;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.database.repository.BranchRepository;
import com.javaRemote.project.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}

