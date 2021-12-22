package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Purpose : Implement builder to handle BeanUtils so that not to ignore boilerPlate not to break dry principle
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@Component
public class EmployeePayRollBuilder {

    /**
     * Purpose : This method is used to convert the input of DTO into entity using BeanUtils
     *
     * @param employeeDto defines the field of employee in DTO
     * @param employee defines the field of employee in entity
     * @return the fiels of employee in the format of entity
     */
    public Employee buildEmployeePayrollEntity(EmployeeDto employeeDto, Employee employee) {
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }

}
