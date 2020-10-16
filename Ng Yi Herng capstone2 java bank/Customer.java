/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.banking;

/**
 *
 * @author jt
 */
public class ABankCustomer extends java.lang.Object {
    String lastName;
    String givenName;
    String fullName = givenName + lastName;
    String uiNum;
    
    public ABankCustomer (String uiN, String lName, String gName) {
        this.uiNum = uiN;
        this.lastName = lName;
        this.givenName = gName;
        //this.fullName = fName;
        System.out.println(" 3-Arg Constructor BankCustomer ");
    }

    public Boolean createABankCust (String uiN, String lName, String gName) {
        //create a new Customer record
        //if successful, return true else return false
        return false;
    }
    /*
    public Boolean createABankAcct (String acctType) {
        //pre-requisite -- createCust must be successful
        //create a new bank account record for the named Customer
        //generate an bankAcctNum like 1stCharofLastName+2ndCharOfGivenName + 4-digitRandomNum(seed start,end)
        //if successful, return true else return false
        return false;
    }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("from package core.banking, class ABankCustomer, main...");
        
    }
    
}
