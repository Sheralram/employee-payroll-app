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

/**
 * Purpose : To demonstrate various HTTP request methods
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@RestController
@RequestMapping(value = "/employee-payroll-app")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    /**
     * Purpose : This method is used to get list of all the added employee
     *
     * @return the list of employee details
     */
    @GetMapping("/get-all-employee")
    public ResponseEntity<ResponseDto> getAllEmployee() {
        List<Employee> employeePayRollData = employeeService.getAllEmployee();
        ResponseDto responseDTO = new ResponseDto("Get Call Success", employeePayRollData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
    /**
     * Purpose : This method to add new employee data in employee payroll service
     *
     * @param employeePayrollDto defines the input data of employee in DTO  format
     * @return response message if new employee data is added
     */
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeeDto employeePayrollDto) {
        String employeePayRollData = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDTO = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
        return new ResponseEntity<>("Created Employee Payroll Data For", HttpStatus.OK);
    }
    /**
     * Purpose : This method is used to get the employee data by using particular id
     *
     * @param employeeId defines employee id
     * @return employee data corresponding to the  id
     */
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(
            @PathVariable int employeeId) {
        Employee employeePayRollData = employeeService.findEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employeePayRollData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * Purpose : This method is used to update the employee data corresponding to the id
     *
     * @param employeeId defines the employee id
     * @param employeeDTO defines the data in DTO format
     * @return message if data is updated successfully
     */
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<String> updateEmployeePayrollById(
            @PathVariable int employeeId,
            @RequestBody EmployeeDto employeeDTO) {
        String employeePayRollData = employeeService.updateEmployeeById(employeeId, employeeDTO);
        ResponseDto responseDTO = new ResponseDto("Update Employee Payroll Data For ", employeePayRollData);
        return new ResponseEntity<>("Update Employee Payroll Data For", HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to delete the employee details corresponding to it's id
     *
     * @param employeeId defines employee id
     * @return message if employee details of corresponding id is deleted successfully
     */
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeePayroll(
            @PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "deleted id: " + employeeId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
