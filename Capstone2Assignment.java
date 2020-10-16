import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;




public class Capstone2Assignment {
      public static File file;
      public static void main(String[] args) throws IOException {
      InputStream is = null;
      DataInputStream dis = null;
      FileOutputStream fos = null;
      DataOutputStream dos = null;

            String fileName = "";
            try {
                  File f = new File("D:\\Capstone2Assignment"); // working directory - all my operation henceforth will happen here....
                  //  Fixed path at the start of the program 
                  if (f.exists()) {
                      Scanner input = new Scanner(System.in);
                      System.out.print(" Enter file name to create and then write 2 it :: ");
                      fileName = input.nextLine();
                      System.out.println(" File Name Entered is : " + fileName);
                      file = new File(f.getAbsolutePath() + "\\" + fileName);
                      if (file.exists()) {
                          System.out.println(" File already exists");
                          System.exit(0);
                          
                      }
                      
                      if (file.createNewFile()) {
                            fos = new FileOutputStream(file);
                            dos = new DataOutputStream(fos);
                      
                      
           
                  
            
            Scanner in = new Scanner(System.in);

            int userChoice;

            boolean quit = false;

            float balance = 0f;

            do {

                  System.out.println("1. Deposit money");

                  System.out.println("2. Withdraw money");

                  System.out.println("3. Check balance");

                  System.out.print("Your choice, 0 to quit: ");

                  userChoice = in.nextInt();

                  switch (userChoice) {

                  case 1:

                        float amount;

                        System.out.print("Amount to deposit: ");

                        amount = in.nextFloat();
                        dos.writeFloat(amount);

                        if (amount <= 0)

                             System.out.println("Can't deposit nonpositive amount.");

                        else {

                             balance += amount;
                             
                            
                             System.out.println("$" + amount + " has been deposited.");

                        }

                        break;

                  case 2:

                        System.out.print("Amount to withdraw: ");

                        amount = in.nextFloat();
                        dos.writeFloat(amount);
                       
                        

                        if (amount <= 0 || amount > balance)

                             System.out.println("Withdrawal can't be completed.");

                        else {

                             balance -= amount;
                             
                            
                            
                             

                             System.out.println("$" + amount + " has been withdrawn.");

                        }

                        break;

                  case 3:

                        System.out.println("Your balance: $" + balance);
                        

                        break;

                  case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Wrong choice.");

                        break;

                  }
                  
                  System.out.println();
                    

            }while (!quit);
            dos.writeFloat(balance);
            dos.flush();
            System.out.println("Bye!");
            
            System.out.print(" Do you want to display the file contents [Y/N] : ");
            String resp = input.nextLine();
            if (resp.equals("Y") || resp.equals("y")) {
                 is = new FileInputStream(file);
                 dis = new DataInputStream(is);

                 while(dis.available()>0) {
                  float c = dis.readFloat();
                  System.out.print(c + " ");}
                  input.close(); 
            }
      }
      
                  }
             
               
            }
      
            catch (Exception e) {
                  e.printStackTrace();
              }
              finally {
                  // releases all system resources from the streams
                  if(is!=null)
                     is.close();
                  if(dos!=null)
                     is.close();
                  if(dis!=null)
                     dis.close();
                  if(fos!=null)
                     fos.close();
               }  
               
      }          
}      


