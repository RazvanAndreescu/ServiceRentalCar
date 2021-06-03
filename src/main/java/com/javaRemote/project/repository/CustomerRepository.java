package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByNameCustomerContaining (String nameCustomer);
    List<Customer> findAllByEmailContaining (String email);
    List<Customer> findAllByDrivingExperience (int drivingExperience);
    Customer findCustomerByCustomerId(int customerId);
}
