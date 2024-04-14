package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kttkjava.model.Customer;

@Dao
public interface CustomerDAO {
    @Insert
    void insert(Customer customer);
    @Update
    void update(Customer customer);
    @Delete
    void delete(Customer customer);
    @Query("SELECT * FROM customer")
    Customer[] getAllCustomers();
    @Query("SELECT * FROM customer WHERE id = :id")
    Customer getCustomerById(int id);
}
