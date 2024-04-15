package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.PurchaseProduct;

@Dao
public interface PurchaseProductDAO {
    @Insert
    long insert(PurchaseProduct purchaseProduct);

    @Query("SELECT * FROM purchase_product WHERE id = :id")
    PurchaseProduct getPurchaseProductById(long id);


}
