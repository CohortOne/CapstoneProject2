/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaira428;


/**
 *
 * @author Wong Keng
 */
public class BankCustomer {

    String firstName;
    String lastName;
    String nric;
    String nationality;
    String dobString;

    
    public BankCustomer(String firstName, String lastName, String nric, String nationality, String dobString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nric = nric;
        this.nationality = nationality;
        this.dobString = dobString;
    }

    
    @Override
    public String toString() {
        return "\nFirst Name=" + firstName + "\nLast Name=" + lastName + "\nNRIC=" + nric + "\nNationality=" + nationality + "\nDOB=" + dobString + "\n-----";
    }
   
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nric
     */
    public String getNric() {
        return nric;
    }

    /**
     * @param nric the nric to set
     */
    public void setNric(String nric) {
        this.nric = nric;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
       
}
