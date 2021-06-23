package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.EmployeeDto;
import com.javaRemote.project.database.entities.Employee;
import com.javaRemote.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ConvertorService convertorService;

    public EmployeeService(EmployeeRepository employeeRepository, ConvertorService convertorService) {
        this.employeeRepository = employeeRepository;
        this.convertorService = convertorService;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findEmployeeByEmployeeId(id);
    }

    public List<EmployeeDto> getAllDtoEmployees(){
        List<EmployeeDto> dtoEmployeeList = new ArrayList<>();
        for(Employee employee: employeeRepository.findAll()){
            dtoEmployeeList.add(convertorService.convertToEmployeeDto(employee));
        }
        return dtoEmployeeList;
    }

    public Employee updateEmployee(int id, Employee jsonEmployee){
        Employee databaseEmployee = employeeRepository.getById(id);
        databaseEmployee
                .setNameEmployee(jsonEmployee.getNameEmployee() != null ? jsonEmployee.getNameEmployee() : databaseEmployee.getNameEmployee())
                .setRoleEmployee(jsonEmployee.getRoleEmployee() != null ? jsonEmployee.getRoleEmployee() : databaseEmployee.getRoleEmployee())
                .setBranch(jsonEmployee.getBranch() != null ? jsonEmployee.getBranch() : databaseEmployee.getBranch());
        return employeeRepository.save(databaseEmployee);
    }

    public void deleteEmployeeById(int id) {
       employeeRepository.deleteById(id);
    }

}
