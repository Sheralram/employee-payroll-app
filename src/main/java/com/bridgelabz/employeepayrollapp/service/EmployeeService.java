package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.exception.EmployeeServiceException;
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


    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public String addEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelmapper.map(employeeDto, EmployeeEntity.class);
        employeeRepository.save(employeeEntity);
        return EMPLOYEE_ADDED_SUCCESSULLY;

    }

    public String updateEmployee(int id, EmployeeDto employeeDto) throws EmployeeServiceException {
        Optional<EmployeeEntity>employeeEntityOptional = employeeRepository.findById(id);
        if(employeeEntityOptional.isPresent()){
            EmployeeEntity employeeEntity = new EmployeeEntity();
            modelmapper.map(employeeDto, employeeEntity);
            employeeRepository.save(employeeEntity);
            return EMPLOYEE_UPDATED_SUCCESSULLY;
        }
        throw new EmployeeServiceException("Employee record does not find by id : " +id);
    }

    public String deleteEmployee(int id) {
        Optional<EmployeeEntity>employeeEntity = employeeRepository.findById(id);
                if(employeeEntity.isPresent()){
                    employeeRepository.delete(employeeEntity.get());
                    return EMPLOYEE_DELETED_SUCCESSULLY;
                }
                throw new EmployeeServiceException("Employee record does not deleted by given id : "+id);
    }
}
