/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime
 */
public class UserSettings {
    
    public static File          configFile = new File("config/config.properties");
    public static Properties    configProps;
    
    static{
        
    }
    
    public static void saveProperties(){
           try {
            OutputStream outputStream = new FileOutputStream(configFile, false);
            configProps.storeToXML(outputStream, "MUSIC BOO SETTINGS FILE");
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(UserSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadDefaults(){
        //-x, --extract-audio     
        Properties defaultProps = new Properties();
        defaultProps.setProperty("DownloadsFolder"  , "./downloads" );
        defaultProps.setProperty("AudioFormat"      , "mp3"         ); //--audio-format FORMAT  //3 is mp3
        defaultProps.setProperty("AudioQuality"     , "128K"        ); //--audio-quality QUALITY //0 is best conversion
        defaultProps.setProperty("VideoFormat"      , "bestaudio"   ); //-f, --format FORMAT   //2 is bestaudio
        defaultProps.setProperty("KeepVideo"        , "false"       ); //-k
        defaultProps.setProperty("PostVideoConvert" , "no"          ); //--recode-video FORMAT //0 is no
        defaultProps.setProperty("ONLYVIDEOS"       , "false"       ); //-x
        defaultProps.setProperty("ParallelDownloads", "5"           ); 
        defaultProps.setProperty("disableSSL"       , "true"       ); 
        defaultProps.setProperty("autoupdate"       , "true"       ); 
        defaultProps.setProperty("fc        "       , "false"       ); 
        if(!(configProps==null))
            defaultProps.setProperty("TermsAccepted"    , configProps.getProperty("TermsAccepted", "false")       ); 
        defaultProps.setProperty("DefaultFilename"  , "%(title)s.%(ext)s");
        //-o '/my/downloads/%(uploader)s/%(title)s-%(id)s.%(ext)s'
        
        
        configProps = defaultProps;
    }
    
    public static void loadProperties(){

        if (!configFile.exists()) {
            loadDefaults();

        } else {

            try {
                configProps = new Properties();
                InputStream inputStream = new FileInputStream(configFile);
                configProps.loadFromXML(inputStream);
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(UserSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
