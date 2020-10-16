/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaira428;

/**
 *
 * @author Wong Keng
 */
public class ChildAccount extends CoreBanking {
    
    String guardName;
    String guardNRIC;
    double maxWithdrawalLimit;

    public ChildAccount(String guardName, String guardNRIC, double maxWithdraw, String acctID, String acctType, BankCustomer bankCust, String acctCreationDateString, double acctBalance) {
        super(acctID, acctType, bankCust, acctCreationDateString, acctBalance);
        
        this.guardName = guardName;
        this.guardNRIC = guardNRIC;
        this.maxWithdrawalLimit = maxWithdraw;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    @Override
    public String toString() {
        return "\n++++++++\nChild Account{\nAccount ID=" + acctID + "\nAccount Type=" + acctType + "\n-----\nCustomer Details:" + bankCust + "\nAccount Creation Date=" + acctCreationDateString + "\nAccount Balance (S$)=" + acctBalance + "\nguardName=" + guardName + "\nguardNRIC=" 
                + guardNRIC + "\nMax Withdrawal Limit (S$) " + maxWithdrawalLimit + "\nMinimum Balance (S$)=" + acctMinBal;
    }
    
    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public String getGuardNRIC() {
        return guardNRIC;
    }

    public void setGuardNRIC(String guardNRIC) {
        this.guardNRIC = guardNRIC;
    }

    @Override
    public void withdrawFund(double withdraw) {
        
        if (this.getMaxWithdrawalLimit() > withdraw)
            super.withdrawFund(withdraw);
        else
            System.out.println("Withdrawal Failed! Withdrawal amount of S$" + withdraw + " is greater than Account Maximum Limit of S$" + this.getMaxWithdrawalLimit());
    }
    
    
}
