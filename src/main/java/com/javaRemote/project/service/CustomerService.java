package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // CREATE
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // READ
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByName(String customerName){
        return customerRepository.findAllByNameCustomer(customerName);
    }

    public List<Customer> getCustomersByEmail(String email){
        return customerRepository.findAllByEmail(email);
    }

    public List<Customer> getCustomersByDrivingExperience(int drivingExperience){
        return customerRepository.findAllByDrivingExperience(drivingExperience);
    }


    // UPDATE
    public Customer updateCustomerName(int id, String customerName){
        Customer customer = customerRepository.getById(id);
        customer.setNameCustomer(customerName);
        return customerRepository.save(customer);
    }

    public Customer updateCustomerEmail(int id, String customerEmail){
        Customer customer = customerRepository.getById(id);
        customer.setEmail(customerEmail);
        return customerRepository.save(customer);
    }

    public Customer updateCustomerDrivingExperience(int id, int customerDrivingExperience){
        Customer customer = customerRepository.getById(id);
        customer.setDrivingExperience(customerDrivingExperience);
        return customerRepository.save(customer);
    }

    // DELETE
    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);
    }
}

