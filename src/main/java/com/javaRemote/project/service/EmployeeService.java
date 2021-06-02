package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Employee;
import com.javaRemote.project.database.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Create
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }


    //Read
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByNameEmployee(String nameEmployee) {
        return employeeRepository.getEmployeeByNameEmployee(nameEmployee);
    }

    public List<Employee> getEmployeeByRoleEmployee(String roleEmployee){
        return employeeRepository.getEmployeeByRoleEmployee(roleEmployee);
    }




    //Update
    public Employee updateNameEmployee(int id, String nameEmployee) {
        Employee employee = employeeRepository.getById(id);
        employee.setNameEmployee(nameEmployee);
        return employeeRepository.save(employee);
    }

    public Employee updateRoleEmployee(int id, String roleEmployee) {
        Employee employee = employeeRepository.getById(id);
        employee.setRoleEmployee(roleEmployee);
        return employeeRepository.save(employee);
    }


    //Delete
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteEmployeeById(int id) {
       employeeRepository.deleteById(id);
    }

}
