/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sat2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author stimp
 */
public class App {

   
public class AlgoritmoGenetico {

    private static final int NUMERO_FILAS = 550;
    private static final int NUMERO_COLUMNAS = 3;
    private static final int TAMANO_POBLACION = 100;
    private static final int NUMERO_GENERACIONES = 100;
    private static final double PROBABILIDAD_MUTACION = 0.01;

    public static void main(String[] args) {
        int[][] matriz = leerMatrizDesdeArchivo("matriz.txt");

        Individuo[] poblacion = inicializarPoblacion(matriz);
        evaluarFitness(poblacion);

        for (int generacion = 0; generacion < NUMERO_GENERACIONES; generacion++) {
            System.out.println("Generación: " + generacion);
            System.out.println("Mejor fitness: " + obtenerMejorFitness(poblacion));
            System.out.println("-----------------------------");

            Individuo[] seleccionados = seleccionar(poblacion);
            Individuo[] nuevaGeneracion = crearNuevaGeneracion(seleccionados);

            poblacion = nuevaGeneracion;
            evaluarFitness(poblacion);
        }

        System.out.println("Mejor individuo: " + obtenerMejorIndividuo(poblacion));
        System.out.println("Mejor fitness: " + obtenerMejorFitness(poblacion));
    }

    private static int[][] leerMatrizDesdeArchivo(String nombreArchivo) {
        int[][] matriz = new int[NUMERO_FILAS][NUMERO_COLUMNAS];

        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String linea;
                int filaActual = 0;

                while ((linea = bufferedReader.readLine()) != null && filaActual < NUMERO_FILAS) {
                    String[] valores = linea.split(" ");
                    for (int i = 0; i < NUMERO_COLUMNAS; i++) {
                        matriz[filaActual][i] = Integer.parseInt(valores[i]);
                    }
                    filaActual++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return matriz;
    }

    private static Individuo[] inicializarPoblacion(int[][] matriz) {
        Individuo[] poblacion = new Individuo[TAMANO_POBLACION];
        Random random = new Random();

        for (int i = 0; i < TAMANO_POBLACION; i++) {
            Individuo individuo = new Individuo(NUMERO_FILAS);
            for (int j = 0; j < NUMERO_FILAS; j++) {
                individuo.setGen(j, random.nextInt(2));
            }
            poblacion[i] = individuo;
        }

        return poblacion;
    }

    private static void evaluarFitness(Individuo[] poblacion) {
        for (Individuo individuo : poblacion) {
            int fitness = 0;
            for (int fila = 0; fila < NUMERO_FILAS; fila++) {
                boolean filaValida = false;
                for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
                    int valor = individuo.getGen(fila);
                    if (valor >= 0) {
                        if (matriz[fila][columna] == 1) {
                            filaValida = true;
                            break;
                        }
                    } else {
                        if (matriz[fila][columna] == 0) {
                            filaValida = true;
                            break;
                        }
                    }
                }
                if (filaValida) {
                    fitness++;
                }
            }
            individuo.setFitness(fitness);
        }
    }

    private static Individuo[] seleccionar(Individuo[] poblacion) {
        Individuo[] seleccionados = new Individuo[TAMANO_POBLACION];

        // Seleccionar individuos mediante el método de la ruleta
        int totalFitness = obtenerTotalFitness(poblacion);
        Random random = new Random();
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            int acumuladoFitness = 0;
            int r = random.nextInt(totalFitness);
            for (int j = 0; j < TAMANO_POBLACION; j++) {
                acumuladoFitness += poblacion[j].getFitness();
                if (acumuladoFitness > r) {
                    seleccionados[i] = poblacion[j];
                    break;
                }
            }
        }

        return seleccionados;
    }

    private static int obtenerTotalFitness(Individuo[] poblacion) {
        int totalFitness = 0;
        for (Individuo individuo : poblacion) {
            totalFitness += individuo.getFitness();
        }
        return totalFitness;
    }

    private static Individuo[] crearNuevaGeneracion(Individuo[] seleccionados) {
        Individuo[] nuevaGeneracion = new Individuo[TAMANO_POBLACION];
        Random random = new Random();

        for (int i = 0; i < TAMANO_POBLACION; i++) {
            Individuo padre = seleccionados[random.nextInt(TAMANO_POBLACION)];
            Individuo madre = seleccionados[random.nextInt(TAMANO_POBLACION)];
            Individuo hijo = cruzar(padre, madre);
            mutar(hijo);
            nuevaGeneracion[i] = hijo;
        }

        return nuevaGeneracion;
    }

    private static Individuo cruzar(Individuo padre, Individuo madre) {
        Individuo hijo = new Individuo(NUMERO_FILAS);
        Random random = new Random();

        for (int i = 0; i < NUMERO_FILAS; i++) {
            if (random.nextDouble() < 0.5) {
                hijo.setGen(i, padre.getGen(i));
            } else {
                hijo.setGen(i, madre.getGen(i));
            }
        }

        return hijo;
    }

    private static void mutar(Individuo individuo) {
        Random random = new Random();
        for (int i = 0; i < NUMERO_FILAS; i++) {
            if (random.nextDouble() < PROBABILIDAD_MUTACION) {
                int gen = individuo.getGen(i);
                individuo.setGen(i, 1 - gen); // Cambiar el valor del gen (0 a 1 o 1 a 0)
            }
        }
    }

    private static int obtenerMejorFitness(Individuo[] poblacion) {
        int mejorFitness = Integer.MIN_VALUE;
        for (Individuo individuo : poblacion) {
            if (individuo.getFitness() > mejorFitness) {
                mejorFitness = individuo.getFitness();
            }
        }
        return mejorFitness;
    }

    private static Individuo obtenerMejorIndividuo(Individuo[] poblacion) {
        Individuo mejorIndividuo = null;
        int mejorFitness = Integer.MIN_VALUE;
        for (Individuo individuo : poblacion) {
            if (individuo.getFitness() > mejorFitness) {
                mejorFitness = individuo.getFitness();
                mejorIndividuo = individuo;
            }
        }
        return mejorIndividuo;
    }

}

class Individuo {
    private int[] genes;
    private int fitness;

    public Individuo(int longitud) {
        genes = new int[longitud];
    }

    public int getGen(int indice) {
        return genes[indice];
    }

    public void setGen(int indice, int valor) {
        genes[indice] = valor;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int gen : genes) {
            sb.append(gen);
        }
        return sb.toString();
    }
}

}
