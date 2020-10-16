/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.banking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.notExists;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jt
 */
public class ABankAcct extends ABankCustomer {
    String ABankAcctType;
    String ABankAcctNum;
    Double ABankAcctBalance;
    
    public ABankAcct(String uiN, String lName, String gName, String abAT, String abAN, Double abAB) {
        super(uiN, lName, gName);
        this.ABankAcctType = abAT;
        this.ABankAcctNum = abAN;
        this.ABankAcctBalance = abAB;
    }

    public String getABankAcctType() {
        return ABankAcctType;
    }

    public void setABankAcctType(String ABankAcctType) {
        this.ABankAcctType = ABankAcctType;
    }

    public String getABankAcctNum() {
        return ABankAcctNum;
    }

    public void setABankAcctNum(String ABankAcctNum) {
        this.ABankAcctNum = ABankAcctNum;
    }

    public Double getABankAcctBalance() {
        return ABankAcctBalance;
    }

    public void setABankAcctBalance(Double ABankAcctBalance) {
        this.ABankAcctBalance = ABankAcctBalance;
    }

    public static boolean vetDigitsInStr(String s) {   
        if (s.length() > 1) {
            s = s.toLowerCase();
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (!(ch >= '0' && ch <= '9')) {
                    System.out.println("This does not looked like an acceptable initial deposit amount.");
                    return false;
                }
            }
            if(Integer.parseInt(s) > 9) { 
                return true;
            }
        } 
        System.out.println("This does not looked like an acceptable initial deposit amount.");
        return false;       
        /*
        if (Pattern.matches("[0-9]",iDeposit) && Integer.parseInt(iDeposit) > 9) {
            return true;
        } else {
            System.out.println("This does not looked like an acceptable initial deposit amount.");
            return false;
        }       
        */
    }
       
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public static boolean vetLettersInStr(String s) { 
        if (s.length() > 1) {
            s = s.toLowerCase();
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (!(ch >= 'a' && ch <= 'z')) {
                    System.out.println("This does not looked like a good Last/Given Name.");
                    return false;
                }
            }
            return true;
        } 
        System.out.println("This does not looked like a good Last/Given Name.");
        return false;
        /*
        if (lName.length() > 1 && Pattern.matches("[a-zA-Z]",lName)) {
            //this.lastName = lName;
            return true;
            //throw new IllegalArgumentException();
        } else {
            System.out.println("This does not looked like a good Last Name.");
            return false;
        }       
        */
    }

    public String getGivenName() {
        return givenName;
    }
  
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFullName() {
        return fullName;
    }

    //public void setFullName(String fullName) {
    //    this.fullName = fullName;
    //}

    public String getUiNum() {
        return uiNum;
    }

    public void setUiNum(String uiNum) {
        this.uiNum = uiNum;
    }
    
    //main starts
    public static Scanner readInput = new Scanner(System.in); //setup for console inputs
    static String fileName = "D:\\LHub\\_ntucLHub\\P51\\BankingApp\\ABankFile.txt"; //assign the name of the text file for IO.    
    public static void main(String [] args) {
        try {
            createFile(fileName);
        } catch (IOException ex) {
            Logger.getLogger(ABankAcct.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringBuilder strBldr = new StringBuilder("");
        String inputString;
        boolean xTerminate = false;        
        while (!xTerminate) {            
            if (strBldr.length() > 0) {
                strBldr.delete(0, strBldr.length());
            }
            try {
                clearScreen();
            } catch (IOException ex) {
                Logger.getLogger(ABankAcct.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("=====================");
            System.out.println("ABank Add New Account");
            System.out.println("=====================");
            boolean isTrue = false;
            while (!xTerminate && !isTrue) { 
                               
                System.out.print("Enter Family/Last Name:");
                inputString = readInput.nextLine();
                //inputString = System.console().readLine();
                if(!inputString.isEmpty()) {
                    isTrue = vetLettersInStr(inputString.trim());
                    if(isTrue) { 
                        strBldr.append(inputString.trim()); 
                        //strBldr.append(inputString.length());
                        strBldr.append(",");
                    }                
                } else {
                    xTerminate = true;
                    break;
                }                
            } 
                            
            isTrue = false; 
            while (!xTerminate && !isTrue) {
                System.out.print("Enter Given Name:");
                inputString = readInput.nextLine();
                //inputString = System.console().readLine();
                if(!inputString.isEmpty()) {
                    isTrue = vetLettersInStr(inputString.trim());
                    if(isTrue) { 
                        strBldr.append(inputString.trim()); 
                        //strBldr.append(inputString.length());
                        strBldr.append(",");
                    }               
                } else {
                    xTerminate = true;
                    break;
                }
            }
            
            isTrue = false; 
            while (!xTerminate && !isTrue) {
                System.out.print("Enter initial deposit:");
                inputString = readInput.nextLine();
                //inputString = System.console().readLine();
                if(!inputString.isEmpty()) {
                    isTrue = vetDigitsInStr(inputString.trim());
                    if(isTrue) { 
                        strBldr.append(inputString.trim()); 
                        //strBldr.append(inputString.length());
                        strBldr.append(",");
                    }               
                } else {
                    xTerminate = true;
                    break;
                }
            }
            
            if (!xTerminate && isTrue) { 
                //generate uiNum, write record to file 
                inputString = genAcctNum(strBldr.substring(0,1));
                strBldr.append(inputString.trim()); 
                //strBldr.append(inputString.length());
                strBldr.append("\n");
                try {
                    //write a record to a text file.
                    appendToFile(strBldr.toString(), fileName);
                } catch (IOException ex) {
                    Logger.getLogger(ABankAcct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } //-end main
    
    static String genAcctNum(String s) {
        //String s is the 1st char [a-zA-Z] in lastName
        //convert s to its representative ascii value, which is also a positive integer;
        byte[] n = s.getBytes();
        int m = (int) (n[0] - 1) % 10;
        //auto-generate a random number between 0.0 and 1.0
        double r = Math.random();
        //calc an integer using values of n[0] and r above (between 0 and n-1), 
        //add 100 to get 3-digit number
        //then prefix the modulus of 10 on n[0]-1
        int i = (int) (r * n[0]) + 100;
        return (s + String.valueOf(m) + String.valueOf(i)); 
    }
    
    //write to file with java.nio.file.* APIs
    static void appendToFile(String s, String fileName) throws IOException {
        Path p = Paths.get(fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
            bw.write(s);
        }
        /*
        Files.write(
                Paths.get(fileName),
                s.getBytes(),
                StandardOpenOption.APPEND);    
        */
    }
    //create a new text file for IO with java.nio.file.* APIs
    static void createFile(String fileName) throws IOException {
        Path p = Paths.get(fileName);
        if(notExists(p, NOFOLLOW_LINKS)) { 
            Files.createFile(p);
        }
    }
    
    static void clearScreen() throws IOException {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(ABankAcct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
} //-end public class ABankAcct


