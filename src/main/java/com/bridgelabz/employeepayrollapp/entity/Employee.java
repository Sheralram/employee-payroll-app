package com.bridgelabz.employeepayrollapp.entity;

import lombok.Data;

import javax.persistence.*;
/**
 * Purpose : To demonstrate all the fields of employee in the entity databse format
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    private String department;

    @Column(name = "START_DATE")
    private String joiningDate;

    @Column(name = "SALARY")
    private long salary;

    @Column(name = "NOTES")
    private String notes;
}
