package gov.sgus;

import java.time.*;
import java.io.*;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class enumSample2 {

static String str;
static final int dirCap = 50;
static final int callCap = 100;
static DirEntry[] myPhoneBook = new DirEntry[dirCap];
//static String[] dirName = new String[dirCap];
//static String[] dirTel = new String[dirCap];
//static String[] dirArea = new String[dirCap];
static int dirCnt = 0;
static LocalDateTime[] callStarted = new LocalDateTime[callCap];
static String[] callTel = new String[callCap];
static int[] callDuraSec = new int[callCap];
static int callCnt = 0;
static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
static DateTimeFormatter fmtDuration = DateTimeFormatter.ofPattern("HH:mm:ss");

//static BufferedReader keybInput = new BufferedReader(new InputStreamReader(System.in));  // This is for use keyboard input
public static Scanner keybInput = new Scanner(System.in);

    public static String fixLength(int num, int len) {
        String strTmp;
        strTmp = Integer.toString(num);
        strTmp = " ".repeat(len - strTmp.length()).concat(strTmp);
        return strTmp;
    }
        
    public static String fixLength(String str, int len) {
        if (str.length() >= len) {
            return str.substring(0, len);
        }
        return str.concat(" ".repeat(len - str.length()));
    }
    
    public static void helpMessages() {
        System.out.println("Commands available:");
        System.out.println("'stop' to quit.");
        System.out.println("'help' for helpt.");
        System.out.println("'ld' to list all telephone directories.");
        System.out.println("'ld nn' to display <nn>th telephone directory.");
        System.out.println("'rd nn' to delete <nn>th telephone directory.");
        System.out.println("'ad <telephone directory entry details>' to add a telephone directory entry.");
        System.out.println("'lc' to list all call entries.");
        System.out.println("'lc nn' to display <nn>th call entry.");
        System.out.println("'rc nn' to delete <nn>th call entry.");
        System.out.println("'ac <call entry details>' to add a call entry.");
    }

    public static void loadData() throws IOException { // load directory and call history from text file
//        File fileInput = new File("C:\\Users\\deng\\Desktop\\Course4labs\\PackageApp\\build\\classes\\gov\\sgus\\enumSample2i.txt"); // The input data file
        File fileInput = new File("enumSample.txt"); // The input data file
        System.out.println("File working directory is " + fileInput.getAbsolutePath());
        if (!fileInput.exists()) {
            System.out.println("Input data file " + fileInput.getName() + " does not exist.  Data loading skipped.");
            return;
        }
        FileReader frInput = new FileReader(fileInput);  
        BufferedReader brInput = new BufferedReader(frInput);
        dirCnt = 0;
        callCnt = 0;
        Boolean booEOF = false;
        do {
            try {str = brInput.readLine();} catch (IOException e) {
                System.out.println("Breaking out of do-while loop due to io exception.");
                System.out.println(e.getLocalizedMessage());break;}
            if (str == null) {
                System.out.println("EOF detected due to str null.");
                booEOF = true;
                break;
            }
            if (str.length() == 0) {
                System.out.println("EOF detected due to str length is 0.");
                booEOF = true;
                break;
            }
            switch (str.substring(0, 1)) {
                case "d": {
                    if (dirCnt >= dirCap) {
                        System.out.println("Directory capacity full, import discarded:" + str);
                    } else {
                        myPhoneBook[dirCnt] = new DirEntry(str.substring(1, 26), str.substring(26, 38), str.substring(38));
                        dirCnt++;
                    }
                    break;
                }
                case "c": {
                    if (callCnt >= callCap) {
                        System.out.println("Call capacity full, input discarded:" + str);
                    } else {
                        callStarted[callCnt] = LocalDateTime.parse(str.substring(1, 20));
                        callTel[callCnt] = str.substring(20, 32);
                        callDuraSec[callCnt] = Integer.parseInt(str.substring(32));
                        callCnt++;
                    }
                    break;
                }
                case "s": {
                    System.out.println("EOF detected due to command s encountered.");
                    booEOF = true;
                    break;
                }
                default: {
                    System.out.println("Invalid input, loading aborted:" + str);
                    booEOF = true;
                    break;
                }
            }
        } while (!booEOF);
        brInput.close();
        frInput.close();
        System.out.println("Telephone directory entries imported: " + dirCnt + ".");
        System.out.println("Telephone call history imported: " + callCnt + ".");
    }

    public static int listDirs(int dirI) {
        if (dirI == 0) {  // 0 to list all
            if (dirCnt == 0) {
                System.out.println("Directory is empty.");
                return -1;
            }
            System.out.println("Seq Name            Telephone");
            System.out.println("--- " + "-".repeat(15)+" "+"-".repeat(12));
            for (int i = 0; i < dirCnt; i++) {
                System.out.println(fixLength(i+1,3) + " " + fixLength(myPhoneBook[i].getDirName(),15) +" "+myPhoneBook[i].getDirTel());
            }
            System.out.println("--- " + "-".repeat(15)+" "+"-".repeat(12));
            System.out.println(dirCnt + " names listed.");

            return -1;
        }
        else {
            if (dirI > dirCnt) {
                System.out.println("Directory seq " + dirI + " does not exist.");
                return -1;
            }
            System.out.println("Directory seq " + dirI + " " + myPhoneBook[dirI -1]);
            return dirI;
        }
    }

    public static int addDir(String str) {
        if (dirCnt >= dirCap) {
            System.out.println("Directory capacity full, add discarded:" + str);
            return -1;
        }
        if (str.length() < 38) {
            System.out.println("Directory entry too short, please try again:" + str);
            return -1;
        }

        String setOK;

        myPhoneBook[dirCnt] = new DirEntry();
        setOK = myPhoneBook[dirCnt].setDirName(str.substring(0, 25));
        if (!setOK.equals("")) {
            System.out.println(str + " is rejected,");
            System.out.println(setOK);
            return -1;
        }
        
        setOK = myPhoneBook[dirCnt].setDirTel(str.substring(25, 37));
        if (!setOK.equals("")) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(25) + setOK);
            return -1;
        }

        setOK = myPhoneBook[dirCnt].setDirArea(str.substring(37));
        if (!setOK.equals("")) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(37) + setOK);
            return -1;
        }
                
        dirCnt = dirCnt + 1;
        System.out.println("New directory entry added:");
        listDirs(dirCnt);
        return dirCnt - 1;
    }

    public static int delDir(int dirI) throws IOException {
        if (dirCnt == 0) { 
            System.out.println("Directory is empty.");
                return -1;
        }
        if (dirI <= 0) { 
            System.out.println("Please specify a directory seq number to delete.");
                return -1;
        }
        if (dirI > dirCnt) { 
            System.out.println("Directory seq " + dirI + " does not exist, nothing to delete.");
                return -1;
        }
        listDirs(dirI);
        System.out.print("*** Enter 'D' to confirm deleting this entry from directory:");
//        String strTmp = keybInput.readLine();
        String strTmp = keybInput.nextLine();
        if (strTmp.equals("D")) {
            dirCnt = dirCnt - 1;
	    for (int i = dirI -1; i < dirCnt; i++) {
		myPhoneBook[i] = myPhoneBook[i+1];
	    }
            System.out.println("*** Directory entry deleted.");
	    return -1;
	}
        System.out.println("*** Directory entry NOT deleted.");
        return dirI;
    }

    public static int listCalls(int callI) {
        LocalDateTime dtsTmp;
        int    intCallRate;
        // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (callI == 0) {  // 0 to list all
            if (callCnt == 0) {
                System.out.println("Call list is empty.");
                return -1;
            }
            System.out.println("Seq Date Time of call   Telephone No Duration");
            System.out.println("--- ------------------- ------------ --------");
            for (int i = 0; i < callCnt; i++) {
                switchDateFormat(1);
                System.out.print(fixLength(i+1,3) + " " + callStarted[i].format(myFormatObj) + " " + fixLength(callTel[i],12) + " ");
                dtsTmp = LocalDateTime.of(2000,1,1,0,0,0).plusSeconds(callDuraSec[i]);
                switchDateFormat(3);
                System.out.println(dtsTmp.format(myFormatObj));
            }
            System.out.println("--- ------------------- ------------ --------");
            System.out.println(callCnt + " names listed.");
            switchDateFormat(1);
            return -1;
        }
        else {
            if (callI > callCnt) {
                System.out.println("Call item " + callI + " does not exist.");
                return -1;
            }
            switchDateFormat(5);
            System.out.print("Phone call seq " + callI + "{");
            System.out.print("Date:" + callStarted[callI -1].format(myFormatObj));
            switchDateFormat(4);
            System.out.print(", time:" + callStarted[callI -1].format(myFormatObj));
            System.out.print(", called tel:" + callTel[callI -1]);
            intCallRate = DirEntry.findCallRate(callTel[callI -1]);
            System.out.print(" at $" + (intCallRate / 100) + "." +  ("" + (100 + intCallRate % 100)).substring(1,3) +  " per minute");
            System.out.print(", call duration:" + LocalDateTime.of(2000,1,1,0,0,0).plusSeconds(callDuraSec[callI -1]).format(fmtDuration));
            System.out.println(", charge:" + callDuraSec[callI -1] * intCallRate / 6000f + "}");
            switchDateFormat(1);
            return callI;
        }
    }
    
    public static int addCall(String str) {
        //  call record input format:
        //  "YYYY-MM-DDTHH:MM:SS+60123456789nnnn"
        //   call date time     Tel         call_duration
        String strDuraSec;
        String strAreaCode = "";
        if (callCnt >= callCap) {
            System.out.println("Call list capacity full, add discarded:" + str);
            return -1;
        }
        
        
        
        if (str.length() < 32) {
            System.out.println("Directory entry too short, please try again:" + str);
            return -1;
        }

        try {callStarted[callCnt] = LocalDateTime.parse(str.substring(0, 19));}
        catch (Exception e) {
            System.out.println(str + " is rejected,");
            System.out.println("^".repeat(19) + " call date time invalid, accepted format is <YYYY-MM-DDTHH:MM:SS>.");
            return -1;
        }

        callTel[callCnt] = str.substring(19, 31);

        if (callTel[callCnt].isBlank()) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(20) + "^".repeat(12) + " telephone number must not be blank.");
            return -1;
        }
        if (!callTel[callCnt].substring(0,3).equals("+60")) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(20) + "^".repeat(3) + " telephone number must begin with +60.");
            return -1;
        }
        strAreaCode = DirEntry.findAreaCode(callTel[callCnt]);
        if (strAreaCode == null) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(37) + "^^" + " is non-existent area code.");
            return -1;
        }

        strDuraSec = str.substring(31);
        if (strDuraSec.length() > 4) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(31) + "^".repeat(strDuraSec.length()) + " only 4 digits allowed for call duration in sec.");
            return -1;
        }
		
        try {callDuraSec[callCnt] = Integer.parseInt(strDuraSec); }
        catch (Exception e) {
            System.out.println(str + " is rejected,");
            System.out.println(" ".repeat(31) + "^".repeat(strDuraSec.length()) + " call duration in sec must be numeric.");
            return -1;
        }
        callTel[callCnt] = callTel[callCnt].trim();
        callCnt = callCnt + 1;
        System.out.println("New call history added:");
        return callCnt - 1;
    }

    public static int delCall(int callI) throws IOException {
        if (callCnt == 0) { 
            System.out.println("Call list is empty.");
                return -1;
        }
        if (callI <= 0) { 
            System.out.println("Please specify a call history seq number to delete.");
                return -1;
        }
        if (callI > callCnt) { 
            System.out.println("Call history seq " + callI + " does not exist, nothing to delete.");
                return -1;
        }
        listCalls(callI);
        System.out.print("*** Enter 'D' to confirm deleting this entry from call history:");
        //String strTmp = keybInput.readLine();
        String strTmp = keybInput.nextLine();
        if (strTmp.equals("D")) {
            callCnt = callCnt - 1;
	    for (int i = callI -1; i < callCnt; i++) {
		callStarted[i] = callStarted[i+1];
		callTel[i] = callTel[i+1];
		callDuraSec[i] =callDuraSec[i+1];
	    }
            System.out.println("*** Call history entry deleted.");
	    return -1;
	}
        System.out.println("*** Call history entry NOT deleted.");
        return callI;
    }

    
    
    public static void dumpData() throws IOException { // save directory and call history to text file
        // File fileOutput = new File("C:\\Users\\deng\\Desktop\\Course4labs\\PackageApp\\build\\classes\\gov\\sgus\\enumSample2o.txt"); // The output data file
        File fileOutput = new File("enumSample.txt"); // The output data file
        if (fileOutput.createNewFile()) {
            System.out.println("Output file created: " + fileOutput.getName());
        } else {
            System.out.println("Output file already exists.");
        }
        FileWriter fwOutput = new FileWriter(fileOutput, true); // true means to append to output file
        BufferedWriter bwOutput = new BufferedWriter(fwOutput);
        for (int i = 0; i < dirCnt; i++) {
            bwOutput.write("d" + fixLength(myPhoneBook[i].getDirName(),25) + fixLength(myPhoneBook[i].getDirTel(),12) + myPhoneBook[i].getDirArea());
            bwOutput.newLine();
        }
        for (int i = 0; i < callCnt; i++) {
            switchDateFormat(2);
            bwOutput.write("c" + callStarted[i].format(myFormatObj) + "T");
            switchDateFormat(3);
            bwOutput.write(callStarted[i].format(myFormatObj) + fixLength(callTel[i],12) + callDuraSec[i]);
            bwOutput.newLine();
        }
        switchDateFormat(1);
        bwOutput.write("s");
        bwOutput.newLine();
        
        bwOutput.close();
        fwOutput.close();
    }


    
    public static void switchDateFormat(int intFmt) {
        switch (intFmt) {
            case 1: 
                myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                break;
            case 2: 
                myFormatObj = DateTimeFormatter.ofPattern("YYYY-MM-dd");
                break;
            case 3: 
                myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                break;
            case 4: 
                myFormatObj = DateTimeFormatter.ofPattern("hh:mm:ssa");
                break;
            case 5: 
                myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                break;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        int dirIndex = -1;
        int dirI;
        int callIndex = -1;
        int callI;
        
        System.out.println("\n\n\n\nBegin Enum exercise");

        loadData();
        
        System.out.println("\n\n\n\nReady for user input, 'stop' to quit, 'help' for available commands:");
        // str = keybInput.readLine();
        str = keybInput.nextLine();
        while (!str.equals("stop")) {
            procCmds : {
                if (str.equals("help")) {
                    helpMessages();
                    break procCmds;
                } 
                if (str.equals("ld")) {
                    listDirs(0);
                    dirIndex = -1;
                    break procCmds;
                } 
                if (str.equals("rd")) {
                    dirIndex = delDir(dirIndex);
                    break procCmds;
                } 
                if (str.equals("lc")) {
                    listCalls(0);
                    callIndex = -1;
                    break procCmds;
                }
                if (str.equals("rc")) {
                    callIndex = delCall(callIndex);
                    break procCmds;
                } 
                if (str.length() >= 4){
                    String strCmd = str.substring(0,3);
                    if (strCmd.equals("ld ")) {
                        dirI = Integer.parseInt(str.substring(3));
                        dirIndex = listDirs(dirI);
                        break procCmds;
                    }
                    if (strCmd.equals("ad ")) {
                        dirIndex = addDir(str.substring(3));
                        break procCmds;
                    }
                    if (strCmd.equals("rd ")) {
                        dirI = Integer.parseInt(str.substring(3));
                        dirIndex = delDir(dirI);
                        break procCmds;
                    }
                    if (strCmd.equals("lc ")) {
                        callI = Integer.parseInt(str.substring(3));
                        dirIndex = listCalls(callI);
                        break procCmds;
                    }
                    if (strCmd.equals("ac ")) {
                        dirIndex = addCall(str.substring(3));
                        break procCmds;
                    }
                    if (strCmd.equals("rc ")) {
                        callI = Integer.parseInt(str.substring(3));
                        callIndex = delCall(callI);
                        break procCmds;
                    }
                }
                System.out.println("Invalid command:" + str);
                helpMessages();
            }
            //str = keybInput.readLine();
            str = keybInput.nextLine();
        }

        // dump all data to text file
    dumpData();

    System.out.println("Bye");
    }
}



