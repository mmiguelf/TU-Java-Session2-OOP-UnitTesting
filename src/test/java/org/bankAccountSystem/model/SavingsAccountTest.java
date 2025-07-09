package org.bankAccountSystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private Account account;
    private String accountType = "savings";
    private double interestRate = 0.04;
    private double delta = 0.01;

    @BeforeEach
    void setup(){
        account = account.createAccount(accountType ,101, "testName", 1000d);
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
    @DisplayName("validateSavingsAccountType")
    void shouldValidateSavingsAccountType(){
        assertEquals("savings", account.accountType);
    }
}