package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Purpose : To demonstrate all the fields of EmployeePayroll repository connected with JpaRepository format
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
