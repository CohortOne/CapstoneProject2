/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.exp;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chand
 * 
 * Modified by: Wong Keng
 * 
 */
public class FileExplorer {

    public static String rootDir;
    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;
    public static ArrayList<String> dirListing = new ArrayList<String>();

    public static void toContinue() {
        myObj.next();
    }

    public static String printPretty() {
        String s = "\n  |";
        for(int i = 0; i <= iteration; i++)
            s += "---";
        return  s + " >> " ;
    }

    public static ArrayList recursivelyList(File folder) {
        
        for (String str : folder.list()) {
            File file = new File(folder + "\\" + str);
            if (file.isDirectory()) {
                dirListing.add(printPretty() + file.getName());
                iteration++;
                recursivelyList(file);
            } else {
                dirListing.add(printPretty() +  file.getName());
            }
        }
        iteration--;
        return dirListing;
    }

    public static int dirOps(int opVal) {
        if (opVal == 0) {
            File rDir = new File(rootDir);
            //recursivelyList(rDir);
            System.out.println(recursivelyList(rDir));
        }
        return 0;
    }
    
    public static int createDir() {
        
        System.out.print("Please enter name of new directory: ");
        String dirName = System.console().readLine();
        
        File mDir = new File(rootDir + '/' + dirName);
        
        boolean statusCreate = mDir.mkdir();
        
        if (statusCreate) {
            System.out.println("New directory " + dirName + " successfully created.");
            return 0;
        }
        else {
            System.out.println("Error creating new directory");
            return (-1);
        }
    }
        
    public static int createDirTree() {
        
        System.out.print("Please enter name of new directory tree to create: ");
        String dirName = System.console().readLine();
        
        File mDir = new File(rootDir + '/' + dirName);
        
        boolean statusCreate = mDir.mkdirs();
        
        if (statusCreate) {
            System.out.println("New directory tree " + dirName + " successfully created.");
            return 0;
        }
        else {
            System.out.println("Error creating new directory tree");
            return (-1);
        }       
        
    }
    
     public static int changeDir() throws IOException {
        
        System.out.print("Please enter name of directory to change to: ");
        String dirName = System.console().readLine();
        
        File mDir = new File(rootDir + '/' + dirName);
        
        //return absolute pathname of the new destination directory
        
        String destDirPath = mDir.getAbsolutePath();
                
        //change dir to new diestination
        
        System.setProperty("user.dir", destDirPath); 
        
        System.out.println("New working directory is " + System.getProperty("user.dir"));
        
        //to check that I am indeed in the new destination directory by creating a dummy folder under it
        
//        File mmDir = new File(destDirPath + '/' + "dummy");
//        
//        boolean statusCreate = mmDir.mkdir();
        
        return (0);
    }
     
     public static void createFile() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of file to create: ");
        String fName = System.console().readLine();
        
        File fp = new File(fName);
        
        boolean fileCreationStatus = fp.createNewFile();
        
        System.out.println("File name is " + fp.getName());
        
        if (fileCreationStatus) {
            //write to file
            String note = "This is a test message.";
            
            //open fName for writing
            FileWriter myWrite = new FileWriter(fName);
            myWrite.write(note);
            myWrite.close();
            System.out.println("Write successful!");
        }
        else {
            System.out.println("Something went wrong. File creation failed.");
        }
    }
     
     public static void readFileContent() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of file to read: ");
        String fName = System.console().readLine();
        
        File fp = new File(fName);
        
        FileInputStream inputStream = new FileInputStream(fp);
        
        int oneByte;
        
        while((oneByte = inputStream.read()) != -1) {
            System.out.write(oneByte);
        }
        
        inputStream.close();
        System.out.flush();
    }
    
     public static void copyFile() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of file to be copied: ");
        String fName = System.console().readLine();
        
        System.out.print("Please enter name of the copied file: ");
        String copyfName = System.console().readLine();
        
        
        
        File fp = new File(fName);
        File copyfp = new File(copyfName);
        
        FileInputStream inputStream = new FileInputStream(fp);
        FileOutputStream outputStream = new FileOutputStream(copyfp);
        
        
        int oneByte;
        
        while((oneByte = inputStream.read()) != -1) {
            outputStream.write(oneByte);
            outputStream.flush();
        }
        
        outputStream.close();
    }
    
     public static void renameFile() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of file to be renamed: ");
        String fName = System.console().readLine();
        
        System.out.print("Please enter new file name: ");
        String newfName = System.console().readLine();
               
        File fp = new File(fName);
        File newfp = new File(newfName);
        
        //rename file
        if (fp.renameTo(newfp)) {
            System.out.println(fName + " successfully renamed to " + newfName);
        } else {
            System.out.println("Renaming UNsuccessful.");
        }
    }
    
     public static void deleteFile() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of file to be deleted: ");
        String fName = System.console().readLine();
        
        //include the pwd
                        
        File fp = new File(System.getProperty("user.dir") + '/' + fName);
        
        //delete file
        if (fp.delete()) {
            System.out.println(fName + " successfully deleted.");
        } else {
            System.out.println("Delete UNsuccessful.");
        }
    }
    
     public static void deleteFolder() throws IOException {
        //call changeDir() to set pwd
//        changeDir();

        System.out.println("Current working directory is " + System.getProperty("user.dir"));
        
        System.out.print("Please enter name of folder to be deleted: ");
        String dirName = System.console().readLine();
        
        File mDir = new File(rootDir + '/' + dirName);
        
//        System.out.println("mDir absolute path is " + mDir.getAbsolutePath());
                        
        //call recursive delete
        deleteNotEmptyDir(mDir);

//        System.out.println("Required folder deleted.");        
    }
     
     public static void deleteNotEmptyDir(File dir) {
        try
        {
             File [] files = dir.listFiles();
         
//         System.out.println("files array size " + files.length);
         
         
         for(File file : files) {
             
//             System.out.println("Inside forEach loop " + file.getAbsoluteFile());
             
             if (file.isDirectory()) {
                deleteNotEmptyDir(file); //recursive call if it is a folder
             } 
             else 
             {
//                System.out.println("deleting file..." + file.getAbsolutePath());
                boolean delStatus = dir.delete(); //delete the file
//                System.out.println("Delete status " + delStatus);
             }
                        
            System.out.println("deleting folder..." + file.getAbsolutePath());
            file.delete();
         }       
       
            //delet directory 'dir'
//            System.out.println("deleting folder..." + dir.getAbsolutePath());
            dir.delete();
//            System.out.println("Delete folder status " + dir.delete());
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }        
         
     }
    

    public static int DisplayOptions() throws Exception {
        Runtime.getRuntime().exec("clear");
        
        System.out.println("\n ********************************************************************************************* ");
        System.out.println("\n\tRoot Directory for File Operations ::: " + rootDir);
        System.out.println(" \t                                       ---------------------------------------");
        System.out.println("\n ********************************************************************************************* ");

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t0 >> Directory Listing");
        System.out.println(" \n\t\t1 >> Create Directory ");
        System.out.println(" \n\t\t2 >> Create Directory tree");
        System.out.println(" \n\t\t3 >> Change Directory");
        System.out.println(" \n\t\t4 >> Create File // Write to a File ");
        System.out.println(" \n\t\t5 >> Display File // Echo Contents of a File ");
        System.out.println(" \n\t\t6 >> Copy File ");
        System.out.println(" \n\t\t7 >> Rename File");
        System.out.println(" \n\t\t8 >> Delete File ");
        System.out.println(" \n\t\t9 >> Delete Folder or Folders");
        System.out.println(" \n\t\t111 >> Exit ");

        System.out.println("\n ********************************************************************************************* ");
        // Create a Scanner object
        System.out.print(" Enter a numer to carry out the operation  :   ");
        int optVal;
        try {
            optVal = myObj.nextInt();
        } catch (Exception e) {
            printHeader();
            System.out.println(" \n\n \t\t #### Invalid Option ####");
            optVal = -1;
        }
        return optVal;
    }

    public static void printHeader() throws Exception {
        Runtime.getRuntime().exec("clear");
        System.out.println(" ============================================================================================");

    }

    public static void printFooter() {
        System.out.println(" ============================================================================================");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            int optionVal = 0;
            if (args.length > 0) {
                rootDir = args[0];
                File rootFolder = new File(rootDir);
                if (rootFolder.exists()) {
                    optionVal = DisplayOptions();
                } else {
                    Runtime.getRuntime().exec("clear");
                    System.out.println(" \n\n\n\n\n");
                    System.out.println(" ===============================================================");
                    System.out.println("\t\t ROOT FOLDER NOT VALID ");
                    System.out.println(" ===============================================================");
//                    Thread.sleep(5000);
                    System.out.println(" \n\n\n\n\n");
                    System.exit(0);
                }
            }
            printHeader();
            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 0:
                    System.out.println("Directory Listing");
                    dirOps(0);
                    break;
                case 1:
                    System.out.println("Create Directory");
                    createDir();
                    break;
                case 2:
                    System.out.println("Create Directory Tree");
                    createDirTree();
                    break;
                case 3:
                    System.out.println("Change Directory");
                    changeDir();
                    break;
                case 4:
                    System.out.println("Create File");
                    createFile();
                    break;
                case 5:
                    System.out.println("Display File");
                    readFileContent();
                    break;
                case 6:
                    System.out.println("Copy File");
                    copyFile();
                    break;
                case 7:
                    System.out.println("Rename File");
                    renameFile();
                    break;
                case 8:
                    System.out.println("Delete File");
                    deleteFile();
                    break;
                case 9:
                    System.out.println("Delete Folder or Folders");
                    deleteFolder();
                    break;
                case 111:
                    System.out.println("Exit");
                    printFooter();
//                    Thread.sleep(1000);
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid Option, try again ");
                    break;
            }

            printFooter();
            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

}
