package com.dotin.course.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Saeed Zarinfam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bid {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ITEM_ID")
    private Item item;

}
