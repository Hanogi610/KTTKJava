package com.example.kttkjava.model;

import java.io.Serializable;

public class LPStatistic implements Serializable {
    private String name;
    private float revenue;
    private LendingPartner lendingPartner;

    public LPStatistic(String name, float revenue, LendingPartner lendingPartner) {
        this.name = name;
        this.revenue = revenue;
        this.lendingPartner = lendingPartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public LendingPartner getLendingPartner() {
        return lendingPartner;
    }

    public void setLendingPartner(LendingPartner lendingPartner) {
        this.lendingPartner = lendingPartner;
    }
}
