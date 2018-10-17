package com.dotin.course.services;

import com.dotin.course.entities.Message;

import java.util.List;
import java.util.Optional;

/**
 * @author Saeed Zarinfam
 */
public interface MessageService {

    Message save(Message message);

    List<Message> getAll();

    Optional<Message> get(Long id);

    static MessageService GET(){
        return new MessageServiceImpl();
    }

    void delete(Message message);

    void deleteAll();
}
