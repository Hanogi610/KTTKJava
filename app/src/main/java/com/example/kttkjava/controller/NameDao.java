package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Name;

@Dao
public interface NameDao {
    @Insert
    void insert(Name name);

    @Query("SELECT * FROM name")
    Name[] getAllNames();

    @Query("SELECT * FROM name WHERE id = :id")
    Name getNameById(int id);
}
