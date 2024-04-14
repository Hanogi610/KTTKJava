package com.example.kttkjava.controller;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.Person;

@Dao
public interface PersonDao {
    @Insert
    void insert(Person person);

    @Query("SELECT * FROM person")
    Person[] getAllPersons();

    @Query("SELECT * FROM person WHERE id = :id")
    Person getPersonById(int id);
}
