package com.test1;
import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.Scanner;
	
	public class FileIO {
	
	    public static String myFileName = "";
	
	    public static Scanner myObj = new Scanner(System.in);
	
	    public static void main(String[] args) {
	       try{
	        File fd = new File("C:\\Temp\\IOTest\\"); //  Fixed the file path at the start of the program
	        if (fd.exists()) {
	            System.out.print(" Enter file name to create :: ");
	            myFileName = myObj.nextLine();
	            System.out.println(" File Name Entered is : " + myFileName);
	            File newF = new File(fd.getAbsolutePath() + "\\" + myFileName);
	            if (newF.exists()) {
	                System.out.println(" File already exists");
	                System.exit(0);
	            }
	            if (newF.createNewFile()) {
	                System.out.println(" File Created with the following details ");
                        //TEST OUT newF API)
                        //  Below
	                System.out.println(newF.getName());           //get the name of the newF
                        System.out.println(" has been created in the folder :");
	                System.out.println(newF.getParent());         //get the parent dir level of the newF
	                System.out.println(newF.getAbsolutePath());   // get the full Path from Root to file
	                //System.out.println(newF.getAbsoluteFile());  // same as above - get the full Path from Root to file
	                
                        //Establish File Writer for newF
	                FileWriter fw = new FileWriter(newF);
	                
	                System.out.println(" Enter File Content. Enter [quit] on a new line to stop");
	                String newLine = "";
	                do {
	                    fw.write(newLine + "\n");
	                    newLine = myObj.nextLine();

	                } while (!newLine.equals("quit"));
                        //Close File Writer
	                fw.close();
	                System.out.println(" Do you want to display the file contents [Y/N] ");
	                String resp = myObj.nextLine();
	                if (resp.equals("Y") || resp.equals("y")) {
                            //Establish a File Reader fore  newF
	                    FileReader fr = new FileReader(newF);
	                   //Iterate through the contents and print it out 
	                    int i = 0;
	                    while ((i = fr.read()) != -1) {
	                        System.out.print((char) i);
	                    }
	                    fr.close();
                           
                        //Below Statement is used to deleted the file. It's just for testing. 
                        //If you look at the Windows file explorer, you willnotice the file has been created 
                        //    and removed after the statment below
	               
                        //if (newF.delete()) {
	                //System.out.println(" File Deleted");
	                //System.exit(0);
	                //}
	            }
	            
	        }
                }

	       }catch(Exception e ){
	           // handle - understand the exception
                   // at least log it 
	           e.printStackTrace();
	            // at least log it 
	           
	       }
	    }
	}

