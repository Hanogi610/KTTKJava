package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.Payment;

@Dao
public interface PaymentDAO {

    @Insert
    void insert(Payment payment);

}
