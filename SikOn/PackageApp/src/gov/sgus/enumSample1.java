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
public class enumSample1 {

        
    public enum CountryNames {
      //.......... This is the value for the enum CountryNames.
	  //           .           . values in brackets are optional, but when present, matches additional attributes to the enum values.
	  //             ..    ...   here two additional attributes are defined, and they are named below as ccISO and ccIDD.
	  //                         other data types are allowed.
        Singapore  ("SG", "+65"), 
        Malaysia   ("MY", "+60"),
        Indonesia  ("ID", "+62"),
        Thailand   ("TH", "+66"),
        Philippines("PH", "+63"),
        Hongkong   ("HK", "+852"),
        Vietnam    ("VN", "+84"),
        Brunei     ("BN", "+673"),
        Cambodia   ("KH", "+855"),
        Myanmar    ("MM", "+95"),
        Laos       ("LA", "+856");
        
        String ccISO;
        String ccIDD;
        
        CountryNames(String const1, String const2) {  // this line corresponds to the structure of each enam value defined above.
            ccISO = const1;                           // and names (ccISO and ccIDD) are assigned to the additional attributes.
            ccIDD = const2;
        }
        
        public String getccISO() {  // the following two functions return the additional attributes for each CountryNames.
            return this.ccISO;      // to use it, you must first get hold of a valid value of a CountryNames.
        }

        public String getccIDD() {
            return this.ccIDD;
        }
    }

    public static void main(String[] args) {
        String inputCountry = "Hongkong";
        System.out.println("Enum demonstrations:");

        System.out.println("\nEnum demo 1: walk thru all values in the enum:");
		System.out.println("for (CountryNames myVal : CountryNames.values())");
		System.out.println("{System.out.print(\"Scaning enum: \" + myVal + \" \" + myVal.getccISO() + \" \" + myVal.getccIDD() + \" \");}");

		
        for (CountryNames myVal : CountryNames.values()) {
            System.out.println("Scaning enum: " + myVal + " " + myVal.getccISO() + " " + myVal.getccIDD() + " ");
            }
        System.out.println("This shows that the entire enaum can be printed out.");


        System.out.println("\nEnum demo 2: with a String in hand, scan the enum for it\'s occurrence:");
        System.out.println("I have this String named inputCountry containing '" + inputCountry + "', scan the enum for it\'s occurrence:");
		System.out.println("for (CountryNames myVal : CountryNames.values())");
		System.out.println("...  if (myVal.toString().equals(inputCountry)) ...");
        String outputCountry;
        for (CountryNames myVal : CountryNames.values()) {
            System.out.print("Scaning enum and found this item: " + myVal + ", .toString it into '" +  myVal.toString() + "' and compare against inputCountry...");
            if (myVal.toString().equals(inputCountry)) {
                System.out.println(inputCountry + " and it\'s a match.");
                break;
            }
            else {
                System.out.println(myVal.toString() + " is not a match.");
            }
        }

        System.out.println("\nEnum demo 3: similar to demo 2 which compares the values as String, demo 3 compares as CountryNames:");
        System.out.println("I have this String named inputCountry containing '" + inputCountry + "', scan the enum for it\'s occurrence:");
        System.out.println("for (CountryNames myVal : CountryNames.values())");
	System.out.println("... if (myVal == CountryNames.valueOf(inputCountry)) ...");

        for (CountryNames myVal : CountryNames.values()) {
            System.out.print("Scaning enum and found this item: " + myVal + ", and compare against CountryNames.valueOf(inputCountry) which is " + CountryNames.valueOf(inputCountry));
            if (myVal == CountryNames.valueOf(inputCountry)) {
                System.out.println(" and it\'s a match.");
                break;
            }
            else {
                System.out.println(", not a match.");
            }
        }
        System.out.println("Note that CountryNames.valueOf(inputCountry)) worked because value of Sting indeed exists in the enum.");


        System.out.println("\nEnum demon 4: with value of CountryNames (not as a string, but a hardcoded name), go straight for it\'s occurrence:");
        System.out.println("Taking out Hongkong hardcoded: " 
                + "CountryNames.Hongkong is " + CountryNames.Hongkong + ", " 
                + "CountryNames.Hongkong.getccISO() is "+ CountryNames.Hongkong.getccISO() + ", " 
                + "CountryNames.Hongkong.getccIDD()) is " + CountryNames.Hongkong.getccIDD());
        System.out.println("Note that in this demo, since the name Hongkong is hardcoded, it cannot be a not-found value, or otherwise the compiler would have caught it.");


        System.out.println("\nEnum demon 5: with value of CountryNames as a String go straight for it\'s occurrence:");
        System.out.println("I have this String named inputCountry with value '" + inputCountry + "' and can be used to retrieve all its associiated attributes in the enum directly:");
	System.out.println("Item retrived directly from enum:");
        System.out.println("   CountryNames.valueOf(inputCountry) is " + CountryNames.valueOf(inputCountry));
        System.out.println("   CountryNames.valueOf(inputCountry).getccISO() is " + CountryNames.valueOf(inputCountry).getccISO());
        System.out.println("   CountryNames.valueOf(inputCountry).getccIDD() is " + CountryNames.valueOf(inputCountry).getccIDD() + ".");

        
        System.out.println("\nEnum demon 6: refer to demo 5, it is possible that a country name in String does not exist in enum, so a try-catch construct is necessary:");
	inputCountry = "Japan";
        System.out.println("Below, String named inputCountry is assigned value of '" + inputCountry + "' and is used to look up the enum directly:");
	CountryNames inputBridge;
	System.out.println("CountryNames inputBridge;");
	System.out.println("try {inputBridge = CountryNames.valueOf(inputCountry);}");

	inputBridge = null;
        try {inputBridge = CountryNames.valueOf(inputCountry);}
            catch (Exception e) {
            }
	    if (inputBridge == null) {
		System.out.println("Not-found exception is caught and handled.");
	    }
	    else {
		System.out.println("Taking out " + inputCountry + " via input variable:" 
				+ inputBridge.getccISO() + " " 
				+ inputBridge.getccIDD());
	    }
        
        System.out.println("\n\nAll six enum demonstrations shown.");
        System.out.println("Bye");
    }

}
