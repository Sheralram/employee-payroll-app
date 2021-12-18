package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class EmployeeDto {
    //private int id;
    private String firstName;
    private String lastName;
    private String salary;

}
