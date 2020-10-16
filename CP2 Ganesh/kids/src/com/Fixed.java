
package com;


public class Fixed extends savings {
    
   int maturityInt;
   protected int maturityPeriod;

    public Fixed(int maturityInt, int maturityPeriod, int interest, String name, String accname) {
        super(interest, name, accname);
        this.maturityInt = maturityInt;
        this.maturityPeriod = maturityPeriod;
    }
   
   


    public int getMaturityInt() {
        return maturityInt;
    }

    public void setMaturityInt(int maturityInt) {
        this.maturityInt = maturityInt;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
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

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
 public static void main(String[] args) {





}

    
}


