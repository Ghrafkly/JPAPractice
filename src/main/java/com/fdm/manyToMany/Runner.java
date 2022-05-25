package com.fdm.manyToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.Collections;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataAccess");
        EntityManager em = emf.createEntityManager();

        Student t1 = new Student("Zane");
        Student t2 = new Student("Matthew");
        Student t3 = new Student("Kyle");
        Student t4 = new Student("Ben");
        Student t5 = new Student("Max");
        Student t6 = new Student("Alan");

        Hobby h1 = new Hobby("Gaming");
        Hobby h2 = new Hobby("Running");
        Hobby h3 = new Hobby("Music");
        Hobby h4 = new Hobby("Knitting");

        t1.setHobbies(Arrays.asList(h2, h4));
        t2.setHobbies(Arrays.asList(h1, h3));
        t3.setHobbies(Arrays.asList(h1, h2, h3));
        t4.setHobbies(Arrays.asList(h1, h3));
        t5.setHobbies(Arrays.asList(h1, h2, h3, h4));
        t6.setHobbies(Collections.emptyList());

        h1.setTrainees(Arrays.asList(t2, t3, t4, t5));
        h2.setTrainees(Arrays.asList(t1, t3, t5));
        h3.setTrainees(Arrays.asList(t2, t3, t4, t5));
        h4.setTrainees(Arrays.asList(t1, t5));

        em.getTransaction().begin();
        Arrays.asList(t1, t2, t3, t4, t5, t6).forEach(em::persist);
        em.getTransaction().commit();

        Student foundStudent = em.find(Student.class, 4);
        System.out.println(foundStudent);
        Hobby foundHobby = em.find(Hobby.class, 3);
        System.out.println(foundHobby.getTrainees());
    }
}
