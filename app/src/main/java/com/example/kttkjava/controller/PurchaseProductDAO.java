package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.PurchaseProduct;

@Dao
public interface PurchaseProductDAO {
    @Insert
    void insert(PurchaseProduct purchaseProduct);
}
