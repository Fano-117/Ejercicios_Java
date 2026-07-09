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
public class cliente {
    public static void main(String[] args) {
        try{
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",3000);
        Interface anInterface = (Interface) registry.lookup("calculadoira");
        float resultadoSuma = anInterface.suma(20,30);
            System.out.println("resultadoSuma="+ resultadoSuma);
        
        
        }catch(Exception e){
            System.out.println("Error =" + e.getMessage());}
    }
}
