package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.CollateralInContract;

@Dao
public interface CollateralInContractDAO {
    @Insert
    void insert(CollateralInContract collateralInContract);
}
