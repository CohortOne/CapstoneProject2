/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test2;

import com.test1.CustName;
import java.util.Scanner;

public class FixAcc extends CustName{
    String accType;
    String strtDate;
    String numYr;
    String intRate;
    static float balance, depAmt;

    //Use a Constructor to Init
    //public FixAcc(String accID, String accType, String balance) {
    //    this.accType=accType;
    //    this.balance=balance;
    //}
    public FixAcc(String accType, String strtDate, String numYr, float depAmt, String intRate, String accId, String accHName, String accAddr, String accCont, String resStatus, String email, String dob) {
        super(accId, accHName, accAddr, accCont, resStatus, email, dob);
        this.accType = accType;
        this.strtDate = strtDate;
        this.numYr = numYr;
        this.depAmt = depAmt;
        this.intRate = intRate;
    }

       
    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "ID= " + accId + ", Name= " + accHName +  ", with Deposit $" + depAmt + " for " + numYr + " Year Term" + '}' ;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //CustName an3= new FixAcc("SA", "8888","101-202-77777", "Joshua Jong","77 Bt Timah Rd","9777-9797", "CZ","jj@mymail.com","07-07-1977"); 
        FixAcc fa1 = new FixAcc("FD","01-10-2020","3",10000.0f,"5","101-202-77777", "Joshua Jong","77 Bt Timah Rd","9777-9797", "CZ","jj@mymail.com","07-07-1977"); // not a good practice !!!!!!
        System.out.println(" FD Account : " + fa1);

        int xact = 1;
        while (xact == 1) {
            System.out.print("Please enter the transaction you like to do? " + "\n");
            System.out.println("opn : Open New Fixed Deposit account");
            System.out.println("cls : Close your Fixed Deposit account");
            System.out.println("chk : Check Balance on your account");
            //System.out.println("drf: Buy a Bank Draft) using your account balance");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object 
            //Read the User activity delection
            String act = myObj.nextLine(); // Read User input
            System.out.println("Activity Requested is :  " + act + "\n");
            //String act = "dep";
            switch (act) {

                case "opn":
                    System.out.println("Open New FD account ; Please enter amount ");
                    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
                    depAmt = Float.parseFloat(myObj2.nextLine());
                    //
                    //
                    FixAcc fa2 = new FixAcc("FD","02-10-2020","5",depAmt,"6","101-202-77777", "Cont Counter","747 Newton Rd","9222-2929", "CZ","cc@mymail.com","07-07-1977");
                    System.out.println("$" + depAmt + " new FD account has been Opened for you");
                    //System.out.println(" FD Account : " + fa2);
                    //System.out.println("Your New Balance is: " + balance);
                    break;
                    
                     case "cls":
                    System.out.println("$" + depAmt + " FD account has been Closed");//System.out.println("Please enter Amount to Withdraw ");
                    //
                    break;
                    
                     case "chk":
                    //System.out.println("Your Account Balance is :$ " + balance);
                    break;
            }
            System.out.println("Please enter 1 if you wish to continue with other transaction 0 to exit");
            xact = myObj.nextInt(); // Read User input
            //xact = Integer.parseInt(System.console().readLine()); 
        } 
        
    }
    
    
    
}
