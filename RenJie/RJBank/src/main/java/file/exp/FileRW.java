package file.exp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileRW {

    public static String fileName = "";

    public static Scanner myObj = new Scanner(System.in);

    public static void main(String[] args) {
       try{
        File f = new File("C:\\Users\\wakar\\OneDrive\\Desktop\\sgus\\5javacapstone2\\FileExplorer\\FileExplorer\\TestFolder"); // working directory - all my operation henceforth will happen here....
                                //  Fixed path at the start of the program 
        if (f.exists()) {
            System.out.print(" Enter file name to create and then write 2 it :: ");
            fileName = myObj.nextLine();
            System.out.println(" File Name Entered is : " + fileName);
            File newF = new File(f.getAbsolutePath() + "\\" + fileName);
            if (newF.exists()) {
                System.out.println(" File already exists");
                System.exit(0);
            }
            if (newF.createNewFile()) {
                FileWriter fw = new FileWriter(newF);
                System.out.println(" Enter File Content [quit] to stop");
                String newLine = "";
                do {
                    
                    fw.write(newLine + "\n");
                    newLine = myObj.nextLine();

                } while (!newLine.equals("quit"));
                fw.close();
                System.out.println(" Do you want to display the file contents [Y/N] ");
                String resp = myObj.nextLine();
                if (resp.equals("Y") || resp.equals("y")) {
                    FileReader fr = new FileReader(newF);
                    
                    int i = 0;
                    while ((i = fr.read()) != -1) {
                        System.out.print((char) i);
                    }
                    fr.close();
                }
            }
        }
       }catch(Exception e ){
           // handle - understand the exception
           // do corrective measures 
           // but no then 
            // at least log it       
       }
    }
}
