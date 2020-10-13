package core.banking;

public class StudentAccount extends Account {

    private float OD;

    public float getOD() {
        return OD;
    }

    public void setOD(float OD) {
        this.OD = OD;
    }

    public float getSpendLimit() {
        return spendLimit;
    }

    public void setSpendLimit(float spendLimit) {
        this.spendLimit = spendLimit;
    }
    private float spendLimit;
    
    public static void main(String [] args){        
       
        
        Account acct = new StudentAccount(1000.0f, 35.0f, "12345", "TA", "450", "47120" ); //how could the compiler allow this?

        StudentAccount stAcc = new StudentAccount(1000.0f, 35.0f, "12345", "TA", "450", "47120" );
    }

    public StudentAccount(float OD, float spendLimit, String accNo, String accHolder, String balance, String pCode) {
        super(accNo, accHolder, balance, pCode);
        this.OD = OD;
        this.spendLimit = spendLimit;
    }

    public StudentAccount(float OD, float spendLimit) {
        this.OD = OD;
        this.spendLimit = spendLimit;
    }
 
}
