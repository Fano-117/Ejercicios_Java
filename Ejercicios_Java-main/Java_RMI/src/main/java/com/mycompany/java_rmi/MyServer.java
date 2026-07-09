import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import funcion.MyRemoteInterface;
import funcion.MyRemoteImplementation;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_rmi;

/**
 *
 * @author stimp
 */

public class MyServer {
    public static void main(String[] args) {
        try {
            MyRemoteInterface myRemoteObject = new MyRemoteImplementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("myRemoteObject", myRemoteObject);
            System.out.println("Servidor remoto listo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}