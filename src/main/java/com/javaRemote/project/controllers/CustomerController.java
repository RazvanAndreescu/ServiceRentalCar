package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;



import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @RequestMapping(value = "/listAll", method = GET)
//    @ResponseBody
    @GetMapping("/listAll")
    public List<Customer> printAllCustomers(){
        return customerService.getAllCustomers();
    }
}
