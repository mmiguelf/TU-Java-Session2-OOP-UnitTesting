package org.bankAccountSystem.model;

public class CheckingAccount extends Account{
    public CheckingAccount(int accountNumber, String holderName, double initialDeposit){
        super(accountNumber, holderName, initialDeposit);
        this.accountType = "checking";
        this.interestRate = 0.01;
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
