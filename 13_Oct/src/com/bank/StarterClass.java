package com.bank;

import core.banking.Account;

public class StarterClass {

    public static void main(String[] args) {
        
        Account acc1 = new Account("1234","Apple","120"); // not a good practice !!!!!!
        Account acc2 = new Account("1234","Apple","120"); // not a good practice !!!!!!

        // acc1 & acc2 are Reference variables 
        if(acc1.equals(acc2)){
            System.out.println(" Same Accounts " + acc1 + " \n " + acc1.hashCode());
            
        }else {
            System.out.println(" Different Accounts ");
        
        }
    }
}