package com.fdm.mappedSuperClass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataAccess");
        EntityManager em = emf.createEntityManager();

        Savings savings = new Savings(3.5, 500);
        CheckingAccount checkingAccount = new CheckingAccount(3,500);

        em.getTransaction().begin();
        em.persist(savings);
        em.persist(checkingAccount);
        em.getTransaction().commit();
    }
}
