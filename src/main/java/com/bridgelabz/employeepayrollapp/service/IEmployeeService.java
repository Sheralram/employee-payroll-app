package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> getAllEmployee();

    public String addEmployee(EmployeeDto employeeDto);

    public Employee findEmployeeById(int employeeId);

    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto);

    public String deleteEmployeeById(int employeeId);
}
