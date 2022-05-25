package com.fdm.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataAccess");
        EntityManager em = emf.createEntityManager();

        BoardGame boardGame = new BoardGame("Monopoly",3);
        Publisher publisher = new Publisher("Hasbro");
        boardGame.setPublisher(publisher);
        publisher.setBoardGame(boardGame);

        em.getTransaction().begin();
        em.persist(publisher);
        em.persist(boardGame);
        em.getTransaction().commit();

        Publisher foundPub = em.find(Publisher.class, 1);
        System.out.println(foundPub);
        System.out.println(foundPub.getBoardGame());
    }
}
