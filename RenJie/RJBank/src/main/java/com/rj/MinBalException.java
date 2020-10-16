/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rj;

/**
 *
 * @author wakar
 */
public class MinBalException extends Exception {

    /**
     * Creates a new instance of <code>MinBalException</code> without detail
     * message.
     */
    public MinBalException() {
    }

    /**
     * Constructs an instance of <code>MinBalException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MinBalException(String msg) {
        super(msg);
    }
}
