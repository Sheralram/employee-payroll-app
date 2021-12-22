package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;

import java.util.List;
/**
 * Purpose : To implement all the methods of service class
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
public interface IEmployeeService {

    public List<Employee> getAllEmployee();

    public String addEmployee(EmployeeDto employeeDto);

    public Employee findEmployeeById(int employeeId);

    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto);

    public String deleteEmployeeById(int employeeId);
}
