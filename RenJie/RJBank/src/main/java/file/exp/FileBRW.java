package file.exp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileBRW {

    public static String fileName = "";
    public static File file;
    public static Scanner myObj = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\wakar\\OneDrive\\Desktop\\sgus\\5javacapstone2\\FileExplorer\\FileExplorer\\TestFolder"); // working directory - all my operation henceforth will happen here....
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.print(" Enter file name to create and then write 2 it :: ");
                fileName = myObj.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                file = new File(f.getAbsolutePath() + "\\" + fileName);
                if (file.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    System.out.println(" Enter File Content [quit] to stop");
                    String newLine = "";
                    do {
                        bw.write(newLine + "\n");
                        newLine = (myObj.nextLine());
                    } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                    bw.flush();
                    //   bw.close();
                    //   fw.close();
                    System.out.print(" Do you want to display the file contents [Y/N] : ");
                    String resp = myObj.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        String line = br.readLine();
                        while (line != null) {
                            System.out.println(line);
                            line = br.readLine();
                        }
                    //   br.close();
                     //   fr.close();

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
