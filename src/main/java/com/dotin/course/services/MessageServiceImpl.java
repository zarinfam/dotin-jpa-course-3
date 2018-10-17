package com.dotin.course.services;

import com.dotin.course.entities.Message;
import com.dotin.course.utils.EMF;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

import static com.dotin.course.utils.EMF.*;

/**
 * @author Saeed Zarinfam
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public Message save(Message message) {
        return runJpaCode(em -> {
            em.persist(message);
            return message;
        }, true);
    }

    @Override
    public List<Message> getAll() {
        return runJpaCode(em -> em.createQuery("select m from Message m").getResultList());
    }

    @Override
    public Optional<Message> get(Long id) {
        return runJpaCodeOpt(em -> em.find(Message.class, id));
    }

    @Override
    public void delete(Message message) {
        runJpaCode(em -> {
            em.remove(message);
            return null;
        }, true);
    }

    @Override
    public void deleteAll() {
        runJpaCode(em -> em.createQuery("DELETE FROM Message").executeUpdate(), true);
    }
}
