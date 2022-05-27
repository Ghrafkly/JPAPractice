package com.excercises.inheritance;

import jakarta.persistence.Entity;

@Entity
public class Company extends BankCustomer {
    private String name;
    private long abn;

    public Company() {
    }

    public Company(String address, String name, long abn) {
        super(address);
        this.name = name;
        this.abn = abn;
    }

    public void addAccount(BankAccount account) {
        super.addAccount(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAbn() {
        return abn;
    }

    public void setAbn(long abn) {
        this.abn = abn;
    }

    // copy toString() from Person class
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", abn=" + abn +
                ", accounts=" + super.getAccounts() +
                '}';
    }
}
