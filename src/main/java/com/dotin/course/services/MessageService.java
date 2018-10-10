package com.dotin.course.services;

import com.dotin.course.entities.Message;

import java.util.List;

/**
 * @author Saeed Zarinfam
 */
public interface MessageService {

    Message save(Message message);

    List<Message> getAll();
}
