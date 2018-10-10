package com.dotin.course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Saeed Zarinfam
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(Message.builder().message("hello").build());

        em.getTransaction().commit();
    }

}
