/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaira428;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Wong Keng
 */
public class FixedDeposit extends CoreBanking {
    
    long fdDuration;
    String fdRenewalDate;

    public FixedDeposit(long fdDuration, String fdRenewalDate, String acctID, String acctType, BankCustomer bankCust, String acctCreationDateString, double acctBalance) {
        super(acctID, acctType, bankCust, acctCreationDateString, acctBalance);
        this.fdDuration = fdDuration;
        this.fdRenewalDate = fdRenewalDate;
    }   

    @Override
    public String toString() {
        return "\n++++++++\nFixed Deposit{" + "\nAccount ID=" + acctID + "\nAccount Type=" + acctType + "\n-----\nCustomer Details:" + bankCust + "\nAccount Creation Date=" + acctCreationDateString 
                + "\nAccount Balance (S$)=" + acctBalance + "\nMinimum Balance (S$)=" + acctMinBal + "\nDeposit Duration (Years)=" + fdDuration + "\nRenewal Date=" + fdRenewalDate;
    }

    @Override
    public void withdrawFund(double withdraw) {
        
        LocalDate lRenewDate = LocalDate.parse(this.fdRenewalDate, FORMAT_DATE);
        LocalDate todayDate = LocalDate.now();
        
//        System.out.println("Here in FD Withdraw" + todayDate.compareTo(lRenewDate));
        
        if (todayDate.compareTo(lRenewDate) != 0) {
            System.out.println("Your Time Deposit is not matured yet. No interest will be paid if you withdraw now.");
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Confirm pre-matured withdrawal? (Y/N)");
            char userInput = Character.toUpperCase(sc.next().charAt(0)); //read a character input from the keyboard and convert to Uppercase
            
            if (userInput == 'Y') {
                super.withdrawFund(withdraw);
            }
            else
                System.out.println("Withdrawal request cancelled.");
        }
         
    }
        
}
