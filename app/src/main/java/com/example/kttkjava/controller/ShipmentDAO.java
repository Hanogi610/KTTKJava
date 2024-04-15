package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Shipment;

@Dao
public interface ShipmentDAO {
    @Insert
    long insert(Shipment shipment);

    @Query("SELECT * FROM shipment WHERE id = :id")
    Shipment getShipmentById(long id);
}
