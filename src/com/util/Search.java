/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.BooManager;
import com.data.YoutubeVideo;
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
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author Jaime Hidalgo García
 */
public class Search implements Runnable {

    private BooGui guiRef;
    List<String> command;
    BooManager boo;
    String query;

    public Search(BooGui guiRef, BooManager boo, String query) {
        this.guiRef = guiRef;
	this.query = query;
	this.boo = boo;
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
        
	command.add("--no-playlist");
	command.add("--skip-download");
	command.add("-j");
	command.add("-s");
	command.add("--ignore-errors");
	command.add("ytsearch15: '" + query + "'");

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

	    boo.currentVideos = new ArrayList<YoutubeVideo>();

	    int i = 0;
            while ((line = r.readLine()) != null) {
                
                logger.append(line + "\n");
                logger.setCaretPosition(logger.getDocument().getLength());

		YoutubeVideo video = jsonToVideo(line);

		if (video != null){
		    boo.currentVideos.add(jsonToVideo(line));
		    this.guiRef.partialReloadInsert(i++);
		}

            }

	    //this.guiRef.reloadAllColumns();

            logger.append("Update completed." + "\n");
            logger.setCaretPosition(logger.getDocument().getLength());

        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            ErrorLogger.toFile("ProcessError", ex.toString());
        }


    }

    public YoutubeVideo jsonToVideo(String resultLine){
	try {
	    //System.out.println(resultLine);
	    Object obj = new JSONParser().parse(resultLine);
	    JSONObject jo = (JSONObject) obj;
	    //System.out.println((String) jo.get("webpage_url"));
	    YoutubeVideo video = new YoutubeVideo();
	    video.setID((String) jo.get("id"));
	    video.setTitle((String) jo.get("title"));
	    video.setUploader((String) jo.get("uploader"));
	    video.setHits(String.valueOf( jo.get("view_count") ));
	    video.setDuration(String.valueOf( jo.get("duration") ));
	    video.setImage((String) jo.get("thumbnail"));
	    video.setVideoUrl(String.valueOf( jo.get("webpage_url") ));
	    return video;
	} catch (ParseException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            ErrorLogger.toFile("ProcessError", ex.toString());
	}
	return null;
    }

    public static void main(String[] args) {


    }



}
