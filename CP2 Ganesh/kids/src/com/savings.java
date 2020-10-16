/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Objects;

public class savings {

   public int interest;
   public String accname;
   public String accholder;
   
   
    public savings(int interest, String name, String accname){
        interest = 3;
        accname = name;
        accholder = accname;
        
       // System.out.println(" 3-Arg Constructor ");
    }
       // savings(){
        //System.out.println( "0-Arg Constructor ");
  //  }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.interest;
        hash = 79 * hash + Objects.hashCode(this.accname);
        hash = 79 * hash + Objects.hashCode(this.accholder);
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
        final savings other = (savings) obj;
        if (this.interest != other.interest) {
            return false;
        }
        if (!Objects.equals(this.accname, other.accname)) {
            return false;
        }
        if (!Objects.equals(this.accholder, other.accholder)) {
            return false;
        } else {
        }
        return true;
    }

    @Override
    public String toString() {
        return "savings{" + "interest=" + interest + ", accname=" + accname + ", accholder=" + accholder + '}';
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getAccholder() {
        return accholder;
    }

    public void setAccholder(String accholder) {
        this.accholder = accholder;
    }
    
    }

    

