package com.excercises.inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPractice");
        EntityManager em = emf.createEntityManager();

        SavingsAccount savingsAccount = new SavingsAccount(1234.50);
        SavingsAccount savingsAccount2 = new SavingsAccount(10500);

        CheckingAccount checkingAccount = new CheckingAccount(-250);
        CheckingAccount checkingAccount2 = new CheckingAccount(-525.25);

        Person person = new Person("123 Fake Street", "John", "Smith");
        Company company = new Company("456 Real Street", "Google", 123456789);

        // assign person to accounts
        checkingAccount.setCustomer(person);
        savingsAccount.setCustomer(person);
        checkingAccount2.setCustomer(company);
        savingsAccount2.setCustomer(company);

        // add a checking and savings account to person
        person.addAccount(checkingAccount);
        person.addAccount(savingsAccount);

        // add a checking and savings account to company
        company.addAccount(checkingAccount2);
        company.addAccount(savingsAccount2);

        // Persist the objects
        em.getTransaction().begin();
        em.persist(person);
        em.persist(company);
        em.getTransaction().commit();

        // Find the objects
        em.getTransaction().begin();
        Person person2 = em.find(Person.class, person.getId());
        Company company2 = em.find(Company.class, company.getId());
        em.getTransaction().commit();

        // Print the objects
        System.out.println(person2);
        System.out.println(company2);

        // Close the EntityManager

    }
}
