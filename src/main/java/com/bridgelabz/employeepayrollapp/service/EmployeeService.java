package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.NoDataFoundException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static final String EMPLOYEE_ADDED_SUCCESSULLY = "Employee Record is added Successfully " ;
    private static final String EMPLOYEE_UPDATED_SUCCESSULLY = "Employee Record is updated Successfully " ;
    private static final String EMPLOYEE_DELETED_SUCCESSULLY =  "Employee Record is deleted Successfully" ;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelmapper;


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public String addEmployee(EmployeeDto employeeDto) {
        Employee employeeEntity = modelmapper.map(employeeDto, Employee.class);
        employeeRepository.save(employeeEntity);
        return EMPLOYEE_ADDED_SUCCESSULLY;

    }

    public String updateEmployee(int id, EmployeeDto employeeDto) throws NoDataFoundException {
        Optional<Employee>employeeEntityOptional = employeeRepository.findById(id);
        if(employeeEntityOptional.isPresent()){
            Employee employeeEntity = new Employee();
            modelmapper.map(employeeDto, employeeEntity);
            employeeRepository.save(employeeEntity);
            return EMPLOYEE_UPDATED_SUCCESSULLY;
        }
        throw new NoDataFoundException("Employee record does not find by id : " +id);
    }

    public String deleteEmployee(int id) {
        Optional<Employee>employeeEntity = employeeRepository.findById(id);
                if(employeeEntity.isPresent()){
                    employeeRepository.delete(employeeEntity.get());
                    return EMPLOYEE_DELETED_SUCCESSULLY;
                }
                throw new NoDataFoundException("Employee record does not deleted by given id : "+id);
    }
}
