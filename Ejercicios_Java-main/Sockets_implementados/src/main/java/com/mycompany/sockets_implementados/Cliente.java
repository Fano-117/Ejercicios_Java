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
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
            final String HOST="127.0.0.1";
            final int PUERTO = 5000;
            DataInputStream in;
            DataOutputStream out;
            
        try {    
            Socket sc = new Socket(HOST,PUERTO);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
           
            out.writeUTF("Hola mundo desde el cliente");
            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
}}
