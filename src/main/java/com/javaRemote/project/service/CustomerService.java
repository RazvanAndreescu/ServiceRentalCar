package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    public Customer updateCustomer(int id, Customer customer) {
        Customer customerToUpdate = customerRepository.getById(id);
        customerToUpdate
                .setNameCustomer(customer.getNameCustomer() != null ? customer.getNameCustomer() : customerToUpdate.getNameCustomer())
                .setEmail(customer.getEmail() != null ? customer.getEmail() : customerToUpdate.getEmail())
                .setDrivingExperience(customer.getDrivingExperience() != 0 ? customer.getDrivingExperience() : customerToUpdate.getDrivingExperience());
        return customerRepository.save(customerToUpdate);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}

