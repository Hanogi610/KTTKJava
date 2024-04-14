package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kttkjava.model.Account;

import java.util.List;

@Dao
public interface AccountDao {
    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);

    @Query("SELECT * FROM account")
    List<Account> getAllAccounts();

    @Query("SELECT * FROM account WHERE id = :id")
    Account getAccountById(int id);
}
