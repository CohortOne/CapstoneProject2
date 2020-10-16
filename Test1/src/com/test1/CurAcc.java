package com.test1;

import java.util.Scanner;



public class CurAcc extends CustName  {
    String accType;
    static float balance, amt;

    public CurAcc(String accType, float balance, String accId, String accHName, String accAddr, String accCont, String resStatus, String email, String dob) {
        super(accId, accHName, accAddr, accCont, resStatus, email, dob);
        this.accType = accType;
        this.balance=balance;
      }
 //
 // Add 2 parm constructordep
 //
     //public CurAcc(String accType, String balance) {      
     //   this.accType = "SA" //accType;
     //   this.balance = "1010" //balance;
    // }
 //

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "{" + "ID= " + accId + ", Name= " + accHName +  ", with Balance $" + balance + '}' ;
    }
   
//Use a Constructor to Init
    //public CurAcc(String accID, String accType, String balance) {
    //    this.accType=accType;
    //    this.balance=balance;
    //}
    public float getBalance() { //(String branch) {
        return balance;
    }
        //
    public void setBalance(String branch) {
        this.balance = balance;
    }
    //
     
    public static void main(String[] args) {
        // Create new Obj with Values
        //
        CurAcc an3 = new CurAcc("CA", 8888.0f,"101-202-77777", "Joshua Jong","77 Bt Timah Rd","9777-9797", "CZ","jj@mymail.com","07-07-1977"); // not a good practice !!!!!!
        System.out.println(" Current Account : " + an3);
        //CustName an4 = new CustName("101-202-66666", "Henry Han","66 Bt Timah Rd","9666-9797", "PR","hh@mymail.com","06-06-1966");
        //
        // BELOW:  Try out an interactive dialog with customer on activities he/she want to do
        //Not Console - Cannot use this ===> String act = System.console().readLine();
        int xact = 1;
        while (xact == 1) {
            System.out.print("Please enter the transaction you like to do? " + "\n");
            System.out.println("dep : Deposit into your account");
            System.out.println("wdr : Withdrawal from your account");
            System.out.println("chk : Check Balance on your account");
            //System.out.println("drf: Buy a Bank Draft) using your account balance");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object 
            //Read the User activity delection
            String act = myObj.nextLine(); // Read User input
            System.out.println("Activity Requested is :  " + act + "\n");
            //String act = "dep";
            switch (act) {

                case "dep":
                    System.out.println("Please enter Deposit Amount ");
                    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
                    amt = Float.parseFloat(myObj2.nextLine());
                    //
                    balance = balance + amt;
                    System.out.println("$" + amt + " has been deposited into your account");
                    System.out.println("Your New Balance is $: " + balance);
                    break;
                    
                     case "wdr":
                    System.out.println("Please enter Amount to Withdraw ");
                    Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
                    amt = Float.parseFloat(myObj3.nextLine());
                    //
                    balance = balance - amt;
                    System.out.println("$" + amt + " has been withdrawn from your account");
                    System.out.println("Your New Balance is: $" + balance);
                    break;
                    
                     case "chk":
                    System.out.println("Your Account Balance is :$ " + balance);
                    break;
            }
            System.out.println("Please enter 1 if you wish to continue with other transaction 0 to exit");
            xact = myObj.nextInt(); // Read User input
            //xact = Integer.parseInt(System.console().readLine()); 
        }  
        
  
    }  
    
}
