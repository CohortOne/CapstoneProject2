package com.test1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.Scanner;
	
	public class FileBIO {
	
	    public static String myFileName = "";
            public static File nfile;
	    public static Scanner myObj = new Scanner(System.in);
	
	    public static void main(String[] args) {
	       try{
	        File newF = new File("C:\\Temp\\IOTest\\"); // working directory my ops Fixed path at the start of the program  
	        if (newF.exists()) {
	            System.out.print(" Enter file name to create :: ");
	            myFileName = myObj.nextLine();
	            System.out.println(" File Name Entered is : " + myFileName);
	            nfile = new File(newF.getAbsolutePath() + "\\" + myFileName);
	            if (nfile.exists()) {
	                System.out.println(" File already exists");
	                System.exit(0);
	            }
	            if (nfile.createNewFile()) {
	                System.out.println(" File Created with the following details ");
                        //TEST OUT file API)
                        //  Below
	                System.out.println(nfile.getName());           //get the name of the file
                        System.out.println(" has been created in the folder :");
	                System.out.println(nfile.getParent());         //get the parent dir level of the file
                        System.out.println("Amount of Space allocated to the file is :");
	                System.out.println(nfile.getFreeSpace());   //Check space allocatedd to this file
                        //Establish a new File Writer fw
	                FileWriter fw = new FileWriter(nfile);
                        //Establish a new Buffer Writer  associated with File Writer fw
                        BufferedWriter bw = new BufferedWriter(fw);
	                //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	                System.out.println(" Enter File Content [quit] to stop");
	                String newLine = "";
	                do {
	                    bw.write(newLine + "\n");
                            newLine = (myObj.nextLine());
	                    // versus fw below
                            //fw.write(newLine + "\n");
	                    //newLine = myObj.nextLine();
                          
	                } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                            bw.flush();
                            bw.close();
                            fw.close();
                        //
                        //Versus below ONLY closing fr.close()
                        //while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
	                //fw.close();
	                System.out.println(" Do you want to display the file contents [Y/N] ");
	                String resp = myObj.nextLine();
                        //
	                if (resp.equals("Y") || resp.equals("y")) {
                          FileReader fr = new FileReader(nfile);
                          BufferedReader br = new BufferedReader(fr);

                        String line = br.readLine();
                        while (line != null) {
                            System.out.println(line);
                            line = br.readLine();
                        }
                        br.close();
                        fr.close();
                        //Vesrsus below
                        //if (resp.equals("Y") || resp.equals("y")) {
	                //    FileReader fr = new FileReader(file);
	                    
	                //    int i = 0;
	                //    while ((i = fr.read()) != -1) {
	                //        System.out.print((char) i);
	                //    }
	               //     fr.close();
                           
                        //Can we try opening a closed file
                        //bool=file.delete;
	               //if (file.delete()) {
                       //   System.out.println(" File Deleted");
	               //   System.exit(0);
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
