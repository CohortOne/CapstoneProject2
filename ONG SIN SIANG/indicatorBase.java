import java.io.BufferedReader;
import java.io.FileReader;

public class indicatorBase {
    public static void main (String [] args) {
         // Creates an array of Characters
        char[] array = new char [100];

        try {
              // Creates a FileReader
            FileReader file = new FileReader("C:\\Users\\BREN POWERPC\\Desktop\\PROJECT CAPSTONE 2\\OperationBasic\\Experiment");
             // Creates a Buffered Reader
            BufferedReader input = new BufferedReader(file);
              // Reads Characters
            input.read(array);
            System.out.println("Data in the File: ");
            System.out.println(array);
              // Closes the Reader
            input.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}