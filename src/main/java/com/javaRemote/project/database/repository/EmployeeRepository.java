package com.javaRemote.project.database.repository;

import com.javaRemote.project.database.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> getEmployeeByNameEmployee(String nameEmployee);
    List<Employee> getEmployeeByRoleEmployee(String roleEmployee);
}
