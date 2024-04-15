package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Employee;

@Dao
public interface EmployeeDao {
    @Insert
    void insert(Employee employee);
    @Query("SELECT * FROM employee")
    Employee[] getAllEmployee();
}
