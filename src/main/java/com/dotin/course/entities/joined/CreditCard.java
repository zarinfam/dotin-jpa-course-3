package com.dotin.course.entities.joined;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue("CC")
@Entity
public class CreditCard extends BillingDetails {

    private String cardNumber;

    private String expMonth;

    private String expYear;

}
