/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import static com.alee.managers.style.SupportedComponent.textArea;
import com.gui.BooGui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


/**
 *
 * @author jaime
 */
public class AudioPlayer{
    
    private static boolean block = false;
    private BooGui guiRef;
    private String httpLink;
    
    public AudioPlayer(BooGui guiRef){
        this.guiRef = guiRef;
    }
    
    public void setID(String id){
        httpLink = Functions.genLink(id);
    }
    
    public void play(){
        
        if (block == true) return;
        else               block = true;
        
        final JTextArea logger = guiRef.getLog1Output();
        
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {

                    ProcessBuilder pb = new ProcessBuilder();

                    List<String> command = new ArrayList<>();
                    if(platformtools.isWindows())
                        command.add("./tools/mpv.com");
                    else if(platformtools.isMac())
                        command.add("./osxtools/mpv");
                    else if(platformtools.isUnix())
                        command.add("mpv");
                    command.add("-ytdl");
                    command.add(httpLink);

                    pb.command(command);
                    pb.redirectErrorStream(true);
                    pb.redirectError(new File("./config/error.txt"));

                    

                    Process p;
                    p = pb.start();
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String str;
                    
                    while( (str = br.readLine()) !=null ){
                        logger.setText("");
                        logger.append(str);
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } finally{
                    block = false;
                }


                
                logger.setText("End of Stream.");
                
            }
        });
        
        

    }
    
    
}


