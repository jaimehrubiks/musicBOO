/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

/**
 *
 * @author Jaime Hidalgo García
 */
public class ErrorLogger {
    
    private static final TextFile logger = new TextFile("log.txt");
    
    static{
        logger.createFile();
        logger.setAppend(false);
    }
    
    public static void toFile(String str){
        toFile("Error",str);
    }
    
    public synchronized static void toFile(String type, String str){
        logger.writeLine(type+": "+str);
    }
    
    public static void toScreen(String str){
        System.out.println(str);
        toFile("Log",str);
    }
}