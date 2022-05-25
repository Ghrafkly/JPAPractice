package com.fdm.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataAccess");
        EntityManager em = emf.createEntityManager();

        Star star = new Star("Sol", "G2 V Star");
        Planet planet = new Planet("Earth", true);
        Planet planet1 = new Planet("Mars", false);
        Planet planet2 = new Planet("Jupiter", false);
        Planet planet3 = new Planet("Saturn", false);
        Planet planet4 = new Planet("Uranus", false);

        Arrays.asList(planet, planet1, planet2, planet3, planet4).forEach(planet5 -> {
            planet5.setStar(star);
            star.addPlanet(planet5);
        });

        em.getTransaction().begin();
        em.persist(star);
        em.getTransaction().commit();

        Planet foundPlanet = em.find(Planet.class, 2);
        System.out.println(foundPlanet);
    }
}
