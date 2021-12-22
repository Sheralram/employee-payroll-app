package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.builder.EmployeePayRollBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.NoDataFoundException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Purpose : To implement all the methods in controller class
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@Service
public class EmployeeService implements IEmployeeService {
    private static final String EMPLOYEE_ADDED_SUCCESSULLY = "Employee Record is added Successfully ";
    private static final String EMPLOYEE_UPDATED_SUCCESSULLY = "Employee Record is updated Successfully ";
    private static final String EMPLOYEE_DELETED_SUCCESSULLY = "Employee Record is deleted Successfully";
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeePayRollBuilder employeePayRollBuilder;

    /**
     * Purpose : This method is used to get list of details of all the employees
     *
     * @return the list of employeed added
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    /**
     * Purpose : This method is used to add the details of employee
     *
     * @param employeeDto defines data added in DTO
     * @return message if data is added successfully;
     */
    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        return EMPLOYEE_ADDED_SUCCESSULLY;
    }
    /**
     * Purpose : This method is used to find the details of employee corresponding to the id
     *
     * @param employeeId defines the id of the employee
     * @return the details of the particular employee
     */
    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).
                orElseThrow(() -> new NoDataFoundException("Employee data not found of this id :" + employeeId));
    }
    /**
     * Purpose : This method is used to update the details of the employee of corresponding id
     *
     * @param employeeId defines employee id
     * @param employeeDto defines the data stores in employee DTO
     * @return the message if updated successfully
     */
    @Override
    public String updateEmployeeById(int employeeId, EmployeeDto employeeDto)  {
        Employee employee = findEmployeeById(employeeId);
        employee = employeePayRollBuilder.buildEmployeePayrollEntity(employeeDto,employee);
        employeeRepository.save(employee);
        return EMPLOYEE_UPDATED_SUCCESSULLY;
    }
    /**
     * Purpose : This method is used to delete the employee details of corressponding id
     *
     * @param employeeId defines employee id
     * @return message if deleted successfully
     */
    @Override
    public String deleteEmployeeById(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        employeeRepository.delete(employee);
        return EMPLOYEE_DELETED_SUCCESSULLY;
    }
}
