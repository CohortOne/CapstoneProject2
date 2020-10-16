/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.exp;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author wakar
 */
public class MyFileBIOS {

    public static Scanner sc = new Scanner(System.in);
//    File root = new File("..\\..");
    static String localDir = System.getProperty("user.dir");
    static String toTesting = "\\testing";
    public static String fileName = "";
    public static File file;

    public static void m1(Object x) {
        try {
            String content = x.toString();
            File f = new File(localDir + toTesting);
            System.out.println("Folder to be saved in is: " + f);
            if (f.exists()) {
                System.out.println(" Enter file name to create and then write to it: ");
                fileName = sc.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                file = new File(f.getAbsolutePath() + "\\" + fileName);
                if (file.exists()) {
                    System.out.println(" File already exists");
                } else if (file.createNewFile()) {
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedOutputStream bos = new BufferedOutputStream(fos); 
                    bos.write(content.getBytes());
                    bos.flush();
                    System.out.println("File written Successfully");
                    bos.close();
                    System.out.print(" Do you want to display the file contents [Y/N] : ");
                    String resp = sc.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        int ch = 0;
                        while ((ch = bis.read()) != -1) {
                            System.out.print((char) ch);
                        }
                        bis.close();
                        
                    }
                    
                    
                    
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(localDir);
        File f = new File(localDir + toTesting);
        System.out.println(f);
        if (f.exists()) {
            System.out.println(" Enter file name to create and then write to it: ");
            fileName = sc.nextLine();
            System.out.println(" File Name Entered is : " + fileName);
            file = new File(f.getAbsolutePath() + "\\" + fileName);

        }

    }
//    File f = new File(localDir);

}
