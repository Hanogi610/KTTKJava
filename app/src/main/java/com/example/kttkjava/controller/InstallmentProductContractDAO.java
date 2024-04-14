package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.InstallmentProductContract;

@Dao

public interface InstallmentProductContractDAO {
    @Insert
    void insert(InstallmentProductContract installmentProductContract);

}
