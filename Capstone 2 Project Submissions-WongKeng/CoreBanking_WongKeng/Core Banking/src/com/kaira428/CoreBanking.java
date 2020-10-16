/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaira428;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Wong Keng
 */
public class CoreBanking {
    
    static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    String acctID;
    String acctType;
    BankCustomer bankCust;
    String acctCreationDateString;
    double acctBalance;
    double acctMinBal;
    
    enum MinVal {
        SAVING (200.0d),
        FD (1000.0d),
        CHILD (0.0d);
        
        private final double minSum;
        
        MinVal (double minSum) {
            this.minSum = minSum;
        }

        public double getMinSum() {
            return minSum;
        }       
            
    }

    @Override
    public String toString() {
        return "\n++++++++\nSavings Account:" + "\nAccount ID=" + acctID + "\nAccount Type=" + acctType + "\n-----\nCustomer Details:" + bankCust + "\nAccount Creation Date=" + acctCreationDateString 
                + "\nAccount Balance (S$)=" + acctBalance + "\nMinimum Balance (S$)=" + acctMinBal;
    }

    public CoreBanking(String acctID, String acctType, BankCustomer bankCust, String acctCreationDateString, double acctBalance) {
        this.acctID = acctID;
        this.acctType = acctType;
        this.bankCust = bankCust;
        this.acctCreationDateString = acctCreationDateString;
        this.acctBalance = acctBalance;
    }
    
    public String getAcctID() {
        return acctID;
    }

    public void setAcctID(String acctID) {
        this.acctID = acctID;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public BankCustomer getBankCust() {
        return bankCust;
    }

    public void setBankCust(BankCustomer bankCust) {
        this.bankCust = bankCust;
    }

    public void setAcctCreationDateString(String acctCreationDateString) {
        this.acctCreationDateString = acctCreationDateString;
    }

    public double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(double acctBalance) {
        this.acctBalance = acctBalance;
    }

    public double getAcctMinBal() {
        return acctMinBal;
    }

    public void setAcctMinBal(double acctMinBal) {
        this.acctMinBal = acctMinBal;
    }
    
    public static BankCustomer create_Customer() {
        
        System.out.print("First Name: ");
        String firstName = System.console().readLine();
        System.out.print("Last Name: ");
        String lastName = System.console().readLine();
        System.out.print("NRIC: ");
        String nric = System.console().readLine();
        System.out.print("Nationality: ");
        String nationality = System.console().readLine();
        System.out.print("Date of Birth (dd-MMM-yyyy): ");
        String dobStr = System.console().readLine();
        
        BankCustomer temp_Cust1 = new BankCustomer(firstName, lastName, nric, nationality, dobStr);
        
        return temp_Cust1;
    }
    
    public static CoreBanking create_BankAcct (BankCustomer custObj) {
        
        CoreBanking accountObj = null;
        
        String temp_AcctID = custObj.getNric();
        
        System.out.print("Type of Account (Savings, Child, FD) : ");
        String temp_AcctType = System.console().readLine();
        
        System.out.print("Amount to Deposit (S$): ");
        double balance = Double.parseDouble(System.console().readLine());
        
        //get account creation date
        String createDate = acctCreationDate();
        
        
        //create account object        
        //if account type is "Child" create child account
        
        if (temp_AcctType.equals("Child")) {            
        
            System.out.print("Guardian's Name: ");
            String guardName = System.console().readLine();
            System.out.print("Guardian's NRIC: ");
            String guardNRIC = System.console().readLine();
            System.out.print("Enter Maximum Withdrawal Amount (S$): ");
            double maxWithdraw = Double.parseDouble(System.console().readLine());
            
            accountObj = new ChildAccount(guardName, guardNRIC, maxWithdraw, temp_AcctID, temp_AcctType, custObj, createDate, balance);
            //set minimum account balance
            accountObj.acctMinBal = MinVal.CHILD.getMinSum();
            
        } else if (temp_AcctType.equals("FD")) {
            
            LocalDate fdRenewalDate = LocalDate.now();
            
            System.out.print("Enter Fixed Deposit Period (in Years): ");
            long fdPeriod = Long.parseLong(System.console().readLine());
            
            fdRenewalDate = fdRenewalDate.plusYears(fdPeriod);
            String fdRenewalDateString = FORMAT_DATE.format(fdRenewalDate);
            
            accountObj = new FixedDeposit(fdPeriod, fdRenewalDateString, temp_AcctID, temp_AcctType, custObj, createDate, balance);
            //set minimum account balance
            accountObj.acctMinBal = MinVal.FD.getMinSum();
        }
        
        else {
        
            accountObj = new CoreBanking(temp_AcctID, temp_AcctType, custObj, createDate, balance);
            //set minimum account balance
            accountObj.acctMinBal = MinVal.SAVING.getMinSum();
        }
        
         //print account details
        System.out.println(accountObj);
        
        return accountObj;
    }
    
    public static String acctCreationDate() {
        
        LocalDate creationDate = LocalDate.now();
        
        String acctCreationDateString = FORMAT_DATE.format(creationDate);
        
        return acctCreationDateString;
    }
    
    public void depositFund() {
        
        System.out.print("Enter Deposit Amount (S$): ");
        double deposit = Double.parseDouble(System.console().readLine());
        
        double bal = this.getAcctBalance() + deposit;
        
        this.setAcctBalance(bal);
    }
    
    public void withdrawFund(double withdraw) {
        
        double bal = this.getAcctBalance();
        
        if (withdraw > bal) {
            System.out.println("Withdrawal Failed! Withdrawal amount of S$" + withdraw + " is greater than Account Balance S$" + bal);
        }
        else if ((bal - withdraw) < this.acctMinBal) {
            System.out.println("Withdrawal Failed! Withdrawal amount of S$" + withdraw 
                    + " will cause your account balance to fall below the account minimum balance of S$" + this.acctMinBal);
        }
        else {
            bal = bal - withdraw;
            this.setAcctBalance(bal);
            System.out.println("Withdrawal of S$" + withdraw +" Successful! New Account Balance is S$" + bal);
            
        }       
       
    }
    
    public CoreBanking closeAccount() {
        //Close Account
        Scanner sc = new Scanner(System.in);
        System.out.print("Confirm closure of account (Y/N)? : ");
        char userInput = Character.toUpperCase(sc.next().charAt(0)); //read a character input from the keyboard and convert to Uppercase

        if (userInput == 'Y') {
            System.out.println("Customer account closed.");
            return null;   
        }
        else
            System.out.println("Request Cancelled.");
        return this;
    }    
}


