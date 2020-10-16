/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rj;

/**
 *
 * @author wakar
 */
public class SavingAccount extends BankAccount {

    protected int noOfInterestTiersAchieved;

    public SavingAccount(int accountNo, String ownerName, String accountType, double balance) throws MinBalException {
        super(accountNo, ownerName, accountType, balance);
//        super.bankCode = "12444"; // cannot change final variables
    }

    public SavingAccount(int noOfInterestTiersAchieved, int accountNo, String ownerName, String accountType, double balance) throws MinBalException {
        this(accountNo, ownerName, accountType, balance);
        this.noOfInterestTiersAchieved = noOfInterestTiersAchieved;
    }

    public int getNoOfInterestTiersAchieved() {
        return noOfInterestTiersAchieved;
    }

    public void setNoOfInterestTiersAchieved(int noOfInterestTiersAchieved) {
        this.noOfInterestTiersAchieved = noOfInterestTiersAchieved;
    }

    @Override
    public void minusBalance(double deposit) {
        if (this.balance - deposit >= this.minBalance )
            super.minusBalance(deposit); //To change body of generated methods, choose Tools | Templates.
        else {
            System.out.println("Not enough to withdraw , top up balance first.");
        }
    }

   
    
     
}

