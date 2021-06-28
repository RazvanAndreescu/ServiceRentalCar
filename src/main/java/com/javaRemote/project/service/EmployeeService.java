package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.EmployeeDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Employee;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private BranchRepository branchRepository;

    public EmployeeService(EmployeeRepository employeeRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
    }

    public Employee createEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(convertToEmployee(employeeDto));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee employee : employeeRepository.findAll()) {
            employeeDtoList.add(convertToEmployeeDto(employee));
        }

        return employeeDtoList;
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId);
    }

    public Employee updateEmployee(int employeeId, EmployeeDto employeeDto) {
        Employee employeeToUpdate = employeeRepository.getById(employeeId);
        Optional<Branch> branchFromDto = branchRepository.findById(employeeDto.getBranchId());
        Branch branchToUpdate = branchFromDto.orElse(null);

        employeeToUpdate
                .setNameEmployee(employeeDto.getNameEmployee() != null ? employeeDto.getNameEmployee() : employeeToUpdate.getNameEmployee())
                .setRoleEmployee(employeeDto.getRoleEmployee() != null ? employeeDto.getRoleEmployee() : employeeToUpdate.getRoleEmployee())
                .setBranch(branchToUpdate != null ? branchToUpdate : employeeToUpdate.getBranch());

        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private Employee convertToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        Optional<Branch> branchFromDto = branchRepository.findById(employeeDto.getBranchId());
        employee.setEmployeeId(employeeDto.getEmployeeId())
                .setNameEmployee(employeeDto.getNameEmployee())
                .setRoleEmployee(employeeDto.getRoleEmployee())
                .setBranch(branchFromDto.orElse(null));

        return employee;
    }

    private EmployeeDto convertToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeId(employee.getEmployeeId())
                .setNameEmployee(employee.getNameEmployee())
                .setRoleEmployee(employee.getRoleEmployee())
                .setBranchId(employee.getBranch() != null ? employee.getBranch().getBranchId() : 0);

        return employeeDto;
    }
}
