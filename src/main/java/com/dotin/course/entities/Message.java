package com.dotin.course.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Saeed Zarinfam
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String message;
}
