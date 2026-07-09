/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.sockets_implementados;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stimp
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
            ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO = 5000;
            
        try {    
            servidor = new ServerSocket(PUERTO);
             System.out.println("servidor inicado");
            
           while(true){
           
           sc = servidor.accept();
               System.out.println("cliente conectado");
           in = new DataInputStream(sc.getInputStream());
           out = new DataOutputStream(sc.getOutputStream());
           
           String mensaje = in.readUTF();
           System.out.println(mensaje); 
               
           out.writeUTF("Hola mundo desde el servidor");
               
           sc.close();
               
           System.out.println("cliente desconectado");
               
           }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
}