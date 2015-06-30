/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.io.Serializable;

/**
 *
 * @author Jaime
 */
public class YoutubeVideo implements Serializable {
    
    private String videoId;
    private String videoName;
    private String videoDur;
    private String imageUrl;
    private String uploader;
    private String hits;
    
    //private String 
    
    public YoutubeVideo(){};
    
    public void setID(String id){
        videoId = id;
    }
    
    public String getID(){
        return videoId;
    }
    
    public void setTitle(String name){
        videoName = name;
    }
    
    public String getTitle(){
        return videoName;
    }
    
    public void setDuration(String dur){
        videoDur = dur;
    }
    
    public String getDuration(){
        return videoDur;
    }
    
    public void setImage(String img){
        imageUrl = img;
    }
    
    public String getImg(){
        return imageUrl;
    }
    
    public void setUploader(String up){
        uploader = up;
    }
    
    public String getUploader(){
        return uploader;
    }
    
    public void setHits(String hit){
        hits = hit;
    }
    
    public String getHits(){
        return hits;
    }
    
    
    
}
