package com.fdm.mappedSuperClass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPractice");
        EntityManager em = emf.createEntityManager();

        Savings savings = new Savings(3.5, 500);
        Checking checking = new Checking(3,500);

        em.getTransaction().begin();
        em.persist(savings);
        em.persist(checking);
        em.getTransaction().commit();
    }
}
