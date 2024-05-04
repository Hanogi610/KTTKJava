package com.example.kttkjava.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kttkjava.model.CollateralInContract;

@Dao
public interface CollateralInContractDAO {
    @Insert
    void insert(CollateralInContract collateralInContract);

    @Query("DELETE FROM collateral_in_contract WHERE id = :contract_id")
    void delete(int contract_id);
}
