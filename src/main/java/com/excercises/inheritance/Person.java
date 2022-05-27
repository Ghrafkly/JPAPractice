package com.excercises.inheritance;

import jakarta.persistence.Entity;

@Entity
public class Person extends BankCustomer {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String address, String firstName, String lastName) {
        super(address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        super.addAccount(account);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Override toString() method with accounts
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + super.getAccounts() +
                '}';
    }

}
