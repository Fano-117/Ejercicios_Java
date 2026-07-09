/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;

/**
 *
 * @author stimp
 */
public class Asignacion {
    public static Individuo[] crearPoblacionInicial(int tamanoPoblacion, int filas, int columnas) {
        
        Individuo[] poblacion = new Individuo[tamanoPoblacion];
        
        for (int i = 0; i < tamanoPoblacion; i++) {
            Individuo individuo = new Individuo(filas, columnas);
            individuo.generarMatriz();
            individuo.evaluarFitness();
            individuo.getMatriz();
            poblacion[i] = individuo;
            
         
        }       
  
        return poblacion;
    }
}
