package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee-payroll-app")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/list-all-employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/add-employee-record")
    public String addEmployee(@Valid
                                  @RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping(value = "/update-employee-record/{id}")
    public String updateEmployee(
            @PathVariable int id,
             @Valid
             @RequestBody EmployeeDto employeeDto
    ){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping(value = "/delete-employee-record")
    public String deleteEmployee(
            @RequestParam int id
    ){
      return employeeService.deleteEmployee(id);
    }
}
