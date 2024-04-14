package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kttkjava.model.Supplier;

@Dao
public interface SupplierDAO {
    @Insert
    void insert(Supplier supplier);
    @Update
    void update(Supplier supplier);
    @Query("SELECT * FROM Supplier WHERE name LIKE :name")
    Supplier[] getSupplierById(String name);
}
