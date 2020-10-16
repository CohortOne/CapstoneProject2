package com.rj;


public class MainProgram {
    public static void main(String[] args){
        
        try {
            BankAccount rjBankAccount = new BankAccount(1, "RenJie", AccountTypeEnum.SAVING.shortCodeAlias(), 1000.0);
//            SavingAccount rjBankAccount = new SavingAccount(1,1, "RenJie", AccountTypeEnum.SAVING.shortCodeAlias(), 999.0);
            System.out.println(rjBankAccount);
            System.out.println("Attempting to print...");
            rjBankAccount.printToFile();
        } catch (MinBalException e) {
            System.out.println(" Exception Caught :::" + e.getMessage());
        } finally {
            System.out.println("The cleanup code section");
            System.out.println("amount of banks opened: " + BankAccount.getNoOfBankAccountsOpened());
        }
        
        
        
        
//        BankAccount acc1 = new BankAccount(2, "asd", AccountTypeEnum.SAVING.shortCodeAlias(), 2000.0); 
//        BankAccount acc2 = new BankAccount(2, "asd", AccountTypeEnum.SAVING.shortCodeAlias(), 2000.0); 
//
//        // acc1 & acc2 are Reference variables 
//        if(acc1.equals(acc2)){
//            System.out.println(" Same Accounts " );
//        }else {
//            System.out.println(" Different Accounts ");
        
        }
//        BankAccount urBankAccount = new BankAccount(2, "Other", "Savings", 1000.0);
//        System.out.println(rjBankAccount);
//        System.out.println(urBankAccount);
//        System.out.println("No. of banks opened is: " + BankAccount.getNoOfBankAccountsOpened());
//        System.out.println("rj has balance: " + rjBankAccount.getBalance());
//        System.out.println("Topping up rjBankAccount...");
//        rjBankAccount.addBalance(2000.0);
//        System.out.println("rj has balance: " + rjBankAccount.getBalance());
//        System.out.println("Freezing rj account...");
//        rjBankAccount.freezeAccount();
//        System.out.println("Attempt to top up rjBankAccount...");
//        rjBankAccount.addBalance(2000.0);
//        System.out.println("rj has balance: " + rjBankAccount.getBalance());
//        System.out.println("unfreezing rj account...");
//        rjBankAccount.unfreezeAccount();
//        System.out.println("Attempting to transfer monies from rj to other..");
//        rjBankAccount.transferBalance(urBankAccount, 500);
//        System.out.println("rj has balance: "  + rjBankAccount.getBalance());
//        System.out.println("other has balance: " + urBankAccount.getBalance());
        
        
    
}
