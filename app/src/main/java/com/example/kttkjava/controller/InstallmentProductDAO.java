package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kttkjava.model.InstallmentProduct;

@Dao
public interface InstallmentProductDAO {
    @Insert
    void insert(InstallmentProduct installmentProduct);
    @Update
    void update(InstallmentProduct installmentProduct);
    @Delete
    void delete(InstallmentProduct installmentProduct);
    @Query("SELECT * FROM installment_product")
    InstallmentProduct[] getAllInstallmentProducts();
    @Query("SELECT * FROM installment_product WHERE id = :id")
    InstallmentProduct getInstallmentProductById(int id);
}
