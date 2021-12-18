package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee-payroll-app")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all-employee")
    public ResponseEntity<ResponseDto> getAllEmployee() {
        List<Employee> employeePayRollData = employeeService.getAllEmployee();
        ResponseDto responseDTO = new ResponseDto("Get Call Success", employeePayRollData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeeDto employeePayrollDto) {
        String employeePayRollData = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDTO = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
        return new ResponseEntity<>("Created Employee Payroll Data For", HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(
            @PathVariable int employeeId) {
        Employee employeePayRollData = employeeService.findEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employeePayRollData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<String> updateEmployeePayrollById(
            @PathVariable int employeeId,
            @RequestBody EmployeeDto employeeDTO) {
        String employeePayRollData = employeeService.updateEmployeeById(employeeId, employeeDTO);
        ResponseDto responseDTO = new ResponseDto("Update Employee Payroll Data For ", employeePayRollData);
        return new ResponseEntity<>("Update Employee Payroll Data For", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeePayroll(
            @PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "deleted id: " + employeeId);
        //return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
