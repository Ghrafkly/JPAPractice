package com.excercises.inheritance;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends BankAccount {
    public SavingsAccount() {
    }

    public SavingsAccount(double balance) {
        super(balance);
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
