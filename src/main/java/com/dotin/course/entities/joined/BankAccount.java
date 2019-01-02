package com.dotin.course.entities.joined;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue("BA")
@Entity
public class BankAccount extends BillingDetails {

    private String account;

    private String bankname;

    private String swift;

}
