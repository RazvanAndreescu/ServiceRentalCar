package com.javaRemote.project.controllers;

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
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        if (employeeService.getEmployeeById(id) != null) {
            employeeService.updateEmployee(id, employee);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteEmployee(@PathVariable int id){
        if (employeeService.getEmployeeById(id) != null) {
            employeeService.deleteEmployeeById(id);
            return true;
        }
        return false;
    }
}
