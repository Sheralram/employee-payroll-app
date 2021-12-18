package com.bridgelabz.employeepayrollapp.entity;

import lombok.Data;

import javax.persistence.*;

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
