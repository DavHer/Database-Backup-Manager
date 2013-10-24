/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David-PC
 */
public class Server {
    
    ServerSocket serverSocket;
    Socket socket;

    public Server() {
        try {
            serverSocket = new ServerSocket(15123);
            
            socket = serverSocket.accept();
            System.out.println("Accepted connection : " + socket);


        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendFile(String path){
        FileInputStream fin = null;
        try {
            File transferFile = new File (path);
            byte [] bytearray  = new byte [(int)transferFile.length()];
            fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            bin.read(bytearray,0,bytearray.length);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...");
            os.write(bytearray,0,bytearray.length);
            os.flush();
            socket.close();
            System.out.println("File transfer complete");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
