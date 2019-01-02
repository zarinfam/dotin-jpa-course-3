package com.dotin.course.services;

import com.dotin.course.entities.Item;
import com.dotin.course.entities.Message;

import java.util.List;
import java.util.Optional;

import static com.dotin.course.utils.EMF.runJpaCode;
import static com.dotin.course.utils.EMF.runJpaCodeOpt;

/**
 * @author Saeed Zarinfam
 */
public class ItemServiceImpl implements ItemService {

    @Override
    public Item save(Item item) {
        return runJpaCode(em -> {
            em.persist(item);
            return item;
        }, true);
    }

}
