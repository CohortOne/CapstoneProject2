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
public class DeluxeSavingAccount extends SavingAccount{
    public DeluxeSavingAccount(int accountNo,String ownerName, String accountType, double balance) throws MinBalException{
        super(accountNo, ownerName, accountType, balance);
    }
    
}
