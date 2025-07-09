package org.bankAccountSystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AccountTest {
    private Account account;
    private String accountType = "savings";
    private int accountNumber = 101;
    private String holderName = "testName";
    private double initialDeposit = 1000d;
    private double delta = 0.01;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup(){
        account = account.createAccount(accountType, accountNumber, holderName, initialDeposit);
    }

    @Test
    @DisplayName("validateAccountCreation")
    void shouldValidateAccountCreation(){
        assertEquals(accountType, account.accountType);
        assertEquals(accountNumber, account.accountNumber);
        assertEquals(holderName, account.holderName);
        assertEquals(initialDeposit, account.balance);
    }

    @Test
    @DisplayName("validateAccountCreationInvalidAccountType")
    void shouldValidateAccountCreationInvalidAccountType(){
        Account dudAccount = null;
        dudAccount = account.createAccount("fakeType", accountNumber, holderName, initialDeposit);
        assertNull(dudAccount);
    }

    @Test
    @DisplayName("validateDepositAccuracy")
    void shouldValidateDepositeAccuracy(){
        double depositAmount = 500;
        double expected = initialDeposit + depositAmount;
        account.deposit(depositAmount);
        double actual = account.balance;
        assertEquals(expected, actual, delta);
    }

    @Test
    @DisplayName("validateDepositInvalidAmount")
    void shouldValidateDepositInvalidAmount(){
        double depositAmount = -500;
        account.deposit(depositAmount);
        double actual = account.balance;
        assertEquals(initialDeposit, actual, delta);
    }

    @Test
    @DisplayName("validateInitialDepositInvalidAmount")
    void shouldValidateInitialDepositInvalidAmount(){
        initialDeposit = -500;
        Account dudAccount = null;
        dudAccount = account.createAccount(accountType, accountNumber, holderName, initialDeposit);
        assertNull(dudAccount);
    }


    @Test
    @DisplayName("validateWithdrawAccuracy")
    void shouldValdiateWithdrawAccuracy(){
        double withdrawAmount = 200;
        double expected = initialDeposit - withdrawAmount;
        account.withdraw(withdrawAmount);
        double actual = account.balance;
        assertEquals(expected, actual, delta);
    }

    @Test
    @DisplayName("validateWithdrawInvalidAmount")
    void shouldValidateWithdrawInvalidAmount(){
        double withdrawAmount = -500;
        account.withdraw(withdrawAmount);
        double actual = account.balance;
        assertEquals(initialDeposit, actual, delta);
    }

    @Test
    @DisplayName("validateWithdrawExceedingFunds")
    void shouldValidateWithdrawExceedingFunds(){
        double withdrawAmount = initialDeposit + 1000;
        account.withdraw(withdrawAmount);
        double actual = account.balance;
        assertEquals(initialDeposit, actual, delta);
    }

//    @Test
//    @DisplayName("validateDisplayAccount")
//    void shouldValidateDisplayAccount(){
//        System.setOut(new PrintStream(outputStream));
//    }
}