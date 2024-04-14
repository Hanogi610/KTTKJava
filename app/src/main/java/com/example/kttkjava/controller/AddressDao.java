package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kttkjava.model.Address;

@Dao
public interface AddressDao {
    @Insert
    void insert(Address address);
    @Update
    void update(Address address);
    @Delete
    void delete(Address address);
    @Query("SELECT * FROM address")
    Address[] getAllAddresses();
    @Query("SELECT * FROM address WHERE id = :id")
    Address getAddressById(int id);

}
