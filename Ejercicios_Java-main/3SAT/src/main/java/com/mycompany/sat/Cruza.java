/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;
/**
 *
 * @author stimp
 */
public class Cruza {
     
    public static Individuo cruce(Individuo padre1, Individuo padre2) {
          int filas = 550;
        int columnas = 3;
        int[][] x = new int [filas][columnas];
          
        Individuo hijo = new Individuo(filas, columnas);
        
         for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if((padre1.getMatriz()[i][j]==1)&&(padre2.getMatriz()[i][j]==1)){
                x[i][j] = padre1.getMatriz()[i][j] * padre2.getMatriz()[i][j];
                }else if((padre1.getMatriz()[i][j]==1)&&(padre2.getMatriz()[i][j]==0)){
                 x[i][j] = 1;
                }else if((padre1.getMatriz()[i][j]==0)&&(padre2.getMatriz()[i][j]==1)){
                 x[i][j] = 0;
                }else if((padre1.getMatriz()[i][j]==0)&&(padre2.getMatriz()[i][j]==0)){
                 x[i][j] = padre1.getMatriz()[i][j] + padre2.getMatriz()[i][j];
                }
            
            }
        
}   
    // hijo.evaluarFitness();
     
     hijo.setMatriz(x);
     hijo.setFitness();
        return hijo;

}}
