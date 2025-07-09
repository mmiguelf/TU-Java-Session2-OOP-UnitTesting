package org.bankAccountSystem.model;

public class CheckingAccount extends Account{
    public CheckingAccount(String accountType, int accountNumber, String holderName, double initialDeposit){
        super(accountType, accountNumber, holderName, initialDeposit);
        this.interestRate = 0.04;
        System.out.println("Account created successfuly!");
    }

    public void computeInterest (){
        System.out.println("Computing interest for account "+accountNumber+"...");
        double interest = balance * interestRate;
        String formattedInterest = String.format("%.2f", interest);
        System.out.println("Interest earned: "+formattedInterest);
        balance += interest;
        String formattedBalance = String.format("%.2f", balance);
        System.out.println("New balance: "+formattedBalance);
    }
}
