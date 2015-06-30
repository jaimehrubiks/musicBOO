/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.data.YoutubeVideo;
import com.exception.ConnectionException;
import com.gui.BooGui;
import com.network.NetOperations;
import com.network.TCPsocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime
 */
public class BooManager {

    /**
     * @param args the command line arguments
     */
    
    public static String hostName   = "eldoctordeldesierto.com";
    public static int    portNumber = 7585;
    
    public List<YoutubeVideo> currentVideos;
    public List<YoutubeVideo> urlVideos;
    private BooGui guiRef;
    
    public BooManager(){}
    
    public void setGuiRef(BooGui ref){
        guiRef = ref;
    }
    
    public void newSearch(String query){
        
        try {
            TCPsocket socket = new TCPsocket(hostName,portNumber);
            
            socket.sendBYTE(NetOperations.KEYWORD_SEARCH_QUERY);
            socket.sendSTRING(query);
            
            currentVideos = new ArrayList<>();
            
            int numResult = socket.getBYTE();
            
            for(int i = 0 ; i < numResult ; i++){
                
                currentVideos.add( socket.getVIDEO() );
                guiRef.partialReloadInsert(i);
                
            }
            
            socket.closeConnection();
            
        } catch (ConnectionException ex) {
            Logger.getLogger(BooManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void newVideoGet(String videoID){
        
        try {
            TCPsocket socket = new TCPsocket(hostName,portNumber);
            
            socket.sendBYTE(NetOperations.VIDEOID_GET_QUERY);
            socket.sendSTRING(videoID);
            
            urlVideos = new ArrayList<>();
            
            int numResult = socket.getBYTE();
            guiRef.updateParseVarMax(numResult+1);
            
            for(int i = 0 ; i < numResult ; i++){
                
                urlVideos.add( socket.getVIDEO() );
                guiRef.updateParseBar();
                
            }
            
            socket.closeConnection();
            
        } catch (ConnectionException ex) {
            Logger.getLogger(BooManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        guiRef.startURLvideos();
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        BooManager boo = new BooManager();
        
        boo.newSearch("Harakiri");
        
        for(YoutubeVideo video : boo.currentVideos ){
            
            System.out.println("ID: " + video.getID());
            System.out.println("Title: " + video.getTitle());
            
        }
        
    }
    
}
