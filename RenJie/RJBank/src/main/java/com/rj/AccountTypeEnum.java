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
public enum AccountTypeEnum {
    CURRENT(100, "Current"),
    SAVING(1000, "Saving"),
    FAMILY(500, "Family" );

    private int minBal;
    private String alias;
    
    private AccountTypeEnum(int minBal, String alias) {
        this.minBal = minBal;
        this.alias = alias;
    }
    
    int shortCodeMinBal(){
        return minBal;
    }
    
    String shortCodeAlias(){
        return alias;
    }
    
    
    
    
    
}
