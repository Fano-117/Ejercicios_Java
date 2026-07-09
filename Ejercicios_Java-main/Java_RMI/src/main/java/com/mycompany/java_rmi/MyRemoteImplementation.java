import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import funcion.MyRemoteInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_rmi;

/**
 *
 * @author stimp
 */

public class MyRemoteImplementation extends UnicastRemoteObject implements MyRemoteInterface {
    public MyRemoteImplementation() throws RemoteException {
        super();
    }
    
    public String sayHello() throws RemoteException {
        return "Hola desde el servidor remoto!";
    }
}