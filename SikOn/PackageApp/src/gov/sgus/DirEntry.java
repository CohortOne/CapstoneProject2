/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.sgus;

/**
 *
 * @author deng
 */
public class DirEntry {
    
    private String dirName;
    private String dirTel;
    private String dirArea;

    public String getDirName() {
        return dirName;
    }

    public String setDirName(String dirName) {
        if ((dirName.length() == 0) || (dirName.isBlank())) {
            return "^".repeat(25) + " name must not be blank.";
        }
        
        if (dirName.substring(0,1).equals(" ")) {
            return "^" + " ".repeat(24) + " name must not begin with a blank.";
        }
        
        this.dirName = dirName.trim();
        return "";  // return an empty string means OK
    }

    public String getDirTel() {
        return dirTel;
    }

    public String setDirTel(String dirTel) {
        
        if (dirTel.isBlank()) {
            return "^".repeat(12) + " telephone number must not be blank.";
        }
        if (!dirTel.substring(0,3).equals("+60")) {
            return "^^^" + " ".repeat(9) + " telephone number must begin with +60.";
        }
        
        String strTelAreaCode = findAreaCode(dirTel);
        if (strTelAreaCode == null) {
            return  "   ^^        area code in telephone number invalid.";
        }
        
        this.dirTel = dirTel.trim();
        return "";
    }

    
    
    
    
    
    
    
    
    
    public static String findAreaCode(String str) {  // given an Area or phone number, get the Area Code
        Areas myArea;
        if (str.length() >= 5) {
            if (str.substring(0,3).equals("+60")) {
                myArea = Areas.findArea(str);
                if (myArea == null) {
                    return null;
                }
                return myArea.getAreaCode();
            }
        }
        try {myArea  = Areas.valueOf(str);}
        catch (Exception e) {
                return null;
        }
        return myArea.getAreaCode();
    }

    
    
    

    public static int findCallRate(String strTel) {  // given a phoe number, get call rate
        Areas myArea = Areas.findArea(strTel);
        if (myArea == null) {
            return 0;
        }

        return myArea.getCallRate();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    public String getDirArea() {
        return dirArea;
    }
    
    
    
    public String setDirArea(String dirArea) {
        String strTelAreaCode = findAreaCode(this.dirTel);
        if (strTelAreaCode == null) {
            return "area code in telephone number invalid.";
        }
        String strAreaCode = findAreaCode(dirArea);
        if (strAreaCode == null) {
            return "^".repeat(dirArea.length()) + " area not valid.";
        }
        if (!strTelAreaCode.equals(strAreaCode)) {
            return "^".repeat(dirArea.length()) + " translates into area code (" + strAreaCode + ") does not match (" + strTelAreaCode + ") from telephone number.";
        }
        this.dirArea = dirArea.trim();
        return "";
    }
    
    
    
    public DirEntry() {
        this.dirName = "Name";
        this.dirTel = "+60";
        this.dirArea = "";
    }

    public DirEntry(String dirName, String dirTel, String dirArea) {
        this.dirName = dirName.trim();
        this.dirTel = dirTel.trim();
        this.dirArea = dirArea.trim();
    }

    @Override
    public String toString() {
        return "DirEntry{" + "dirName=" + dirName + ", dirTel=" + dirTel + ", dirArea=" + dirArea + '}';
    }

        
}
