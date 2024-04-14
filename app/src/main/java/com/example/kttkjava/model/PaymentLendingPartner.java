package com.example.kttkjava.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;


public class PaymentLendingPartner {
    @Embedded public Payment payment;
    @Relation(
            parentColumn = "lending_partner_id",
            entityColumn = "id"
    )
    public LendingPartner lendingPartner;
}
