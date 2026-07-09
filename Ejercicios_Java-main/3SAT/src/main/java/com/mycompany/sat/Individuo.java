/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
/**
 *
 * @author stimp
 */
public class Individuo {
   public int[][] matriz;
   public int fitness;
   public int [][] x;
   public int [][] x2 = new int[550][3];
   public int filas = 550;
   public int columnas = 3;
   static int[] Fitness = new int[200];
   static int[] FitnessAux = new int[100];
     
     
     
     
     
   public Individuo(int filas, int columnas) {
        matriz = new int[filas][columnas];
        fitness = 0;
    }
   
    public void generarMatriz() {
        
    //Extraer matriz y tokens:
    
    String Tokens = "C:\\Users\\stimp\\OneDrive\\Documentos\\escuela\\8vo semestre\\Algoritmos Geneticos\\tareas\\Tokens.txt"; // Nombre del archivo de texto
        
        try {
          
    FileReader fileReader = new FileReader(Tokens);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            x = new int[filas][columnas];
            String linea;
            int filaActual = 0;
            
            while ((linea = bufferedReader.readLine()) != null && filaActual < filas) {
                String[] valores = linea.split(" ");
                for (int i = 0; i < columnas; i++) {
                    x[filaActual][i] = Integer.parseInt(valores[i]);
                }
                filaActual++;
            }   }
          
          } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        //randomizador:
        
        Random random = new Random();
    
    for (int i = 0; i < FitnessAux.length; i++) {
            FitnessAux[i] = random.nextInt(2); // Genera un número aleatorio entre 0 y 1
            
        }

       System.arraycopy(FitnessAux, 0, Fitness, 0, FitnessAux.length); // Asigna el valor contrario (0 si es 1, y viceversa)
         
         for (int i = 100; i < Fitness.length; i++) {
            Fitness[i] = 1 - FitnessAux[i-100]; // Asigna el valor contrario (0 si es 1, y viceversa)
        }
     
        //generar matriz:
        fitness = 0;
   int cien = 100;
  for (int i = 0; i < matriz.length; i++) {
                for (int z = 0; z < matriz[0].length; z++) {
                    
                    if(x[i][z]<0){
                       if(Fitness[((-(x[i][z]))+cien)]==1){
                    matriz[i][z]=1;
                   }else{
                   matriz[i][z]=0;
                       }
                    }else if(x[i][z]>0){
                       
                    if(Fitness[x[i][z]]==1){
                     matriz[i][z]=1;
                   }else{
                   matriz[i][z]=0;
                       }
                    }
                }
        }
    
    }
    
   public void evaluarFitness() {
   int w=0;
   int cien = 100;
        for(int j=0;j<x.length;j++){
           // System.out.println(" ");
      for(int y=0;y<x[0].length;y++){
          if(x[j][y]>0){
               x2[j][y]=x[j][y];
           }
           else if(x[j][y]<0){
          x2[j][y]=((-(x[j][y]))+cien);
          }
      }
        }
     for(int j=0;j<filas;j++){
    
        w=0;
      if(w==0){
         if(Fitness[x2[j][w]]==1||Fitness[x2[j][w+1]]==1||Fitness[x2[j][w+2]]==1){
              fitness++;
         w++;
          }else{
         w=0;
         }
      }
   }
  }
  
    

    public void setMatriz(int[][] nuevaMatriz) {
        matriz = new int[nuevaMatriz.length][nuevaMatriz[0].length];
        for (int i = 0; i < nuevaMatriz.length; i++) {
            for (int j = 0; j < nuevaMatriz[0].length; j++) {
                matriz[i][j] = nuevaMatriz[i][j];
            }
        }
        
    }

public void setFitness(){
for(int j=0;j<filas;j++){
    
      int   w=0;
       if(w==0){
          if(matriz[j][w]==1||matriz[j][w+1]==1||matriz[j][w+2]==1){
               fitness++;
          w++;
           }else{
          w=0;
          }
       }
   }
}

   public int getFitness() {
        return fitness;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
