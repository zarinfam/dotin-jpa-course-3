package com.dotin.course.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Saeed Zarinfam
 */

@Data
@Builder
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
}
