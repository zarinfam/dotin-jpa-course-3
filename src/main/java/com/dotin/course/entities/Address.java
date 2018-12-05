package com.dotin.course.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * @author Saeed Zarinfam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {
    @Column(nullable = false)
    private String street;
    @Column(nullable = false, length = 5)
    private String zipcode;
    @Column(nullable = false)
    private String city;
}
