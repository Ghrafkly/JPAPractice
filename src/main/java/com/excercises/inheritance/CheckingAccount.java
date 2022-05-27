package com.excercises.inheritance;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends BankAccount {
    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
