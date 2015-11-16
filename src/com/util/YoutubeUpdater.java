/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.gui.BooGui;
import com.io.ErrorLogger;
import com.io.UserSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Jaime Hidalgo García
 */
public class YoutubeUpdater implements Runnable {

    private BooGui guiRef;
    List<String> command;

    public YoutubeUpdater(BooGui guiRef) {
        this.guiRef = guiRef;

    }
    
    private void loadCommandParams() {

        command = new ArrayList<>();

        //PATH TO YOUTUBE-DL
        if (platformtools.isWindows())
            command.add(new java.io.File("").getAbsolutePath()+"/tools/youtube-dl.exe");
        else if (platformtools.isMac())
            command.add( new java.io.File("").getAbsolutePath()+"/osxtools/youtube-dl");
        else if(platformtools.isUnix())
            command.add( new java.io.File("").getAbsolutePath()+"/linuxtools/youtube-dl");
        
        command.add("-U");
    }

    @Override
    public void run() {
        //System.out.println("downref->"+downRef);
        loadCommandParams();
        JTextArea logger = guiRef.getLogOutput();

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            
            if (platformtools.isMac()){
                Map<String, String> env = builder.environment();
                env.put("PATH", env.get("PATH") + ":" + new java.io.File("").getAbsolutePath() + "/osxtools/");
            }
            else if (platformtools.isUnix()){
                Map<String, String> env = builder.environment();
                env.put("PATH", env.get("PATH") + ":" + new java.io.File("").getAbsolutePath() + "/linuxtools/");
            }

            builder.directory( new File( UserSettings.configProps.getProperty("DownloadsFolder") ) );
            builder.redirectErrorStream(true);

            Process p = builder.start();
            
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String lines[];

            while ((line = r.readLine()) != null) {
                
                logger.append(line + "\n");
                logger.setCaretPosition(logger.getDocument().getLength());
            }

            logger.append("Update completed." + "\n");
            logger.setCaretPosition(logger.getDocument().getLength());

        } catch (IOException ex) {
            Logger.getLogger(YoutubeUpdater.class.getName()).log(Level.SEVERE, null, ex);
            ErrorLogger.toFile("ProcessError", ex.toString());
        }


    }

    public static void main(String[] args) {


    }



}
