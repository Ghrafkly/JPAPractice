package com.excercises.inheritance;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Account_Type")
@Table(name = "BANK_ACCOUNT")
public class BankAccount {
    @Id
    @GeneratedValue
    private int id;
    private double balance;
    @ManyToOne
    private BankCustomer customer;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BankCustomer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
