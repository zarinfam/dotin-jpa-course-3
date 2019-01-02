package com.dotin.course.services;

import com.dotin.course.entities.Bid;
import com.dotin.course.entities.Item;

import static com.dotin.course.utils.EMF.runJpaCode;

/**
 * @author Saeed Zarinfam
 */
public class BidServiceImpl implements BidService {

    @Override
    public Bid save(Bid bid) {
        return runJpaCode(em -> {
            em.persist(bid);
            return bid;
        }, true);
    }

}
