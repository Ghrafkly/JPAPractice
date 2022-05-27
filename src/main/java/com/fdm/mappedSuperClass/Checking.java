package com.fdm.mappedSuperClass;

import jakarta.persistence.Entity;

@Entity
public class Checking extends Account {
    private double minBal;

    public Checking() {
    }

    public Checking(double balance) {
        super(balance);
    }

    public Checking(double minBal, double balance) {
        super(balance);
        this.minBal = minBal;
    }

    public double getMinBal() {
        return minBal;
    }

    public void setMinBal(double minBal) {
        this.minBal = minBal;
    }


}
