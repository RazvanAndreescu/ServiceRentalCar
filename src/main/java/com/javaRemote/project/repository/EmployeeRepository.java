package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByEmployeeId(int id);

    List<Employee> findEmployeesByBranch_BranchId(int branchId);
}
