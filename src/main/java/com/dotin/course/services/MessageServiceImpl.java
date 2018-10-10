package com.dotin.course.services;

import com.dotin.course.entities.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * @author Saeed Zarinfam
 */
public class MessageServiceImpl implements MessageService {

    public final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

    @Override
    public Message save(Message message) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(message);

        em.getTransaction().commit();

        em.close();

        return message;
    }

    @Override
    public List<Message> getAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("select m from Message m").getResultList();

    }

    @Override
    public Optional<Message> get(Long id) {
        return Optional.ofNullable(emf.createEntityManager().find(Message.class, id));
    }
}
