package com.dotin.course.services;

import com.dotin.course.entities.Item;
import com.dotin.course.entities.Message;

import java.util.List;
import java.util.Optional;

/**
 * @author Saeed Zarinfam
 */
public interface ItemService {

    Item save(Item item);

    static ItemService GET(){
        return new ItemServiceImpl();
    }
}
