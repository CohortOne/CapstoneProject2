
package com.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author tohch
 */
public class FileIOSt {
    public static String newFileName = "";
    //public static File newFile;
    public static Scanner myScObj = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
        File fDir = new File("C:\\Temp\\IOTest\\"); //  Fixed the file path at the start of the program}
        
        if (fDir.exists()) {
           System.out.println("Please enter the file name you wish to create : ");
           newFileName=myScObj.nextLine();
           //"Append the file name to the established directory"
           System.out.println("The File Name entered is : " + newFileName);
           File newFile = new File(fDir.getAbsolutePath() + "\\" + newFileName);
           if (newFile.exists()){
               System.out.println("!! This file already exists !!");
               System.exit(0);   
           }
           // If Doesn't eist, confirm with createNewFuile is true
           if (newFile.createNewFile()) {
               
               FileOutputStream fos = new FileOutputStream(newFile);
               System.out.println(" Enter File Content and on new line [quit] to stop");
               String inLine="";
               //Below will write at least once null.
               //Iterate with Input by Line but Output by Byte!!!
               do{
               fos.write((inLine + "\n").getBytes());
               inLine= myScObj.nextLine();
               } while (!(inLine.equals("quit") || inLine.equals("QUIT") || inLine.equals("Quit")));
               fos.close();
               // Do you waish to print the content of the file?
               System.out.print(" Do you want to display the file contents [Y/N] : ");
               String cont= myScObj.nextLine();
               if (cont.equals("Y") || cont.equals("y")) {
                 FileInputStream fis = new FileInputStream(newFile);

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
        
//}   
//}
