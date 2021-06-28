package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.CustomerDto;
import com.javaRemote.project.database.dto.RentalDto;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDto customerDto) {
        return customerRepository.save(convertToCustomer(customerDto));
    }

    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : customerRepository.findAll()) {
            customerDtoList.add(convertToCustomerDto(customer));
        }

        return customerDtoList;
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    public Customer updateCustomer(int customerId, CustomerDto customerDto) {
        Customer customerToUpdate = customerRepository.getById(customerId);
        Customer inputCustomer = convertToCustomer(customerDto);

        customerToUpdate
                .setNameCustomer(inputCustomer.getNameCustomer() != null ? inputCustomer.getNameCustomer() : customerToUpdate.getNameCustomer())
                .setEmail(inputCustomer.getEmail() != null ? inputCustomer.getEmail() : customerToUpdate.getEmail())
                .setDrivingExperience(inputCustomer.getDrivingExperience() != null ? inputCustomer.getDrivingExperience() : customerToUpdate.getDrivingExperience());

        return customerRepository.save(customerToUpdate);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

    private Customer convertToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();

        validateDrivingExperience(customerDto);

        customer.setCustomerId(customerDto.getCustomerId())
                .setNameCustomer(customerDto.getNameCustomer())
                .setEmail(customerDto.getEmail())
                .setDrivingExperience(customerDto.getDrivingExperience());

        return customer;
    }

    private CustomerDto convertToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId(customer.getCustomerId())
                .setNameCustomer(customer.getNameCustomer())
                .setEmail(customer.getEmail())
                .setDrivingExperience(customer.getDrivingExperience());

        return customerDto;
    }

    private void validateDrivingExperience(CustomerDto customerDto) {
        if (customerDto.getDrivingExperience() == null) {
            return;
        }

        Integer drivingExperience = customerDto.getDrivingExperience();

        if (drivingExperience < 1) {
            customerDto.setDrivingExperience(1);
        } else if (drivingExperience > 3) {
            customerDto.setDrivingExperience(3);
        }
    }
}

