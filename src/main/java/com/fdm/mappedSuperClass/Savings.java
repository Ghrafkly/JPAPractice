package com.fdm.mappedSuperClass;

import jakarta.persistence.Entity;

@Entity
public class Savings extends Account {
    private double interestRate;

    public Savings() {
    }

    public Savings(double balance) {
        super(balance);
    }

    public Savings(double interestRate, double balance) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
