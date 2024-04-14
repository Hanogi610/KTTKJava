package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kttkjava.model.Name;

@Dao
public interface NameDao {
    @Insert
    void insert(Name name);
}
