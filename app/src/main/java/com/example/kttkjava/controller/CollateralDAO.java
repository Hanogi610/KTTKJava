package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.Collateral;

@Dao
public interface CollateralDAO {
    @Insert
    void insert(Collateral collateral);
}
