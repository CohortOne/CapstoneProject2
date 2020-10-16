import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class planC{


   
        String name;
        int id;
        int age;
        
        planC(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;

        }
        public void displayDetails() {
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("ID: " + this.id);
        }
    
    
        public static void main(String []args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Name: ");
            String name = reader.readLine();
            System.out.println("Enter Your Age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Enter Your ID: ");
            int id = Integer.parseInt(reader.readLine());
            planC std = new planC(name, age, id);
            std.displayDetails();
        }
    }
