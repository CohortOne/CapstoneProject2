package com;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Entry {
     public static String entryName = "";
    public static File entry;
    public static Scanner myObj = new Scanner(System.in);
    

 public static void main(String[] args) throws FileNotFoundException, IOException {

    File nEntry = new File("C:\\temp\\TestFolder");
if (nEntry.exists()) {
                System.out.print(" Enter the account file name with format: ");
                entryName = myObj.nextLine();
                System.out.println(" Account Name Entered is : " + entryName);
                entry = new File(nEntry.getAbsolutePath() + "\\" + entryName);
                if (entry.exists()) {
                    System.out.println(" Name already exists");
                    System.exit(0);
                }
                if (entry.createNewFile()) {

                    try (FileOutputStream eos = new FileOutputStream(entry)) {
                        System.out.println(" Enter Account holder Name: ");
                        String accountname = myObj.nextLine();
                        System.out.println(" Enter Name of Account: ");
                        String nameOfAccount = myObj.nextLine();
                        System.out.println(" Enter the assigned interest rate: ");
                        String interestrate = myObj.nextLine();
                        System.out.println(" Add Noes Enter File Content [quit] to stop");
                        String newLine = " AccountName is " + accountname + ". Acc holder Name is " + nameOfAccount + " & interest rate is " + interestrate + "%";
                        do {
                        eos.write((newLine + "\n").getBytes());
                        newLine = (myObj.nextLine());
                    } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                    eos.flush();
                        eos.close();
                    
                
                    }
                    }
                }
}
 }



 


                    
                    
                           









   