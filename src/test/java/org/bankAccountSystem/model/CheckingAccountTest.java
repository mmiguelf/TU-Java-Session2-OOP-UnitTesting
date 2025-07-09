package org.bankAccountSystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckingAccountTest {
    private Account account;
    private double interestRate = 0.01;
    private double delta = 0.01;

    @BeforeEach
    void setup(){
        account = new CheckingAccount(101, "testName", 1000d);
    }

    @Test
    @DisplayName("calculateCorrectInterest")
    void shouldCalculateCorrectInterest(){
        double expected = account.balance + (account.balance * interestRate);
        account.computeInterest();
        double actual = account.balance;
        assertEquals(expected, actual, delta);
    }

    @Test
    @DisplayName("validateCheckingAccountType")
    void shouldValidateCheckingAccountType(){
        assertEquals("checking", account.accountType);
    }
}