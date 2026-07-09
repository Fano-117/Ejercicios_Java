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
public class Muta {
    public static void mutacion(Individuo individuo, double tasaMutacion) {
         int filas = 550;
        int columnas = 3;
        int[][] x = new int [filas][columnas];
        Random random = new Random();
        
        
        for (int i = 0; i < 550; i++) {
          
            for (int j = 0; j < 3; j++) {
                
               
                if (random.nextDouble() < tasaMutacion) {
                    
                     individuo.getMatriz()[i][j] = 1;
                   
                }
                
            }
        }
       
    }
}
