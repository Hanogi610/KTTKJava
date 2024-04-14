package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.LendingPartner;

@Dao
public interface LendingPartnerDAO {
    @Insert
    void insert(LendingPartner lendingPartner);

    @Query("SELECT * FROM lending_partner")
    LendingPartner[] getAllLendingPartners();

}
