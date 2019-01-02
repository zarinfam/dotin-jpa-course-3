package com.dotin.course.services;

import com.dotin.course.entities.Bid;
import com.dotin.course.entities.Item;
import com.dotin.course.entities.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

/**
 * @author Saeed Zarinfam
 */
public class ItemServiceTest {

    private ItemService itemService = ItemService.GET();
    private BidService bidService = BidService.GET();

    @Before
    public void init() {
    }

//    @Test
//    public void success_persist_item() {
//        Item item = Item.builder()
//                .title("test product")
//                .images(new HashSet<>(Arrays.asList("image1", "image2")))
//                .build();
//
//        HashSet<Bid> bids = new HashSet<>(Arrays.asList(
//                Bid.builder().amount(1000l).build()));
//
//        item.setBids(bids);
//
//        Item savedItem = itemService.save(item);
//
//        assertThat(savedItem.getId(), notNullValue());
//
//
//    }

    @Test
    public void success_assign_bid_to_item() {
        Item item = Item.builder()
                .title("test product")
                .images(new HashSet<>(Arrays.asList("image1", "image2")))
                .build();

        Item savedItem = itemService.save(item);

        bidService.save(Bid.builder().amount(1000l).item(item).build());


        assertThat(savedItem.getId(), notNullValue());



    }

}