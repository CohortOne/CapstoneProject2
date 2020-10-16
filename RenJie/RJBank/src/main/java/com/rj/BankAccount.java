package com.rj;

import file.exp.MyFileBIOS;
import java.util.Objects;

public class BankAccount {
   
    //static variables
    private static int noOfBankAccountsOpened = 0;
    
    //field variables
    protected int accountNo;
    protected String ownerName;
    protected String accountType;
    protected double balance;
    protected boolean isFrozen = false;
    protected int minBalance;
    protected final String bankCode;


    //getters and setters

    public static int getNoOfBankAccountsOpened() {
        return noOfBankAccountsOpened;
    }

    public static void setNoOfBankAccountsOpened(int noOfBankAccountsOpened) {
        BankAccount.noOfBankAccountsOpened = noOfBankAccountsOpened;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        this.minBalance = minBalance;
    }
    

   
   
    //constructors
//   BankAccount(){
//   }
    

    public BankAccount(int accountNo, String ownerName, String accountType, double balance) throws MinBalException {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.accountType = accountType;
        this.bankCode = "123";
        this.minBalance = minBalanceCalculator();
        if (balance >= minBalance){
            this.balance = balance;
        }else{
            throw new MinBalException("The balance is not enough for "+accountType+" account type"
                    + ". It should be at least $" +minBalance+"." );
            
        }
        noOfBankAccountsOpened += 1;
    }
    
   
    //methods
    public void printToFile(){
        MyFileBIOS.m1(this);
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 5 * hash + Objects.hashCode(this.accountNo);
        hash = 5 * hash + Objects.hashCode(this.ownerName);
        hash = 5 * hash + Objects.hashCode(this.accountType);
        hash = 5 * hash + Objects.hashCode(this.balance);
        hash = 5 * hash + Objects.hashCode(this.isFrozen);
        hash = 5 * hash + Objects.hashCode(this.minBalance);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BankAccount other = (BankAccount) obj; //final
        if (!Objects.equals(this.accountNo, other.accountNo)) {
            return false;
        }
        if (!Objects.equals(this.accountType, other.accountType)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.isFrozen, other.isFrozen)) {
            return false;
        }
        if (!Objects.equals(this.minBalance, other.minBalance)) {
            return false;
        }
        if (!Objects.equals(this.ownerName, other.ownerName)) {
            return false;
        }
        
        return true;
    }
    
    private int minBalanceCalculator(){
        int result = 0;
        switch(accountType){
            case "Saving":
                result = AccountTypeEnum.SAVING.shortCodeMinBal();
                break;
            case "Current":
                result =  AccountTypeEnum.CURRENT.shortCodeMinBal();
                break;
            case "Family":
                result = AccountTypeEnum.FAMILY.shortCodeMinBal();
                break;
               
        }
        return result;
        
    }
    
    public void addBalance(double deposit){
        if(this.checkFrozen() == true){
            return;
        }
        this.balance += deposit;
    }
    
    public void minusBalance(double deposit){
        if(this.checkFrozen() == true){
            return;
        }
        this.balance -= deposit;
    }
    
    public void freezeAccount(){
        this.isFrozen = true;
    }
    
    public void unfreezeAccount(){
        this.isFrozen = false;
    }
    
    public boolean checkFrozen(){
        if(this.isFrozen == true){
            System.out.println("The account is frozen, please find an administrator");
            return true;
        }
        else 
            return false;
    }
    
    public void transferBalance(BankAccount x, double amount){
        if(this.checkFrozen() == true){
            return;
        }
        x.addBalance(amount);
        this.minusBalance(amount);
        System.out.println("Transaction Successful, " + amount + " deducted from " + this.ownerName +" and given to "
                + x.getOwnerName());
    }
    
    @Override
    public String toString(){
        return "Account owned by " + this.ownerName + ". Account No. is: " + this.accountNo + ". Account type is: " + accountType + ". Min bal is "+ minBalance + ".";
    }
    
    public final void displayBankCode(){
        System.out.println("BankCode is: " + this.bankCode);
    }
    
    
    
}
