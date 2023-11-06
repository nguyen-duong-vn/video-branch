package com.codegym.demo20.repository;

import com.codegym.demo20.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByBranchId(int id);
}
