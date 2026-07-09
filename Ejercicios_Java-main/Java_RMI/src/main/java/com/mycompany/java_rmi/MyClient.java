import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

public class MyClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyRemoteInterface myRemoteObject = (MyRemoteInterface) registry.lookup("myRemoteObject");
            System.out.println(myRemoteObject.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}