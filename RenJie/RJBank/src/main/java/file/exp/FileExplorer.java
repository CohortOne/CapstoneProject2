/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.exp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chand
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

    public static int DisplayOptions() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
        System.out.println(" \n\t\t10 >> Exit ");

        System.out.println("\n ********************************************************************************************* ");
        // Create a Scanner object
        System.out.print(" Enter a numer to carry out the operation  :   ");
        int optVal;
        try {
            optVal = myObj.nextInt();
        } catch (Exception e) {
            
            optVal = -1;
        }
        return optVal;
    }

    public static void printHeader() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println(" \n\n\n\n\n");
                    System.out.println(" ===============================================================");
                    System.out.println("\t\t ROOT FOLDER NOT VALID ");
                    System.out.println(" ===============================================================");
                    Thread.sleep(5000);
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
                    break;
                case 2:
                    System.out.println("Create Directory Tree");
                    break;
                case 3:
                    System.out.println("Change Directory");
                    break;
                case 4:
                    System.out.println("Create File");
                    break;
                case 5:
                    System.out.println("Display File");
                    break;
                case 6:
                    System.out.println("Copy File");
                    break;
                case 7:
                    System.out.println("Rename File");
                    break;
                case 8:
                    System.out.println("Delete File");
                    break;
                case 9:
                    System.out.println("Delete Folder or Folders");
                    break;
                case 10:
                    System.out.println("Exit");
                    printFooter();
                    Thread.sleep(4000);
                    System.exit(0);
                    break;
                default:
                    //printHeader();
                    System.out.println(" \n\n \t\t #### Invalid Option ####");
                    printFooter();
                    Thread.sleep(4000);
                    break;
            }

            printFooter();
            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

}
