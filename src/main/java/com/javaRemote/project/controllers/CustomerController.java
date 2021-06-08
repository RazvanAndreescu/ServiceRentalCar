package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> printAllCustomers(){
        return customerService.getAllCustomers();
    }

    //Individual work
    @PostMapping("/")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return customer;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        try {
            customerService.updateCustomerName(id, customer.getNameCustomer());
            customerService.updateCustomerEmail(id, customer.getEmail());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomerById(@PathVariable int id){
        try {
            customerService.deleteCustomerById(id);
        } catch (Exception e){
            return false;
        }
        return customerService.getCustomerById(id) == null;
    }

}
