package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.ProductForSale;

@Dao
public interface ProductForSaleDAO {
    @Insert
    void insert(ProductForSale productForSale);

    @Query("SELECT * FROM product_for_sale")
    ProductForSale[] getAllProductsForSale();

    @Query("SELECT * FROM product_for_sale WHERE id = :id")
    ProductForSale getProductForSaleById(int id);
}
