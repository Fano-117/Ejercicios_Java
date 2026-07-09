/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author stimp
 */
public class servidor {
    public static void main(String[] args) {
        try{
        Registry registry = LocateRegistry.createRegistry(3000);
        Interface anInterface = new ImplementarInterface();
        registry.bind("calculadoira",anInterface);
            System.out.println("servidor corriendo en el puerto 3000");
        }catch(Exception e){
            System.out.println("e.getMnesaje()="+e.getMessage());
        }
    }
}
