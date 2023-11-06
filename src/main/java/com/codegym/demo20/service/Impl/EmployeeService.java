package com.codegym.demo20.service.Impl;

import com.codegym.demo20.dto.EmployeeDto;
import com.codegym.demo20.entity.Branch;
import com.codegym.demo20.entity.Employee;
import com.codegym.demo20.repository.BranchRepository;
import com.codegym.demo20.repository.EmployeeRepository;
import com.codegym.demo20.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setCode(employee.getCode());
            employeeDto.setSalary(employee.getSalary());
            employeeDto.setBrandId(employee.getBranch().getId());
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not Found"));
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setCode(employee.getCode());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setBrandId(employee.getBranch().getId());
        return employeeDto;
    }

    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setCode(employeeDto.getCode());
        employee.setSalary(employeeDto.getSalary());
        Branch branch = branchRepository.findById(employeeDto.getBrandId())
                .orElseThrow(()-> new IllegalArgumentException("Not Found"));
        employee.setBranch(branch);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployeeByBranchId(int id) {
        List<Employee> employees = employeeRepository.findByBranchId(id);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setCode(employee.getCode());
            employeeDto.setSalary(employee.getSalary());
            employeeDto.setBrandId(employee.getBranch().getId());
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }
}
