package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.PurchaseInvoice;

@Dao
public interface PurchaseInvoiceDAO {
    @Insert
    long insert(PurchaseInvoice purchaseInvoice);

}
