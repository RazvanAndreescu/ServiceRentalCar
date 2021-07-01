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
    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;

    public EmployeeService(EmployeeRepository employeeRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
    }

    public Employee createEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(convertEmployeeDtoToEmployee(employeeDto));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee employee : employeeRepository.findAll()) {
            employeeDtoList.add(convertEmployeeToEmployeeDto(employee));
        }

        return employeeDtoList;
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId);
    }

    public Employee updateEmployee(int employeeId, EmployeeDto employeeDto) {
        Employee employeeToUpdate = employeeRepository.getById(employeeId);
        Employee inputEmployee = convertEmployeeDtoToEmployee(employeeDto);

        employeeToUpdate
                .setNameEmployee(inputEmployee.getNameEmployee() != null ? inputEmployee.getNameEmployee() : employeeToUpdate.getNameEmployee())
                .setRoleEmployee(inputEmployee.getRoleEmployee() != null ? inputEmployee.getRoleEmployee() : employeeToUpdate.getRoleEmployee())
                .setBranch(inputEmployee.getBranch() != null ? inputEmployee.getBranch() : employeeToUpdate.getBranch());

        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private Employee convertEmployeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setEmployeeId(employeeDto.getEmployeeId())
                .setNameEmployee(employeeDto.getNameEmployee())
                .setRoleEmployee(employeeDto.getRoleEmployee())
                .setBranch(getBranchFromEmployeeDto(employeeDto));

        return employee;
    }

    private EmployeeDto convertEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeId(employee.getEmployeeId())
                .setNameEmployee(employee.getNameEmployee())
                .setRoleEmployee(employee.getRoleEmployee())
                .setBranchId(employee.getBranch() != null ? employee.getBranch().getBranchId() : 0);

        return employeeDto;
    }

    private Branch getBranchFromEmployeeDto(EmployeeDto employeeDto) {
        Branch branch = null;

        try {
            Optional<Branch> branchFromDto = branchRepository.findById(employeeDto.getBranchId());
            branch = branchFromDto.orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return branch;
    }
}
