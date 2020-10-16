/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaira428;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wong Keng
 */
public class MainClass {
    
    public static void main(String[] args) throws IOException {
            
        String userChoice = "";
        String userStr = "";
        BankCustomer cust1 = null;
        CoreBanking custAcct1 = null;

        while (!userChoice.equals("Q")) {
            
            Runtime.getRuntime().exec("clear");

            System.out.println("\n************* Banking Operation ****************");
            System.out.println("1. Create Customer\n2. Create Account (Customer must exists)");
            System.out.println("3. Deposit Funds\n4. Withdraw Funds");
            System.out.println("5. Balance Enquiry\n6. Print Customer's Account Details");
            System.out.println("7. Close Account\nQ. To Quit");
            System.out.print("\nPlease enter your choice of operation to perform: ");
            userChoice = System.console().readLine();

            if (userChoice.equals("q"))
                userChoice = userChoice.toUpperCase();

            // System.out.println("userChoice = " + userChoice + " userStr = " + userStr);
            try {
                switch (userChoice) {

                    case "1":
                        // create customer object
                        cust1 = CoreBanking.create_Customer();
                        break;
                    case "2":
                        //Create new account for customer (Customer must exists)
                        custAcct1 = CoreBanking.create_BankAcct (cust1);
                      
                        break;
                    case "3":
                        //Deposit Funds
                        custAcct1.depositFund();
                        //Display Customer's Account Details
                        System.out.println(custAcct1);
                        break;
                    case "4":
                        //Withdraw Funds                        
                        System.out.print("Enter Withdrawal Amount (S$): ");
                        double withdraw = Double.parseDouble(System.console().readLine());
                        custAcct1.withdrawFund(withdraw);
                        
                        break;
                    case "5":
                        //Balance Enquiry
                        System.out.println("Balance in Account is S$" + custAcct1.getAcctBalance());

                        break;
                    case "6":
                        //Display Customer's Account Details
                        System.out.println(custAcct1);
                        break;
                    case "7":
                        //Close Account
                        custAcct1 = custAcct1.closeAccount();
                        break;
                    case "q":
                        System.out.println("Good-bye!");
                        break;
                    case "Q":
                        System.out.println("Good-bye!");
                        break;
                    default:
                        System.out.println("Invalid user input. Please re-enter.");
                }
            }
            catch (Exception e) {
                    System.out.println("Error Msg " + e.getLocalizedMessage());
                    continue;
            }

        }      
    
    }
}
