/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test1;

import static com.test1.FileIOSt.myScObj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author tohch
 */
public class FileBIOSt {
    public static String bsFileName = "";
    public static File bsFile;
    public static Scanner myObj = new Scanner(System.in);
    
    public static void main(String[] args) {
        try{
            // File establishes a path name
            File f = new File("C:\\Temp\\IOTest\\"); //  Fixed the file path at the start of the program}
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.println("Please enter file name you wish to create:");
                bsFileName=myObj.nextLine();
                System.out.println("Your file name is : " + bsFileName);
                //Establish a new Path Name from previous f.getAbsolutePath and append bsFileName
                bsFile = new File(f.getAbsolutePath() + "\\" + bsFileName);
                //Check whether such a file woth the Path already exists
                if (bsFile.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                //Check to ensure "True" that the file (Path) is Created successfuly
                // Setup a file Output Stream
                //
                if (bsFile.createNewFile()){
                    FileOutputStream bos = new FileOutputStream(bsFile);
                    System.out.println(" Enter File Content and on new line [quit] to stop");
                    String inLine="";
                    //Below will write at least once null.
                    //Iterate with Input by Line but Output by Byte!!!
                    do{
                        bos.write((inLine + "\n").getBytes());
                        inLine= myObj.nextLine();
                        } while (!(inLine.equals("quit") || inLine.equals("QUIT") || inLine.equals("Quit")));
                    bos.flush();
                    bos.close();
                     // Do you waish to print the content of the file?
               System.out.print(" Do you want to display the file contents [Y/N] : ");
               String cont= myObj.nextLine();
               if (cont.equals("Y") || cont.equals("y")) {
                 FileInputStream fis = new FileInputStream(bsFile);

                        int ch = fis.read();
                        while (ch != -1) {
                            System.out.print((char) ch);
                            ch = fis.read();
                        }
                    }  
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
