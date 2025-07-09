package org.bankAccountSystem;

import org.bankAccountSystem.model.Account;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== Welcome to MyBank ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Compute Interest");
        System.out.println("5. Display Account");
        System.out.println("6. Exit");

        ArrayList<Account> accounts = new ArrayList<>(); //Add switch user pag may time, but for now store created accounts
        Account user = null;
        boolean inUse = true;
        while(inUse) {
            System.out.println();
            System.out.printf("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (choice) {
                case 1: //Create account
                    System.out.printf("Enter Account Type (savings/checking): ");
                    String accountType = scan.nextLine();
                    System.out.printf("Enter Account Number: ");
                    int accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.printf("Enter Holder Name: ");
                    String holderName = scan.nextLine();
                    System.out.printf("Inital Deposit: ");
                    double initalDeposit = scan.nextDouble();

                    user = Account.createAccount(accountType, accountNumber, holderName, initalDeposit);
                    if (user != null){
                        accounts.add(user);
                    }
                    break;
                case 2: //Deposit
                    if (user != null){
                        System.out.printf("Enter deposit amount: ");
                        double deposit = scan.nextDouble();
                        user.deposit(deposit);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 3: //Withdraw
                    if (user != null){
                        System.out.printf("Enter withdraw amount: ");
                        double withdraw = scan.nextDouble();
                        user.withdraw(withdraw);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 4: //Compute Interest
                    if (user != null){
                        user.computeInterest();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 5: //Display account
                    if (user != null){
                        user.displayAccount();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 6: //Exit
                    System.out.println("Thank you!");
                    inUse = false;
                    break;
                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }

    }
}