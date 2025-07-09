package org.bankAccountSystem.model;

public abstract class Account {
    String accountType;
    int accountNumber;
    String holderName;
    double balance;
    double interestRate;

    public Account (int accountNumber, String holderName, double initalDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        if (initalDeposit > 0d) {
            this.balance = initalDeposit;
        } else {
            System.out.println("Deposit cannot be negative.");
        }
    }

    public abstract void computeInterest();

    public void deposit(double amount){
        if (amount > 0d) {
            balance += amount;
            String formattedAmount = String.format("%.2f", amount);
            String formattedBalance = String.format("%.2f", balance);
            System.out.println("Deposited " +formattedAmount+ ". New balance: " +formattedBalance+".");
        } else {
            System.out.println("Deposit cannot be negative.");
        }
    }

    public void withdraw(double amount){
        if (amount > 0d) {
            if (amount < balance) {
                balance -= amount;
                String formattedAmount = String.format("%.2f", amount);
                String formattedBalance = String.format("%.2f", balance);
                System.out.println("Withdrew " + formattedAmount + ". New balance: " + formattedBalance + ".");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdraw cannot be negative.");
        }
    }

    public void displayAccount() {
        System.out.println("--- Account Information ---");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+holderName);
        System.out.println("Account Type: "+accountType);
        String formattedBalance = String.format("%.2f", balance);
        System.out.println("Balance: "+formattedBalance);
    }

    public static Account createAccount(String accountType, int accountNumber, String holderName, double initalDeposit) {
        if (accountType.equalsIgnoreCase("savings")) {
            return new SavingsAccount(accountNumber, holderName, initalDeposit);
        } else if (accountType.equalsIgnoreCase("checking")) {
            return new CheckingAccount(accountNumber, holderName, initalDeposit);
        } else {
            System.out.println("Invalid account type.");
        }
        return null;
    }
}
