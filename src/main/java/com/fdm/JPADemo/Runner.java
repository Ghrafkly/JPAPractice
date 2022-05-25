package com.fdm.JPADemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataAccess");
        EntityManager em = emf.createEntityManager();

        Game game = new Game(0, "Elden Ring",10);
        Game game1 = new Game(1, "Kirby",8);
        Game game2 = new Game(2, "Warhammer: Total War",4);

        em.getTransaction().begin();
        em.persist(game);
        em.persist(game1);
        em.persist(game2);
        em.getTransaction().commit();

        Query nativeQuery = em.createNativeQuery("select * from game where rating > 5", Game.class);
        List<Game> goodGames = nativeQuery.getResultList();
        goodGames.forEach(System.out::println);

        Query query = em.createQuery("select g from Game g", Game.class);
        List<Game> allGames = query.getResultList();
        allGames.forEach(System.out::println);
    }
}
