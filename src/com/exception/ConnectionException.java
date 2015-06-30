/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception;

/**
 *
 * @author Jaime Hidalgo García
 */
public class ConnectionException extends Exception {
    
    public ConnectionException(String str){
        super(str);
    }
    
    public ConnectionException(){
        super();
    }
}