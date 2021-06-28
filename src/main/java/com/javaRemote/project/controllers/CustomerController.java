package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.CustomerDto;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<CustomerDto> printAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/")
    @ResponseBody
    public Customer createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/{customerId}")
    @ResponseBody
    public boolean updateCustomer(@PathVariable int customerId, @RequestBody CustomerDto customerDto){
        if (customerService.getCustomerById(customerId) != null) {
            customerService.updateCustomer(customerId, customerDto);
            return true;
        }

        return false;
    }

    @DeleteMapping("/{customerId}")
    public boolean deleteCustomerById(@PathVariable int customerId) {
        if (customerService.getCustomerById(customerId) != null) {
            customerService.deleteCustomerById(customerId);
            return true;
        }

        return false;
    }
}
