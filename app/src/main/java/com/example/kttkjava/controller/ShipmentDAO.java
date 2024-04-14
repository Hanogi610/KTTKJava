package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.Shipment;

@Dao
public interface ShipmentDAO {
    @Insert
    void insert(Shipment shipment);
}
