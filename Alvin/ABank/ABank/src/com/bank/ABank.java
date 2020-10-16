
package com.bank;

//public class ABank extends java.lang.Object { // copyrighted 
public class ABank {

    public static void main(String[] args) {
        BankAcc bac1 = new BankAcc(0, 0, 0, 1000);
        pr("bac1/" + bac1 + "\n");

        float depositAmont = 200;
        bac1.setBankDep(200);
        pr("Deposit : " + bac1.getBankDep());
        pr("bac1/" + bac1 + "\n");

        /* Demonstrate the Business logic for withdrawal limit, 
           from another file, BankAcc.java */
        float withdrawAmont = 300;
        bac1.withDrawing(bac1, withdrawAmont); // BankAcc Business Logic
        pr("bac1/" + bac1 + "\n");

        withdrawAmont = 1300;
        bac1.withDrawing(bac1, withdrawAmont); // BankAcc Business Logic
        pr("bac1/" + bac1 + "\n");
    }

    /* demonstrate private static variable on the main*/
    private static void pr(String sentences) {
        System.out.println(sentences);
    }
}

