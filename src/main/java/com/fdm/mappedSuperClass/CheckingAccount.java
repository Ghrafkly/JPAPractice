package com.fdm.mappedSuperClass;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {
    private double minBal;

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double minBal, double balance) {
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
