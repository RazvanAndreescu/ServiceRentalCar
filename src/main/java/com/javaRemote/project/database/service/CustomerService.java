package com.javaRemote.project.database.service;

import com.javaRemote.project.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


}
