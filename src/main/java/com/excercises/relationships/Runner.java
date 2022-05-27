package com.excercises.relationships;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPractice");
        EntityManager em = emf.createEntityManager();

        Stream softDev = new Stream("Software Development");
        Stream BABI = new Stream("BABI");

        Trainee john = new Trainee("John", "Doe", softDev);
        Trainee james = new Trainee("James", "Smith", BABI);
        Trainee jane = new Trainee("Jane", "Doe", softDev);

        Module sql = new Module("SQL", Arrays.asList(softDev, BABI));
        Module ood = new Module("OOD", Collections.singletonList(softDev));

        em.getTransaction().begin();
        Arrays.asList(softDev, BABI).forEach(em::persist);
        Arrays.asList(john, james, jane).forEach(em::persist);
        Arrays.asList(sql, ood).forEach(em::persist);
        em.getTransaction().commit();


        Query query = em.createNamedQuery("findByStreamName");
        Query params = query.setParameter("streamName", "BABI");
        List<Stream> streams = params.getResultList();
        System.out.println(streams);

        List<Trainee> trainees = em.createNamedQuery("findByStream")
                .setParameter("streamName", "Software Development")
                .getResultList();
        System.out.println(trainees);
    }
}
