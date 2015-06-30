/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Hidalgo García
 */
public class Functions {
     public static String displayDate(long fecha){
        Date date=new Date(fecha*1000);
        
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        df2.setTimeZone(TimeZone.getTimeZone("gtm"));
        
        String dateText = df2.format(date);
        return dateText;
    }
    
    public static String changeSpaces(String str){
        String a = str.replaceAll(" ", "");
        return a;
    }
    
    public static void loadLink(String url) {

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
    //http://www.lolnexus.com/EUW/search?name=rubikselcubo&region=EUW
    public static String genLink(String id) {

        String cadena = ("https://www.youtube.com/watch?v=" + id );
        return cadena;
        
    }
    
    public static String getID(String url){
        int index = url.indexOf("?v=") + 3;
        String begin = url.substring(index);
        index = begin.indexOf("?");
        String part;
        if (index!=-1)  part = begin.substring(0, index);
        else part = begin;
        return part;
    }
    
    
}
