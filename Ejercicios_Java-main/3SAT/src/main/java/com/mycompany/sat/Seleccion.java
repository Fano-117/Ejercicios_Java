/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;
import java.util.Random;
/**
 *
 * @author stimp
 */
public class Seleccion {
    
     public static Individuo seleccionTorneo(Individuo[] poblacion) {
       
         
         Random random = new Random();
        
        int indice1 = random.nextInt(poblacion.length);
        int indice2 = random.nextInt(poblacion.length);

        Individuo individuo1 = poblacion[indice1];
        Individuo individuo2 = poblacion[indice2];

     
        return individuo1.getFitness() > individuo2.getFitness() ? individuo1 : individuo2;
    }
}
