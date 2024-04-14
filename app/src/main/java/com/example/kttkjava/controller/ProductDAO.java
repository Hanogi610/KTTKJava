package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Product;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Query("SELECT * FROM product WHERE name = :name")
    Product getProductById(String name);

    @Query("SELECT * FROM product")
    Product[] getAllProducts();
}
