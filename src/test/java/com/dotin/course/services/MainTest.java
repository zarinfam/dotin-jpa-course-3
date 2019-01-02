package com.dotin.course.services;

import com.dotin.course.entities.Item;
import com.dotin.course.entities.Message;
import com.dotin.course.entities.joined.BankAccount;
import com.dotin.course.entities.joined.CreditCard;
import com.dotin.course.utils.EMF;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dotin.course.utils.EMF.runJpaCode;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

/**
 * @author Saeed Zarinfam
 */
public class MainTest {

    @Before
    public void init() {
    }

    @Test
    public void success_test() {
        runJpaCode(em -> {
            persistBA(em, "1", "o1");
            persistBA(em, "2", "o1");
            persistBA(em, "3", "o2");

            persistCC(em, "1", "o1");
            persistCC(em, "2", "o2");
            persistCC(em, "3", "o2");
            persistCC(em, "4", "o3");

            return null;
        }, true);

        runJpaCode(em -> {

            em.createQuery("delete from BillingDetails bd where bd.owner='o1'").executeUpdate();

            return null;
        }, true);

    }
    @Test
    public void success_test_persist() {
        runJpaCode(em -> {
            Item item = new Item();
            item.setTitle("Some Item");
            em.persist(item);
//            Long ITEM_ID = item.getId();
//            System.out.println("-----"+ITEM_ID);

            return null;
        }, true);
    }

    private void persistBA(EntityManager em, String account, String owner) {
        BankAccount bankAccount = BankAccount.builder().account(account).bankname("pasargad").build();
        bankAccount.setOwner(owner);
        em.persist(bankAccount);
    }

    private void persistCC(EntityManager em, String cardNumber, String owner) {
        CreditCard creditCard = CreditCard.builder().cardNumber(cardNumber).build();
        creditCard.setOwner(owner);
        em.persist(creditCard);
    }


}