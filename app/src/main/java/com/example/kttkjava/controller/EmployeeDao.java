package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.Employee;

@Dao
public interface EmployeeDao {
    @Insert
    void insert(Employee employee);
}
