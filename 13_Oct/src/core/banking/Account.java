
package core.banking;

import java.util.Objects;

public class Account {

    public Account(String accNo, String accHolder, String balance) {
        this.accNo = accNo;
        this.accHolder = accHolder;
        this.balance = balance;
        
         System.out.println(" 3-Arg Constructor ");
    }

     Account() {  // if you don't specify Public/Private/Protected then you've Package "default" Access Modifier/Specifier 
         System.out.println(" 0-Arg Constructor ");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.accNo);
        hash = 13 * hash + Objects.hashCode(this.accHolder);
        hash = 13 * hash + Objects.hashCode(this.balance);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.accNo, other.accNo)) {
            return false;
        }
        if (!Objects.equals(this.accHolder, other.accHolder)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Account{" + "accNo=" + accNo + ", accHolder=" + accHolder + ", balance=" + balance + '}';
    }
  
    private String accNo;
    private String accHolder;
    private String balance;

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    
}
