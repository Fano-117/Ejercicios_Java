/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;
/**
 *
 * @author stimp
 */
public class Extraccion {
    
    public static Individuo obtenerMejorIndividuo(Individuo[] poblacion) {
   
          
          
            
            Individuo mejorIndividuo = poblacion[0];
     
      
         
        for (int i = 1; i < poblacion.length; i++) {
            
            if (poblacion[i].getFitness() > mejorIndividuo.getFitness()) {
                mejorIndividuo = poblacion[i];
            }
        
        }
       
        return mejorIndividuo;
    }
}
