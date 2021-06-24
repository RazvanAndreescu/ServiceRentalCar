package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.CustomerDto;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> printAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/dto")
    public List<CustomerDto> printAllCustomersDto() {
        return customerService.getCustomersDto();
    }

    @PostMapping("/")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        if (customerService.getCustomerById(id) != null) {
            customerService.updateCustomer(id, customer);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomerById(@PathVariable int id) {
        if (customerService.getCustomerById(id) != null) {
            customerService.deleteCustomerById(id);
            return true;
        }
        return false;
    }
}
