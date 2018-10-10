package com.dotin.course;

import com.dotin.course.entities.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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

        List<Message> messages = em.createQuery("select m from Message m").getResultList();

        messages.stream().map(Message::getMessage).forEach(System.out::println);
    }

}
