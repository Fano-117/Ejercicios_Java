/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sat;

import com.mycompany.sat.Asignacion;
import com.mycompany.sat.Cruza;
import com.mycompany.sat.Extraccion;
import com.mycompany.sat.Individuo;
import com.mycompany.sat.Muta;
import com.mycompany.sat.Seleccion;

/**
 *
 * @author stimp
 */


     public  class hilo1 extends Thread {
          int tamanoPoblacion = 0;
        int filas = 0;
        int columnas = 0;
        int numGeneraciones = 0;
        double tasaMutacion = 0.00;
        
         public void parametros(int tP ,int f , int c ,  int nG ,double tM ){
         tamanoPoblacion = tP;
         filas = f;
         columnas = c;
         numGeneraciones = nG;
         tasaMutacion = tM;
            }            
         //@0verride
                 @Override
                 public void run(){
                 
                 
                
       
        
        Individuo[] poblacion = Asignacion.crearPoblacionInicial(tamanoPoblacion, filas, columnas);
       
        // Evolución de la población
       for (int generacion = 1; generacion <= numGeneraciones; generacion++) {
            // Selección de individuos
           Individuo[] nuevaPoblacion = new Individuo[tamanoPoblacion];
           
           for (int i = 0; i < tamanoPoblacion; i++) {
                Individuo padre1 = Seleccion.seleccionTorneo(poblacion);
                Individuo padre2 = Seleccion.seleccionTorneo(poblacion);
                
            
              Individuo hijo = Cruza.cruce(padre1, padre2);
                Muta.mutacion(hijo, tasaMutacion);
               hijo.getMatriz();
           
                 
              nuevaPoblacion[i] = hijo;
              }
          
         // Reemplazo de la población
           poblacion = nuevaPoblacion;
     
            // Obtener el mejor individuo de la generación actual
       Individuo mejorIndividuo = Extraccion.obtenerMejorIndividuo(poblacion);
               

            // Imprimir información de la generación
           
            System.out.println("Generación " + generacion + ": Mejor fitness = " + mejorIndividuo.getFitness());
        }

        // Obtener el mejor individuo final
        Individuo mejorIndividuoFinal = Extraccion.obtenerMejorIndividuo(poblacion);
        
        // Imprimir información del mejor individuo final
        System.out.println("Mejor individuo final: Fitness = " + mejorIndividuoFinal.getFitness());
        
     
      int[][] matriz2 = mejorIndividuoFinal.getMatriz();
      
      System.out.println("Matriz:");
      
      for (int k = 0; k < 550; k++) {
            for (int j = 0; j < 3; j++) {
               System.out.print(matriz2[k][j] + " ");
            }
            System.out.println();
        } 
                                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    
}
 
            }
