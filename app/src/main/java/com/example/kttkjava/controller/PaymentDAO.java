package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Payment;

@Dao
public interface PaymentDAO {

    @Insert
    void insert(Payment payment);

    @Query("SELECT * FROM payment")
    Payment[] getAll();

    @Query("SELECT * FROM payment WHERE lending_partner_id = :id")
    Payment getPaymentOfLendingPartnerById(int id);
}
