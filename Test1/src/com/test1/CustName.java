package com.test1;
import java.util.Scanner; 
/**
 *
 * @author Wing
 */
public class CustName{
    public String accId;
    public String accHName;
    public String accAddr;
    public String accCont;
    public String resStatus;
    public String email;
    public String dob;
    
    //public CustName(String accId, String accHName, String accAddr, String accCont, String resStatus, String email, String dob) {
    //    this.accId = "101-202-00000";
    //    this.accHName = "Zee Zorro";
    //    this.accAddr = "100 Nought Dr";
    //    this.accCont = "9000-2000";
    //    this.resStatus = "AL";
    //    this.email = "zz@mymail.com";
    //    this.dob = "01-01-1911";
    //}
     
    public CustName(String accId, String accHName, String accAddr, String accCont, String resStatus, String email, String dob) {
        this.accId = accId;
        this.accHName = accHName;
        this.accAddr = accAddr;
        this.accCont = accCont;
        this.resStatus = resStatus;
        this.email = email;
        this.dob = dob;
    }
   
    public String toString() {
        return "Account{" + "ID= " + accId + ", Name= " + accHName + ", Address" + accAddr + '}'  ;
    }
//
//
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Account 0  :: ");
        CustName an1 = new CustName("101-202-99999", "George Yeo","88 Bras Basah Rd","9918-2818", "CZ","mj@mymail.com","08-08-1988"); // not a good practice !!!!!!
        CustName an2 = new CustName("101-202-88888", "Lionel Lim","22 Keong Saik Rd","8819-2919", "PR","ll@mymail.com","09-09-1999"); 
        System.out.println("Account 1  :: " + an1);
        System.out.println("Account 2  :: " + an2);
      
        
    }
    
}
