package com.dotin.course.services;

import com.dotin.course.entities.Message;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Saeed Zarinfam
 */
public class MessageServiceTest {

    private MessageService messageService = MessageService.GET();

    @Test
    public void success_persist_message(){
        Message message = Message.builder().message("hello").build();

        assertThat(message.getId(), nullValue());

        Message savedMessage = messageService.save(message);

        assertThat(savedMessage.getId(), notNullValue());

        messageService.get(savedMessage.getId()).map(m -> {
            assertThat(m.getMessage(), equalTo(message.getMessage()));
            return m;
        }).orElseGet(() -> {
            assertThat(false, equalTo(true));
            return null;
        });
    }
}
