package com.dotin.course.services;

import com.dotin.course.entities.Bid;
import com.dotin.course.entities.Item;

/**
 * @author Saeed Zarinfam
 */
public interface BidService {

    Bid save(Bid bid);

    static BidService GET(){
        return new BidServiceImpl();
    }
}
