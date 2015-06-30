package com.network;

import com.data.YoutubeVideo;
import com.io.ErrorLogger;
import com.exception.ConnectionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author JaimehRubiks
 */
public class TCPsocket {
    
    private static final int port = 8000;
    private static final String hostname = "localhost";
    private Socket comSocket;
    private ObjectOutputStream txBuffer;
    private ObjectInputStream rxBuffer;
    
     public TCPsocket() throws ConnectionException{
        this(hostname,port);
    }
    
    public TCPsocket(String hostname, int port) throws ConnectionException{
        try{
            comSocket = new Socket();
            comSocket.connect(new InetSocketAddress(hostname, port), 2000);
            txBuffer = new ObjectOutputStream(comSocket.getOutputStream());
            rxBuffer = new ObjectInputStream(comSocket.getInputStream());
        } catch(IllegalArgumentException iae){
            throw new ConnectionException("*Port number must be between 0 and 65535, inclusive. Use a port > 1023");
        } catch(UnknownHostException uhe){
            closeConnection();
            throw new ConnectionException("*IP address could not be determined from given hostname");
        } catch(IOException ioe){
            closeConnection();
            throw new ConnectionException("*Error connecting to given server. Is server running?");
        } catch(Exception e){
            closeConnection();
            ErrorLogger.toFile("*UnknownError creating TCP socket");
        }
    }
    
    public TCPsocket(Socket comSocket){
        try{
            this.comSocket = comSocket;
            txBuffer = new ObjectOutputStream(comSocket.getOutputStream());
            rxBuffer = new ObjectInputStream(comSocket.getInputStream());
        } catch(UnknownHostException uhe){
            ErrorLogger.toScreen(uhe.toString());
            closeConnection();
        } catch(IOException ioe){
            ErrorLogger.toFile(ioe.toString());
            closeConnection();
        } 
    }

    
    public final void closeConnection(){
        try{
            if(rxBuffer != null)
                rxBuffer.close();
        }catch(Exception e){
            ErrorLogger.toFile("Log",e.toString());
        }
        try{
            if(txBuffer != null)
                txBuffer.close();
        }catch(Exception e){
            ErrorLogger.toFile("Log",e.toString());
        }
        try{
            if(comSocket != null)
                comSocket.close();
        }catch(Exception e){
            ErrorLogger.toFile("Log",e.toString());
        }
           
    }
            
    public void checkConnection() throws ConnectionException{
        boolean check = comSocket.isClosed();
        
        if(check == true){
            closeConnection();
            throw new ConnectionException("Connection is closed");
        }
        
    }        
    
    public void sendBYTE(int op){
        try {
            txBuffer.writeByte(op);
        } catch (IOException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getBYTE(){
        int op = 0;
        try {
            op = (int) rxBuffer.readByte();
        } catch (IOException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return op;
    }
    
    public void sendSTRING(String str){
        try {
            txBuffer.writeObject(str);
        } catch (IOException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getSTRING(){
        String str = "null";
        try {
            str = (String) rxBuffer.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    public void sendVIDEO(YoutubeVideo video){
        try {
            txBuffer.writeObject(video);
        } catch (IOException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public YoutubeVideo getVIDEO(){
        YoutubeVideo video = null;
        try {
            video = (YoutubeVideo) rxBuffer.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TCPsocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return video;
    }
    
    
    
    public String getAddrs(){
        return comSocket.getInetAddress().getHostAddress();
    }
    
}