package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.EmployeeDto;
import com.javaRemote.project.database.entities.Employee;
import com.javaRemote.project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

   private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<EmployeeDto> printAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    @ResponseBody
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{employeeId}")
    @ResponseBody
    public boolean updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeDto employeeDto){
        if (employeeService.getEmployeeById(employeeId) != null) {
            employeeService.updateEmployee(employeeId, employeeDto);
            return true;
        }

        return false;
    }

    @DeleteMapping("/{employeeId}")
    @ResponseBody
    public boolean deleteEmployee(@PathVariable int employeeId){
        if (employeeService.getEmployeeById(employeeId) != null) {
            employeeService.deleteEmployeeById(employeeId);
            return true;
        }

        return false;
    }
}
