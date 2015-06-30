/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Hidalgo García
 */
public class TextFile {
    
    public final File file;
    public boolean append = true;
    
    public TextFile(String name){
        file = new File(name);
        if(!file.exists())
                createNewFile();
        
    }
    
    private void createNewFile(){
        
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        append = true;
        
    }
    
    public void setAppend(boolean ap){
        append = ap;
    }
    
    private BufferedReader openReadStreams() throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }
    
    private PrintWriter openWriteStreams() throws IOException{
        FileWriter fw = new FileWriter(file,append);
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(br);
        return pw;
    }
    
    public synchronized void writeLine (String str){
        try(PrintWriter pw = openWriteStreams() ){
             pw.println(str);
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String readString(){
        String str = null;
        try(BufferedReader br = openReadStreams() ){
            str = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    
    
    
    
    private int countLines(){
        int lines = 0;
        String str;
        try(BufferedReader br = openReadStreams() ){
            while( (str = br.readLine()) != null  ){
               lines++;
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return lines;
    }
    
    public void saveGame (String str){
        try( PrintWriter pw = openWriteStreams() ){
            pw.print(str);
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean exists(){
        return file.exists();
    }
    
    public void createFile(){
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Map<Integer,String> loadChampions(){
        Map<Integer, String> champs = new HashMap<>();
        String str;
        String[] chain;
        
        try (BufferedReader br = openReadStreams()) {
            while ((str = br.readLine()) != null) {
                chain = str.split(" ");
                champs.put(Integer.parseInt( chain[1] ), chain[0]);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return champs;
    }
    
}
