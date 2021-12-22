package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.builder.EmployeePayRollBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.NoDataFoundException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeService implements IEmployeeService {
    private static final String EMPLOYEE_ADDED_SUCCESSULLY = "Employee Record is added Successfully ";
    private static final String EMPLOYEE_UPDATED_SUCCESSULLY = "Employee Record is updated Successfully ";
    private static final String EMPLOYEE_DELETED_SUCCESSULLY = "Employee Record is deleted Successfully";
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeePayRollBuilder employeePayRollBuilder;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        return EMPLOYEE_ADDED_SUCCESSULLY;
    }
    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).
                orElseThrow(() -> new NoDataFoundException("Employee data not found of this id :" + employeeId));
    }
    @Override
    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto)  {
        Employee employee = findEmployeeById(employeeId);
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        return EMPLOYEE_UPDATED_SUCCESSULLY;
    }

    @Override
    public String deleteEmployeeById(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        employeeRepository.delete(employee);
        return EMPLOYEE_DELETED_SUCCESSULLY;
    }
}
