package com.dotin.course.services;

import com.dotin.course.entities.Message;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

/**
 * @author Saeed Zarinfam
 */
public class MessageServiceTest {

    private MessageService messageService = MessageService.GET();

    private Message message1;
    private Message message2;

    @Before
    public void init() {
        message2 = Message.builder().message("message2").build();

        messageService.save(message2);
    }

    @After
    public void clean() {
        messageService.deleteAll();
    }

    @Test
    public void success_persist_message() {
        message1 = Message.builder().message("hello").build();

        assertThat(message1.getId(), nullValue());

        Message savedMessage = messageService.save(message1);

        assertThat(savedMessage.getId(), notNullValue());

        assertThat(messageService.get(savedMessage.getId())
                , isPresentAnd(samePropertyValuesAs(message1)));

    }

    @Test
    public void success_get_all_messages() {
        Message message3 = messageService.save(Message.builder().message("message3").build());

        List<Message> list = messageService.getAll();

        assertThat(list.size(), equalTo(2));

        assertThat(list.stream().map(Message::getMessage).collect(toList())
                , containsInAnyOrder("message3", "message2"));

    }
}