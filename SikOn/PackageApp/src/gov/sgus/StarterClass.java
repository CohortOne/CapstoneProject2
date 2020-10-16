/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.sgus;

/**
 *
 * @author deng
 */
public class StarterClass {

    public static void main(String[] args) {

        System.out.println("Do sample 1.");
        enumSample1.main(args);
        
        System.out.println("\n\n\nDo sample 2.");
        try {enumSample2.main(args);}
        catch (Exception e) {}
    }
}
