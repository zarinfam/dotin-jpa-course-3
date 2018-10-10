package com.dotin.course;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Saeed Zarinfam
 */

@Entity
@Data
@Builder
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
}
