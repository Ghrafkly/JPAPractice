package com.excercises.inheritance;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BANK_CUSTOMER")
public class BankCustomer {
    @Id
    @GeneratedValue
    private int id;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer() {
    }

    public BankCustomer(String address) {
        this.address = address;
    }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
