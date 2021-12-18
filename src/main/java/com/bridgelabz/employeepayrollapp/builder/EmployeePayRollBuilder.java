package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeePayRollBuilder {

    public Employee buildEmployeePayrollEntity(EmployeeDto employeeDto, Employee employee) {
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }

}
